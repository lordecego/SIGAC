package com.example.SIGAC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIGAC.models.dto.LeituraDto;
import com.example.SIGAC.models.entities.Leitura;
import com.example.SIGAC.models.form.LeituraForm;
import com.example.SIGAC.repository.LeituraRepository;

@Service

public class LeituraService {
	
	@Autowired
	LeituraRepository leituraRepository;

	public Boolean criarLeitura(LeituraForm form) {
		
		Leitura leitura = new Leitura(form);
		
		leituraRepository.save(leitura);
		
		return Boolean.TRUE;
	}

	public List<LeituraDto> pegarLeituras(Long equipamentoId) {
		
		List<Leitura> leituras = leituraRepository.findByEquipamentoId(equipamentoId);
		
		return LeituraDto.convert(leituras);
	}

}
