package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exames_comp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_exame_comp;
	
	private Integer cd_receita;
	private String nm_exame;
	private String ds_observacao;
	
	
	public Exames_comp() {
		
	}

}
