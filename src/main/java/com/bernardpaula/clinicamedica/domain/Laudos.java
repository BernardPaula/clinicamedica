package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Laudos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_laudo;
	
	private Integer cd_paciente;
	private Integer cd_medico;
	private String ds_laudo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_laudo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")    // - ver - esta como TIME
	private Date hr_laudo;
	
	
	public Laudos() {
		
	}
	
}
