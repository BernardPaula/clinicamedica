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
public class LogAcesso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_acesso;

	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=30, message= "O tamanho deve ter entre 5 e 30 caracteres")
	private String nm_usuario;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_acesso;   // esta como DATETIME
	
	
	public LogAcesso() {
		
	}


	public LogAcesso(Integer cd_acesso, String nm_usuario, Date dt_acesso) {
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
		LogAcesso other = (LogAcesso) obj;
		return Objects.equals(cd_acesso, other.cd_acesso);
	}
	
	
	
}
