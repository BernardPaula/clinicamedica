package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamentos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_medicamento;
	
	private String nm_medicamento;
	private String ds_substancia;
	private String ds_posologia;
	private String ds_laboratorio;
	private String ds_contraind;
	private String ds_generico;
	
	
	public Medicamentos() {
		
	}
}
