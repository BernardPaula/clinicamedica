package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Medicos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cd_medico;
	
	private Integer cd_laudo;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=40, message= "O tamanho deve ser entre 5 e 40 caracteres")
	private String nm_medico;
	private Integer nr_rg;
	private Integer nr_cpf;
	private Integer nr_crm;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=20, message= "O tamanho deve ser entre 5 e 20 caracteres")
	private String ds_area;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=40, message= "O tamanho deve ser entre 5 e 40 caracteres")
	private String ds_especialidades;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=10, message= "O tamanho deve ser entre 5 e 10 caracteres")
	private String nm_usuario;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=10, message= "O tamano deve ser entre 5 e 10 caracteres")
	private String ds_senha;
	private char fl_admin;
	private Integer nr_pessoas;
	
	
	public Medicos() {
		
	}


	public Medicos(Integer cd_medico, Integer cd_laudo, String nm_medico, Integer nr_rg, Integer nr_cpf, Integer nr_crm,
			String ds_area, String ds_especialidades, String nm_usuario, String ds_senha, char fl_admin,
			Integer nr_pessoas) {
		super();
		this.cd_medico = cd_medico;
		this.cd_laudo = cd_laudo;
		this.nm_medico = nm_medico;
		this.nr_rg = nr_rg;
		this.nr_cpf = nr_cpf;
		this.nr_crm = nr_crm;
		this.ds_area = ds_area;
		this.ds_especialidades = ds_especialidades;
		this.nm_usuario = nm_usuario;
		this.ds_senha = ds_senha;
		this.fl_admin = fl_admin;
		this.nr_pessoas = nr_pessoas;
	}


	public Integer getCd_medico() {
		return cd_medico;
	}


	public void setCd_medico(Integer cd_medico) {
		this.cd_medico = cd_medico;
	}


	public Integer getCd_laudo() {
		return cd_laudo;
	}


	public void setCd_laudo(Integer cd_laudo) {
		this.cd_laudo = cd_laudo;
	}


	public String getNm_medico() {
		return nm_medico;
	}


	public void setNm_medico(String nm_medico) {
		this.nm_medico = nm_medico;
	}


	public Integer getNr_rg() {
		return nr_rg;
	}


	public void setNr_rg(Integer nr_rg) {
		this.nr_rg = nr_rg;
	}


	public Integer getNr_cpf() {
		return nr_cpf;
	}


	public void setNr_cpf(Integer nr_cpf) {
		this.nr_cpf = nr_cpf;
	}


	public Integer getNr_crm() {
		return nr_crm;
	}


	public void setNr_crm(Integer nr_crm) {
		this.nr_crm = nr_crm;
	}


	public String getDs_area() {
		return ds_area;
	}


	public void setDs_area(String ds_area) {
		this.ds_area = ds_area;
	}


	public String getDs_especialidades() {
		return ds_especialidades;
	}


	public void setDs_especialidades(String ds_especialidades) {
		this.ds_especialidades = ds_especialidades;
	}


	public String getNm_usuario() {
		return nm_usuario;
	}


	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}


	public String getDs_senha() {
		return ds_senha;
	}


	public void setDs_senha(String ds_senha) {
		this.ds_senha = ds_senha;
	}


	public char getFl_admin() {
		return fl_admin;
	}


	public void setFl_admin(char fl_admin) {
		this.fl_admin = fl_admin;
	}


	public Integer getNr_pessoas() {
		return nr_pessoas;
	}


	public void setNr_pessoas(Integer nr_pessoas) {
		this.nr_pessoas = nr_pessoas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_laudo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicos other = (Medicos) obj;
		return Objects.equals(cd_laudo, other.cd_laudo);
	}
	
	
	
	
	
}
