package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locais_enc implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_local_enc;
	
	private Integer cd_exame_comp;
	private String nm_clinica;
	private String ds_endereco;
	private Integer nr_telefone;
	private String ds_observacoes;
	
	
	public Locais_enc() {
		
	}
	
	
}
