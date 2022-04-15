package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Consultas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_consulta;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_consulta;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nr_horairo;   // - ver - está como TIME
	
	private Integer cd_paciente;
	private Integer cd_convenio;
	private Integer cd_medico;
	private String ds_tipo;

}
