package com.example.SIGAC.models.form;

import jakarta.persistence.Column;

public class LeituraForm {

	  
	    private String pressaoArterial;

	    
	    private Double temperatura;

	    
	    private Integer batimentoCardiaco;
	    
	    private Long equipamento_id;
	    
	    public LeituraForm() {
			// TODO Auto-generated constructor stub
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

		public Long getEquipamento_id() {
			return equipamento_id;
		}

		public void setEquipamento_id(Long equipamento_id) {
			this.equipamento_id = equipamento_id;
		}
	    
	    
}
