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
public class Laudos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_laudo;
	
	private Integer cd_paciente;
	private Integer cd_medico;
	private String ds_laudo;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_laudo;
	
	@JsonFormat(pattern = "yyyy/MM/dd")    // - ver - esta como TIME
	private Date hr_laudo;
	
	
	public Laudos() {
		
	}


	public Laudos(Integer cd_laudo, Integer cd_paciente, Integer cd_medico, String ds_laudo, Date dt_laudo,
			Date hr_laudo) {
		super();
		this.cd_laudo = cd_laudo;
		this.cd_paciente = cd_paciente;
		this.cd_medico = cd_medico;
		this.ds_laudo = ds_laudo;
		this.dt_laudo = dt_laudo;
		this.hr_laudo = hr_laudo;
	}


	public Integer getCd_laudo() {
		return cd_laudo;
	}


	public void setCd_laudo(Integer cd_laudo) {
		this.cd_laudo = cd_laudo;
	}


	public Integer getCd_paciente() {
		return cd_paciente;
	}


	public void setCd_paciente(Integer cd_paciente) {
		this.cd_paciente = cd_paciente;
	}


	public Integer getCd_medico() {
		return cd_medico;
	}


	public void setCd_medico(Integer cd_medico) {
		this.cd_medico = cd_medico;
	}


	public String getDs_laudo() {
		return ds_laudo;
	}


	public void setDs_laudo(String ds_laudo) {
		this.ds_laudo = ds_laudo;
	}


	public Date getDt_laudo() {
		return dt_laudo;
	}


	public void setDt_laudo(Date dt_laudo) {
		this.dt_laudo = dt_laudo;
	}


	public Date getHr_laudo() {
		return hr_laudo;
	}


	public void setHr_laudo(Date hr_laudo) {
		this.hr_laudo = hr_laudo;
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
		Laudos other = (Laudos) obj;
		return Objects.equals(cd_laudo, other.cd_laudo);
	}
	
	
	
}
