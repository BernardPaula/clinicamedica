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
@Table(name="exames_comp")
public class ExamesComp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdExameComp;
	
	@Column(name="ce_receita", unique=true)
	private Integer cdReceita;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="nm_exame", unique=true)
	private String nmExame;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=300, message = "O tamanho deve ser entre 1 e 300 caracteres")
	@Column(name="ds_observacao", unique=true)
	private String dsObservacao;
	
	
	public ExamesComp() {
		
	}


	public ExamesComp(Integer cdExameComp, Integer cdReceita,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String nmExame,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 300, message = "O tamanho deve ser entre 1 e 300 caracteres") String dsObservacao) {
		super();
		this.cdExameComp = cdExameComp;
		this.cdReceita = cdReceita;
		this.nmExame = nmExame;
		this.dsObservacao = dsObservacao;
	}


	public Integer getCdExameComp() {
		return cdExameComp;
	}


	public void setCdExameComp(Integer cdExameComp) {
		this.cdExameComp = cdExameComp;
	}


	public Integer getCdReceita() {
		return cdReceita;
	}


	public void setCdReceita(Integer cdReceita) {
		this.cdReceita = cdReceita;
	}


	public String getNmExame() {
		return nmExame;
	}


	public void setNmExame(String nmExame) {
		this.nmExame = nmExame;
	}


	public String getDsObservacao() {
		return dsObservacao;
	}


	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
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
		ExamesComp other = (ExamesComp) obj;
		return Objects.equals(cdExameComp, other.cdExameComp);
	}

	
	
}
