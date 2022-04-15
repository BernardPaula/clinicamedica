package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Receitas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_receitas;
	
	private Integer cd_paciente;
	private Integer cd_medico;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_receita;    // - esta como DATETIME
	
	private Integer cd_medicamento;
	private String ds_posologica;
	private Integer cd_exame;
	private Integer cd_clinica;
	private String ds_observacoes;
	
	
	public Receitas() {
		
	}
	
	
	
}
