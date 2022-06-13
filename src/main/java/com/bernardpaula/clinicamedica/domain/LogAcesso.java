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
@Table(name= "log_acesso")
public class LogAcesso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdAcesso;

	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ter entre 1 e 80 caracteres")
	@Column(name="nm_usuario", unique=true)
	private String nmUsuario;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dtAcesso;   // esta como DATETIME
	
	
	public LogAcesso() {
		
	}


	public LogAcesso(Integer cdAcesso,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ter entre 1 e 80 caracteres") String nmUsuario,
			Date dtAcesso) {
		super();
		this.cdAcesso = cdAcesso;
		this.nmUsuario = nmUsuario;
		this.dtAcesso = dtAcesso;
	}


	public Integer getCdAcesso() {
		return cdAcesso;
	}


	public void setCdAcesso(Integer cdAcesso) {
		this.cdAcesso = cdAcesso;
	}


	public String getNmUsuario() {
		return nmUsuario;
	}


	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}


	public Date getDtAcesso() {
		return dtAcesso;
	}


	public void setDtAcesso(Date dtAcesso) {
		this.dtAcesso = dtAcesso;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdAcesso);
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
		return Objects.equals(cdAcesso, other.cdAcesso);
	}

	
}
