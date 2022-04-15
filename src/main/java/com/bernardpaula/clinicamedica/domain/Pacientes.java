package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pacientes implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_paciente;
	
	private Integer cd_convenio;
	private Integer cd_laudo;
	private Integer cd_prontuario;
	private String nm_paciente;
	private Integer nr_cpf;
	private Integer nr_rg;
	private String nm_pai;
	private String nm_mae;
	private Integer nr_carteira;
	private String ds_endereco;
	private Integer nr_telefone_res;
	private Integer nr_telefone_cel;
	private Integer nr_telefone_com;
	private String de_email;
	private String ds_senhaweb;
	private Integer nr_acessos;
	
	
	public Pacientes(){
		
	}
	
	
}
