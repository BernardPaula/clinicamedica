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
	private Integer cd_exame_comp;
	
	@Column(unique=true)
	private Integer cd_receita;
	
	@NotEmpty(message= "Preenchimento obrigat�rio")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(unique=true)
	private String nm_exame;
	
	@NotEmpty(message= "Preenchimento obrigat�ri")
	@Length(min=1, max=300, message = "O tamanho deve ser entre 1 e 300 caracteres")
	@Column(unique=true)
	private String ds_observacao;
	
	
	public ExamesComp() {
		
	}


	public ExamesComp(Integer cd_exame_comp, Integer cd_receita, String nm_exame, String ds_observacao) {
		super();
		this.cd_exame_comp = cd_exame_comp;
		this.cd_receita = cd_receita;
		this.nm_exame = nm_exame;
		this.ds_observacao = ds_observacao;
	}


	public Integer getCd_exame_comp() {
		return cd_exame_comp;
	}


	public void setCd_exame_comp(Integer cd_exame_comp) {
		this.cd_exame_comp = cd_exame_comp;
	}


	public Integer getCd_receita() {
		return cd_receita;
	}


	public void setCd_receita(Integer cd_receita) {
		this.cd_receita = cd_receita;
	}


	public String getNm_exame() {
		return nm_exame;
	}


	public void setNm_exame(String nm_exame) {
		this.nm_exame = nm_exame;
	}


	public String getDs_observacao() {
		return ds_observacao;
	}


	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_exame_comp);
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
		return Objects.equals(cd_exame_comp, other.cd_exame_comp);
	}

	
	
	
}
