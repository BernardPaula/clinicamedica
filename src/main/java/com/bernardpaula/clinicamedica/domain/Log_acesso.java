package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Log_acesso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_acesso;

	private String nm_usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_acesso;   // esta como DATETIME
	
	
	public Log_acesso() {
		
	}


	public Log_acesso(Integer cd_acesso, String nm_usuario, Date dt_acesso) {
		super();
		this.cd_acesso = cd_acesso;
		this.nm_usuario = nm_usuario;
		this.dt_acesso = dt_acesso;
	}


	public Integer getCd_acesso() {
		return cd_acesso;
	}


	public void setCd_acesso(Integer cd_acesso) {
		this.cd_acesso = cd_acesso;
	}


	public String getNm_usuario() {
		return nm_usuario;
	}


	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}


	public Date getDt_acesso() {
		return dt_acesso;
	}


	public void setDt_acesso(Date dt_acesso) {
		this.dt_acesso = dt_acesso;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_acesso);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log_acesso other = (Log_acesso) obj;
		return Objects.equals(cd_acesso, other.cd_acesso);
	}
	
	
	
}
