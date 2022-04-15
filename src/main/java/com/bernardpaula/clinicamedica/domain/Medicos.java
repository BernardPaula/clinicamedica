package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cd_medico;
	
	private Integer cd_laudo;
	private String nm_medico;
	private Integer nr_rg;
	private Integer nr_cpf;
	private Integer nr_crm;
	private String ds_area;
	private String ds_especialidades;
	private String nm_usuario;
	private String ds_senha;
	private char fl_admin;
	private Integer nr_pessoas;
	
	
	public Medicos() {
		
	}
	
}
