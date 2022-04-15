package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cargos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_cargo;
	
	private String nm_cargo;
	private String ds_cargo;
	
	
	public Cargos() {
		
	}
	
}
