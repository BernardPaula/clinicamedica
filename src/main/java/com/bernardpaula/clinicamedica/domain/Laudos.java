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
@Table(name="laudos")
public class Laudos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdLaudo;
	
	@Column(name="cd_paciente", unique=true)
	private Integer cdPaciente;
	
	@Column(name="cd_medico", unique=true)
	private Integer cdMedico;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(name="ds_laudo", unique=true)
	private String dsLaudo;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dtLaudo;
	
	@JsonFormat(pattern = "yyyy/MM/dd")    // - ver - esta como TIME
	private Date hrLaudo;
	
	
	public Laudos() {
		
	}


	public Laudos(Integer cdLaudo, Integer cdPaciente, Integer cdMedico,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ser entre 1 e 80 caracteres") String dsLaudo,
			Date dtLaudo, Date hrLaudo) {
		super();
		this.cdLaudo = cdLaudo;
		this.cdPaciente = cdPaciente;
		this.cdMedico = cdMedico;
		this.dsLaudo = dsLaudo;
		this.dtLaudo = dtLaudo;
		this.hrLaudo = hrLaudo;
	}


	public Integer getCdLaudo() {
		return cdLaudo;
	}


	public void setCdLaudo(Integer cdLaudo) {
		this.cdLaudo = cdLaudo;
	}


	public Integer getCdPaciente() {
		return cdPaciente;
	}


	public void setCdPaciente(Integer cdPaciente) {
		this.cdPaciente = cdPaciente;
	}


	public Integer getCdMedico() {
		return cdMedico;
	}


	public void setCdMedico(Integer cdMedico) {
		this.cdMedico = cdMedico;
	}


	public String getDsLaudo() {
		return dsLaudo;
	}


	public void setDsLaudo(String dsLaudo) {
		this.dsLaudo = dsLaudo;
	}


	public Date getDtLaudo() {
		return dtLaudo;
	}


	public void setDtLaudo(Date dtLaudo) {
		this.dtLaudo = dtLaudo;
	}


	public Date getHrLaudo() {
		return hrLaudo;
	}


	public void setHrLaudo(Date hrLaudo) {
		this.hrLaudo = hrLaudo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdLaudo);
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
		return Objects.equals(cdLaudo, other.cdLaudo);
	}


	
	
}
