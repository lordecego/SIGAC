package com.example.SIGAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SIGAC.models.dto.MetricasPacientesDto;
import com.example.SIGAC.repository.PacienteRepository;

@Service

public class PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;
	
	public MetricasPacientesDto getMetricas() {
		
		Long naoInformaram = pacienteRepository.countPacientesIdadeIgual(0);
		Long de1a18 = pacienteRepository.countPacientesEntreIdade(1, 18);
		Long de19a40 = pacienteRepository.countPacientesEntreIdade(19, 40);
		Long maiorQue40 = pacienteRepository.countPacientesIdadeMaiorQue(40);
		
		return new MetricasPacientesDto (naoInformaram, de1a18, de19a40, maiorQue40);
	}
	
}
