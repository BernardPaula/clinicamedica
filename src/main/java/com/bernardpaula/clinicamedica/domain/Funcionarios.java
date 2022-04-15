package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Funcionarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_funcionario;
	
	private String rm_funcionario;
	private Integer cd_clinica;
	private Integer nr_rg;
	private Integer nr_cpf;
	private Integer cd_cargo;
	private String ds_endereco;
	private Integer nr_numero;
	private Integer ds_complemento;
	private String ds_bairro;
	private Integer nr_cep;
	private Integer nr_telres;
	private Integer nr_telcel;
	private String nm_usuario;
	private String ds_senha;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_ecesso;     // esta como DATETIME
	
	private Integer nr_acessos;
	private char fl_admin;
	
	
	public Funcionarios() {
		
	}
	

}
