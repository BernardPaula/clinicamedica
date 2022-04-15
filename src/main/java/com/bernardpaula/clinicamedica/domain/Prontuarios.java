package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Prontuarios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_prontuario;
	
	private Integer cd_paciente;
	private Integer cd_medicamento;
	private String ds_posologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_iniciomed;      // ver- DATETIME - é o que está no projeto
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_finalmed;
	
	private Integer cd_exame;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_exame;
	
	private String ds_resultado;
	private String ds_observacao;
	
	
}
