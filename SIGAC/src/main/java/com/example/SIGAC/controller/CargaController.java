package com.example.SIGAC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SIGAC.service.CargaService;

@RestController
@RequestMapping("/carga")
public class CargaController {
	@Autowired
	private CargaService cargaService; 
	
	@GetMapping
	public String carga() {
		return cargaService.carga();
	}
	
}
