package com.example.SIGAC.models.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paciente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String dataNascimento;
	private int idade;
	
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
	
}
