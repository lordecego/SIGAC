package com.example.SIGAC.models.dto;

public class MetricasPacientesDto {

	private Long naoInformaram;
	private Long de1a18;
	private Long de19a40;
	private Long maiorQue40;
	
	 public MetricasPacientesDto(Long naoInformaram, Long de1a18, Long de19a40, Long maiorQue40) {
		this.naoInformaram = naoInformaram;
		this.de1a18 = de1a18;
		this.de19a40 = de19a40;
		this.maiorQue40 = maiorQue40;
	}
	
	public Long getNaoInformaram() {
		return naoInformaram;
	}
	public void setNaoInformaram(Long naoInformaram) {
		this.naoInformaram = naoInformaram;
	}
	public Long getDe1a18() {
		return de1a18;
	}
	public void setDe1a18(Long de1a18) {
		this.de1a18 = de1a18;
	}
	public Long getDe19a40() {
		return de19a40;
	}
	public void setDe19a40(Long de19a40) {
		this.de19a40 = de19a40;
	}
	public Long getMaiorQue40() {
		return maiorQue40;
	}
	public void setMaiorQue40(Long maiorQue40) {
		this.maiorQue40 = maiorQue40;
	}
	
	
	
}
