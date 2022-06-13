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
@Table(name= "convenios")
public class Convenios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdConvenio;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=20, message= "O tamanho deve ser entre 1 e 20 caracteres")
	@Column(name="nm_convenio",unique=true)
	private String nmConvenio;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dtInicio;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message = "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_regioes", unique=true)
	private String dsRegioes;
	
	
	public Convenios() {
	}


	public Convenios(Integer cdConvenio,
			@NotEmpty(message = "Preenchimento obrigat�rio") @Length(min = 1, max = 20, message = "O tamanho deve ser entre 1 e 20 caracteres") String nmConvenio,
			Date dtInicio,
			@NotEmpty(message = "Preenchimento obrigat�rio") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsRegioes) {
		super();
		this.cdConvenio = cdConvenio;
		this.nmConvenio = nmConvenio;
		this.dtInicio = dtInicio;
		this.dsRegioes = dsRegioes;
	}


	public Integer getCdConvenio() {
		return cdConvenio;
	}


	public void setCdConvenio(Integer cdConvenio) {
		this.cdConvenio = cdConvenio;
	}


	public String getNmConvenio() {
		return nmConvenio;
	}


	public void setNmConvenio(String nmConvenio) {
		this.nmConvenio = nmConvenio;
	}


	public Date getDtInicio() {
		return dtInicio;
	}


	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}


	public String getDsRegioes() {
		return dsRegioes;
	}


	public void setDsRegioes(String dsRegioes) {
		this.dsRegioes = dsRegioes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdConvenio);
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
		return Objects.equals(cdConvenio, other.cdConvenio);
	}
	
	
}
