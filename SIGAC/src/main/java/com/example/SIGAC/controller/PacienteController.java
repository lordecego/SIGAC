package com.example.SIGAC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SIGAC.models.dto.MetricasPacientesDto;
import com.example.SIGAC.service.PacienteService;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

	@Autowired
	PacienteService pacienteService;
	
	@GetMapping("/metricas")
	public MetricasPacientesDto getMetricas() {
		
		return pacienteService.getMetricas();
		
	}
	
}
