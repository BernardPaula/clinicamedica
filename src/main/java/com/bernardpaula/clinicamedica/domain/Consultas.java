package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="consultas")
public class Consultas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdConsulta;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="dt_consulta", unique=true)
	private Date dtConsulta;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="nr_horario", unique=true)
	private Date nrHorairo;   
	
	@Column(name="cd_paciente", unique=true)
	private Integer cdPaciente;
	
	@Column(name="cd_convenio", unique=true)
	private Integer cdConvenio;
	
	@Column(name="cd_medico", unique=true)
	private Integer cdMedico;
	
	@NotEmpty(message = "preenchimento obrigat�rio")
	@Length(min=1, max=20, message = "O tamanho deve ser entre 1 e 20 caracteres")
	@Column(name="ds_tipo", unique=true)
	private String dsTipo;

	
	public Consultas() {
		
	}


	public Consultas(Integer cdConsulta, Date dtConsulta, Date nrHorairo, Integer cdPaciente, Integer cdConvenio,
			Integer cdMedico,
			@NotEmpty(message = "preenchimento obrigat�rio") @Length(min = 1, max = 20, message = "O tamanho deve ser entre 1 e 20 caracteres") String dsTipo) {
		super();
		this.cdConsulta = cdConsulta;
		this.dtConsulta = dtConsulta;
		this.nrHorairo = nrHorairo;
		this.cdPaciente = cdPaciente;
		this.cdConvenio = cdConvenio;
		this.cdMedico = cdMedico;
		this.dsTipo = dsTipo;
	}


	public Integer getCdConsulta() {
		return cdConsulta;
	}


	public void setCdConsulta(Integer cdConsulta) {
		this.cdConsulta = cdConsulta;
	}


	public Date getDtConsulta() {
		return dtConsulta;
	}


	public void setDtConsulta(Date dtConsulta) {
		this.dtConsulta = dtConsulta;
	}


	public Date getNrHorairo() {
		return nrHorairo;
	}


	public void setNrHorairo(Date nrHorairo) {
		this.nrHorairo = nrHorairo;
	}


	public Integer getCdPaciente() {
		return cdPaciente;
	}


	public void setCdPaciente(Integer cdPaciente) {
		this.cdPaciente = cdPaciente;
	}


	public Integer getCdConvenio() {
		return cdConvenio;
	}


	public void setCdConvenio(Integer cdConvenio) {
		this.cdConvenio = cdConvenio;
	}


	public Integer getCdMedico() {
		return cdMedico;
	}


	public void setCdMedico(Integer cdMedico) {
		this.cdMedico = cdMedico;
	}


	public String getDsTipo() {
		return dsTipo;
	}


	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdConsulta);
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
		return Objects.equals(cdConsulta, other.cdConsulta);
	}


	
	
}
