package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Convenios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_convenio;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=20, message= "O tamanho deve ser entre 5 e 20 caracteres")
	private String nm_convenio;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_inicio;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=30, message = "O tamanho deve ser entre 5 e 30 caracteres")
	private String ds_regioes;
	
	
	public Convenios() {
	}


	public Convenios(Integer cd_convenio, String nm_convenio, Date dt_inicio, String ds_regioes) {
		super();
		this.cd_convenio = cd_convenio;
		this.nm_convenio = nm_convenio;
		this.dt_inicio = dt_inicio;
		this.ds_regioes = ds_regioes;
	}


	public Integer getCd_convenio() {
		return cd_convenio;
	}


	public void setCd_convenio(Integer cd_convenio) {
		this.cd_convenio = cd_convenio;
	}


	public String getNm_convenio() {
		return nm_convenio;
	}


	public void setNm_convenio(String nm_convenio) {
		this.nm_convenio = nm_convenio;
	}


	public Date getDt_inicio() {
		return dt_inicio;
	}


	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}


	public String getDs_regioes() {
		return ds_regioes;
	}


	public void setDs_regioes(String ds_regioes) {
		this.ds_regioes = ds_regioes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_convenio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convenios other = (Convenios) obj;
		return Objects.equals(cd_convenio, other.cd_convenio);
	}


	
	
	
}
