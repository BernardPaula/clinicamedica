package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clinicas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_clinica;
	
	private String nm_clinica;
	private Integer nr_cnpj;
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
	
}
