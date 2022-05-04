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
public class Consultas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_consulta;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dt_consulta;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date nr_horairo;   // - ver - está como TIME
	
	private Integer cd_paciente;
	private Integer cd_convenio;
	private Integer cd_medico;
	
	@NotEmpty(message = "preenchimento obrigatório")
	@Length(min=5, max=20, message = "O tamanho deve ser entre 5 e 20 caracteres")
	private String ds_tipo;

	
	public Consultas() {
		
	}


	public Consultas(Integer cd_consulta, Date dt_consulta, Date nr_horairo, Integer cd_paciente, Integer cd_convenio,
			Integer cd_medico, String ds_tipo) {
		super();
		this.cd_consulta = cd_consulta;
		this.dt_consulta = dt_consulta;
		this.nr_horairo = nr_horairo;
		this.cd_paciente = cd_paciente;
		this.cd_convenio = cd_convenio;
		this.cd_medico = cd_medico;
		this.ds_tipo = ds_tipo;
	}


	public Integer getCd_consulta() {
		return cd_consulta;
	}


	public void setCd_consulta(Integer cd_consulta) {
		this.cd_consulta = cd_consulta;
	}


	public Date getDt_consulta() {
		return dt_consulta;
	}


	public void setDt_consulta(Date dt_consulta) {
		this.dt_consulta = dt_consulta;
	}


	public Date getNr_horairo() {
		return nr_horairo;
	}


	public void setNr_horairo(Date nr_horairo) {
		this.nr_horairo = nr_horairo;
	}


	public Integer getCd_paciente() {
		return cd_paciente;
	}


	public void setCd_paciente(Integer cd_paciente) {
		this.cd_paciente = cd_paciente;
	}


	public Integer getCd_convenio() {
		return cd_convenio;
	}


	public void setCd_convenio(Integer cd_convenio) {
		this.cd_convenio = cd_convenio;
	}


	public Integer getCd_medico() {
		return cd_medico;
	}


	public void setCd_medico(Integer cd_medico) {
		this.cd_medico = cd_medico;
	}


	public String getDs_tipo() {
		return ds_tipo;
	}


	public void setDs_tipo(String ds_tipo) {
		this.ds_tipo = ds_tipo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_consulta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consultas other = (Consultas) obj;
		return Objects.equals(cd_consulta, other.cd_consulta);
	}
	
	
	
}
