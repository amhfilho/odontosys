package com.amhfilho.odontosys.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity 
@Table(name="pessoa")
@Inheritance
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 3557677982384299839L;

	@Id
    @GeneratedValue
    private Long id;
	
	@Column
	private String nome;
	@Column
	private Date dataNascimento;
	@Column
	private String email;
	@Column
	private String endereco;
	@Column
	private String numero;
	@Column
	private String cidade;
	@Column
	private String cep;
	@Column(length=2)
	private String estado;
	@Column
	private String telefoneResidencial;
	@Column
	private String telefoneComercial;
	@Column
	private String telefoneCelular;
	@Column
	private String cpf;
	@Column
	private String rg;
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", endereco="
				+ endereco + ", numero=" + numero + ", cidade=" + cidade
				+ ", cep=" + cep + ", estado=" + estado
				+ ", telefoneResidencial=" + telefoneResidencial
				+ ", telefoneComercial=" + telefoneComercial
				+ ", telefoneCelular=" + telefoneCelular + ", cpf=" + cpf
				+ ", rg=" + rg + "]";
	}



	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}



	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}



	public String getTelefoneComercial() {
		return telefoneComercial;
	}



	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}



	public String getTelefoneCelular() {
		return telefoneCelular;
	}



	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}
	
	

}
