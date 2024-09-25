package com.example.SIGAC.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIGAC.models.entities.Equipamento;
import com.example.SIGAC.models.entities.Paciente;
import com.example.SIGAC.repository.EquipamentoRepository;
import com.example.SIGAC.repository.PacienteRepository;

@Service

public class CargaService {

	@Autowired 
	PacienteRepository pacienteRepository;
	
	@Autowired 
	EquipamentoRepository equipamentoRepository;
	
	public String carga() {
		String excelFileURL = "https://docs.google.com/spreadsheets/d/1x7zExjMzA3Tpe1LotlNivbc-SWs4YF1aEL_wEyzWuD4/export?format=xlsx";
        String outputFilePath = "planilha.xlsx"; // Caminho para salvar temporariamente o arquivo

        // Fazer o download do arquivo Excel
        try {
            downloadFileFromURL(excelFileURL, outputFilePath);
            // Processar o arquivo Excel
            processExcelFile(outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return "carga";
	}
	
	 public static void downloadFileFromURL(String fileURL, String outputFilePath) throws IOException {
	        URL url = new URL(fileURL);
	        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	        int responseCode = httpConn.getResponseCode();

	        // Verifica se a conexão foi bem-sucedida
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            InputStream inputStream = httpConn.getInputStream();
	            FileOutputStream outputStream = new FileOutputStream(outputFilePath);

	            int bytesRead = -1;
	            byte[] buffer = new byte[4096];
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }

	            outputStream.close();
	            inputStream.close();

	            System.out.println("Arquivo baixado com sucesso: " + outputFilePath);
	        } else {
	            System.out.println("Erro ao baixar o arquivo. Resposta do servidor: " + responseCode);
	        }
	        httpConn.disconnect();
	    }

	    // Método para processar o arquivo Excel baixado
	 public void processExcelFile(String excelFilePath) {
	        FileInputStream fileInputStream = null;
	        Workbook workbook = null;

	        try {
	            fileInputStream = new FileInputStream(excelFilePath);
	            workbook = new XSSFWorkbook(fileInputStream);

	            // Acessa a primeira planilha do arquivo Excel
	            Sheet sheet = workbook.getSheetAt(0);

	            // Itera sobre as linhas da planilha
	            Iterator<Row> rowIterator = sheet.iterator();
	            
	            rowIterator.next();
	            rowIterator.next();
	            
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();

	                // Verifica se as células não estão nulas e captura os valores corretamente
	                Cell nomeCell = row.getCell(1);
	                Cell dataNascimentoCell = row.getCell(2);
	                Cell idadeCell = row.getCell(3);

	                String nome = nomeCell != null ? getCellValueAsString(nomeCell) : "" ;
	                String dataNascimento = getCellValueAsString(dataNascimentoCell);
	                String idade = getCellValueAsString(idadeCell);
	                
	                if (nome !="" ){
	                	
	                	criarPaciente(nome, dataNascimento, idade);
	                	
	                	// Exibe os dados
	                	System.out.println("Nome: " + nome);
	                	System.out.println("Data de Nascimento: " + dataNascimento);
	                	System.out.println("Idade: " + idade);
	                	System.out.println("-------------------------");
	                	
	                	
	                }
	                
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            // Fecha o arquivo e o workbook
	            try {
	                if (workbook != null) {
	                    workbook.close();
	                }
	                if (fileInputStream != null) {
	                    fileInputStream.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Método auxiliar para obter o valor de uma célula como string, tratando diferentes tipos e células nulas
	    private static String getCellValueAsString(Cell cell) {
	        if (cell == null) {
	            return ""; // Retorna uma string vazia se a célula for nula
	        }

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    return cell.getDateCellValue().toString(); // Retorna como string se for uma data
	                } else {
	                    return String.valueOf(cell.getNumericCellValue()); // Retorna como string numérica
	                }
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case FORMULA:
	                return cell.getCellFormula();
	            case BLANK:
	                return "";
	            default:
	                return "Tipo de célula desconhecido";
	        }
	    }
	    
	    public Paciente criarPaciente(String nome, String dataNascimento, String idade) {
	    	
	    	return pacienteRepository.save(new Paciente(nome, dataNascimento, idade));
	    	
	    }

		public String cargaPaciente() {
			Paciente paciente = new Paciente(
					"Abraão Da Silva", 
					"12/08/1972",
					"52"
					);
			
			pacienteRepository.save(paciente);
			
			Equipamento equipamento = new Equipamento(
					1L,
					"3B12A54",
					paciente
					);
			equipamentoRepository.save(equipamento);
			return "1";
		}
	    
}
