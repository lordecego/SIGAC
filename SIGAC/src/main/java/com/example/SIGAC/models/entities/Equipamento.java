package com.example.SIGAC.models.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipamento")

public class Equipamento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "numero_serie", nullable = false, unique = true)
    private String numeroSerie;

    // Relacionamento com Paciente: Muitos equipamentos podem pertencer a um paciente
    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // Relacionamento com Leitura: Um equipamento pode gerar várias leituras
    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Leitura> leituras;
    
    public Equipamento() {}
    
    public Equipamento(Long id, String numeroSerie, Paciente paciente) {
        this.numeroSerie = numeroSerie;
        this.paciente = paciente;
        this.id = id;
    }

    public Equipamento(Long equipamento_id) {
		this.id = equipamento_id;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Leitura> getLeituras() {
        return leituras;
    }

    public void setLeituras(List<Leitura> leituras) {
        this.leituras = leituras;
    }
	
}
