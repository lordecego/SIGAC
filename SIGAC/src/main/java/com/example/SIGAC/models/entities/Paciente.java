package com.example.SIGAC.models.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Paciente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String dataNascimento;
	private int idade;
	
	@OneToOne
	private Equipamento equipamento;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
	public Paciente(String nome, String dataNascimento, String idade) {
		this.nome = nome;
		
		if( dataNascimento != "" ) {
			
			this.dataNascimento = dataNascimento;
		}
		
		if( idade != "" ) {
			
			this.idade = Integer.parseInt(idade.split("\\.")[0]);
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
}
