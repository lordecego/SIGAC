package com.example.SIGAC.models.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.SIGAC.models.entities.Leitura;

public class LeituraDto {

	
	    private Long id;

	    private String pressaoArterial;

	    private Double temperatura;

	    private Integer batimentoCardiaco;

	    private LocalDateTime dataHora;
	    
	    public LeituraDto(Leitura leitura) {
	    	
	    	this.id = leitura.getId();
	    	this.pressaoArterial = leitura.getPressaoArterial();
	    	this.temperatura = leitura.getTemperatura();
	    	this.batimentoCardiaco = leitura.getBatimentoCardiaco();
	    	this.dataHora = leitura.getDataHora();
	    	
		}
	    
	    public static List<LeituraDto> convert(List<Leitura> leituras){
			return leituras.stream().map(LeituraDto::new).collect(Collectors.toList());
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPressaoArterial() {
			return pressaoArterial;
		}

		public void setPressaoArterial(String pressaoArterial) {
			this.pressaoArterial = pressaoArterial;
		}

		public Double getTemperatura() {
			return temperatura;
		}

		public void setTemperatura(Double temperatura) {
			this.temperatura = temperatura;
		}

		public Integer getBatimentoCardiaco() {
			return batimentoCardiaco;
		}

		public void setBatimentoCardiaco(Integer batimentoCardiaco) {
			this.batimentoCardiaco = batimentoCardiaco;
		}

		public LocalDateTime getDataHora() {
			return dataHora;
		}

		public void setDataHora(LocalDateTime dataHora) {
			this.dataHora = dataHora;
		}
	    
	    
	
}
