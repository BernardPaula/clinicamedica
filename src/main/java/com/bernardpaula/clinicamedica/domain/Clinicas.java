package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Clinicas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_clinica;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max = 40, message = "O tamanho deve ser entre 5 e 40 caracteres")
	private String nm_clinica;
	
	private Integer nr_cnpj;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min=5, max = 50, message = "O tamanho deve ser entre 5 e 50 caracteres")
	private String ds_especialidades;
	
	private String ds_endereco;
	private Integer nr_numero;
	private String ds_complemento;
	private String ds_bairro;
	private Integer nr_cep;
	private String ds_cidade;
	private char ds_uf;
	private String ds_email;
	private Integer nr_telefone;
	private Integer nr_fax;
	
	
	public Clinicas() {
		
	}


	public Clinicas(Integer cd_clinica, String nm_clinica, Integer nr_cnpj, String ds_especialidades,
			String ds_endereco, Integer nr_numero, String ds_complemento, String ds_bairro, Integer nr_cep,
			String ds_cidade, char ds_uf, String ds_email, Integer nr_telefone, Integer nr_fax) {
		super();
		this.cd_clinica = cd_clinica;
		this.nm_clinica = nm_clinica;
		this.nr_cnpj = nr_cnpj;
		this.ds_especialidades = ds_especialidades;
		this.ds_endereco = ds_endereco;
		this.nr_numero = nr_numero;
		this.ds_complemento = ds_complemento;
		this.ds_bairro = ds_bairro;
		this.nr_cep = nr_cep;
		this.ds_cidade = ds_cidade;
		this.ds_uf = ds_uf;
		this.ds_email = ds_email;
		this.nr_telefone = nr_telefone;
		this.nr_fax = nr_fax;
	}


	public Integer getCd_clinica() {
		return cd_clinica;
	}


	public void setCd_clinica(Integer cd_clinica) {
		this.cd_clinica = cd_clinica;
	}


	public String getNm_clinica() {
		return nm_clinica;
	}


	public void setNm_clinica(String nm_clinica) {
		this.nm_clinica = nm_clinica;
	}


	public Integer getNr_cnpj() {
		return nr_cnpj;
	}


	public void setNr_cnpj(Integer nr_cnpj) {
		this.nr_cnpj = nr_cnpj;
	}


	public String getDs_especialidades() {
		return ds_especialidades;
	}


	public void setDs_especialidades(String ds_especialidades) {
		this.ds_especialidades = ds_especialidades;
	}


	public String getDs_endereco() {
		return ds_endereco;
	}


	public void setDs_endereco(String ds_endereco) {
		this.ds_endereco = ds_endereco;
	}


	public Integer getNr_numero() {
		return nr_numero;
	}


	public void setNr_numero(Integer nr_numero) {
		this.nr_numero = nr_numero;
	}


	public String getDs_complemento() {
		return ds_complemento;
	}


	public void setDs_complemento(String ds_complemento) {
		this.ds_complemento = ds_complemento;
	}


	public String getDs_bairro() {
		return ds_bairro;
	}


	public void setDs_bairro(String ds_bairro) {
		this.ds_bairro = ds_bairro;
	}


	public Integer getNr_cep() {
		return nr_cep;
	}


	public void setNr_cep(Integer nr_cep) {
		this.nr_cep = nr_cep;
	}


	public String getDs_cidade() {
		return ds_cidade;
	}


	public void setDs_cidade(String ds_cidade) {
		this.ds_cidade = ds_cidade;
	}


	public char getDs_uf() {
		return ds_uf;
	}


	public void setDs_uf(char ds_uf) {
		this.ds_uf = ds_uf;
	}


	public String getDs_email() {
		return ds_email;
	}


	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}


	public Integer getNr_telefone() {
		return nr_telefone;
	}


	public void setNr_telefone(Integer nr_telefone) {
		this.nr_telefone = nr_telefone;
	}


	public Integer getNr_fax() {
		return nr_fax;
	}


	public void setNr_fax(Integer nr_fax) {
		this.nr_fax = nr_fax;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_clinica);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clinicas other = (Clinicas) obj;
		return Objects.equals(cd_clinica, other.cd_clinica);
	}
	
	
	
}
