package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "locais_enc")
public class LocaisEnc implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codLocalEnc;
	
	@Column(name="cd_exame_comp", unique=true)
	private Integer cdExameComp;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=40, message= "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name="nm_clinica", unique=true)
	private String nmClinica;
	
	@NotEmpty(message= "Preenchimento obrigat�rio")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_endereco", unique=true)
	private String dsEndereco;
	
	@Column(name="nr_telefone", unique=true)
	private Integer nrTelefone;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=100, message= "O tamanho deve ser entre 5 e 100 caracteres")
	@Column(name="ds_observacoes", unique=true)
	private String dsObservacoes;
	
	
	public LocaisEnc() {		
	}


	public LocaisEnc(Integer codLocalEnc, Integer cdExameComp,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String nmClinica,
			@NotEmpty(message = "Preenchimento obrigat�rio") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsEndereco,
			Integer nrTelefone,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 100, message = "O tamanho deve ser entre 5 e 100 caracteres") String dsObservacoes) {
		super();
		this.codLocalEnc = codLocalEnc;
		this.cdExameComp = cdExameComp;
		this.nmClinica = nmClinica;
		this.dsEndereco = dsEndereco;
		this.nrTelefone = nrTelefone;
		this.dsObservacoes = dsObservacoes;
	}


	public Integer getCodLocalEnc() {
		return codLocalEnc;
	}


	public void setCodLocalEnc(Integer codLocalEnc) {
		this.codLocalEnc = codLocalEnc;
	}


	public Integer getCdExameComp() {
		return cdExameComp;
	}


	public void setCdExameComp(Integer cdExameComp) {
		this.cdExameComp = cdExameComp;
	}


	public String getNmClinica() {
		return nmClinica;
	}


	public void setNmClinica(String nmClinica) {
		this.nmClinica = nmClinica;
	}


	public String getDsEndereco() {
		return dsEndereco;
	}


	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}


	public Integer getNrTelefone() {
		return nrTelefone;
	}


	public void setNrTelefone(Integer nrTelefone) {
		this.nrTelefone = nrTelefone;
	}


	public String getDsObservacoes() {
		return dsObservacoes;
	}


	public void setDsObservacoes(String dsObservacoes) {
		this.dsObservacoes = dsObservacoes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdExameComp);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocaisEnc other = (LocaisEnc) obj;
		return Objects.equals(cdExameComp, other.cdExameComp);
	}

	
	
	
}
