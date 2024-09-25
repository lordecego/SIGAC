package com.example.SIGAC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SIGAC.models.dto.LeituraDto;
import com.example.SIGAC.models.form.LeituraForm;
import com.example.SIGAC.service.LeituraService;

@RestController
@RequestMapping("/leitura")


public class LeituraController {


	@Autowired
	LeituraService leituraService;
	
	@PostMapping
	public Boolean criarLeitura(@RequestBody LeituraForm form) {
		
		return leituraService.criarLeitura(form);
		
	}
	
	@GetMapping("/{equipamentoId}")
	public List<LeituraDto> pegarLeituras(@PathVariable Long equipamentoId) {
		
		return leituraService.pegarLeituras(equipamentoId);
		
	}
	
}
