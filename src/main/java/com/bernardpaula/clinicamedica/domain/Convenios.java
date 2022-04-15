package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Convenios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_convenio;
	
	private String nm_convenio;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_inicio;
	
	private String ds_regioes;
	
	
	
	
	public Convenios() {
	}
	
	
	
}
