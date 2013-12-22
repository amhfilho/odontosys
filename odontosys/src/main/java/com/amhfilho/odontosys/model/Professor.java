package com.amhfilho.odontosys.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa {

	private static final long serialVersionUID = -4764729333535290062L;
	
	private String cro;

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	@Override
	public String toString() {
		return super.toString()+ " [cro=" + cro + "]";
	}
	
	

}
