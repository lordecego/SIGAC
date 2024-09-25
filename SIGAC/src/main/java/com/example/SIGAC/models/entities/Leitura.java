package com.example.SIGAC.models.entities;

import java.time.LocalDateTime;

import com.example.SIGAC.models.form.LeituraForm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leitura")

public class Leitura {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pressao_arterial", nullable = false)
    private String pressaoArterial;

    @Column(name = "temperatura", nullable = false)
    private Double temperatura;

    @Column(name = "batimento_cardiaco", nullable = false)
    private Integer batimentoCardiaco;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
    
 // Relacionamento com Equipamento: Uma leitura pertence a um equipamento
    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private Equipamento equipamento;
    
    public Leitura() {}

    // Construtor com parâmetros
    public Leitura(String pressaoArterial, Double temperatura, Integer batimentoCardiaco, LocalDateTime dataHora) {
        this.pressaoArterial = pressaoArterial;
        this.temperatura = temperatura;
        this.batimentoCardiaco = batimentoCardiaco;
        this.dataHora = dataHora;
     
    }
    
    public Leitura(LeituraForm form) {
    	
    	this.batimentoCardiaco = form.getBatimentoCardiaco();
    	this.pressaoArterial = form.getPressaoArterial();
    	this.temperatura = form.getTemperatura();
    	this.dataHora = LocalDateTime.now();
    	this.equipamento = new Equipamento(form.getEquipamento_id());
    	
    	
    }

    // Getters e Setters
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
    
    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

	
}
