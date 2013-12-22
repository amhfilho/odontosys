package com.amhfilho.odontosys.model;

import javax.persistence.Entity;

@Entity
public class Instrutor extends Pessoa {

	private static final long serialVersionUID = 2139412475233091496L;
	
	private String cro;

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}
	

}
