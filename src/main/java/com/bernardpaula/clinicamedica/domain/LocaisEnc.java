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
	private Integer cod_local_enc;
	
	@Column(unique=true)
	private Integer cd_exame_comp;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=40, message= "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(unique=true)
	private String nm_clinica;
	
	@NotEmpty(message= "Preenchimento obrigat�rio")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(unique=true)
	private String ds_endereco;
	
	@Column(unique=true)
	private Integer nr_telefone;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=100, message= "O tamanho deve ser entre 5 e 100 caracteres")
	@Column(unique=true)
	private String ds_observacoes;
	
	
	public LocaisEnc() {		
	}

	public LocaisEnc(Integer cod_local_enc, Integer cd_exame_comp, String nm_clinica, String ds_endereco,
			Integer nr_telefone, String ds_observacoes) {
		super();
		this.cod_local_enc = cod_local_enc;
		this.cd_exame_comp = cd_exame_comp;
		this.nm_clinica = nm_clinica;
		this.ds_endereco = ds_endereco;
		this.nr_telefone = nr_telefone;
		this.ds_observacoes = ds_observacoes;
	}


	public Integer getCod_local_enc() {
		return cod_local_enc;
	}


	public void setCod_local_enc(Integer cod_local_enc) {
		this.cod_local_enc = cod_local_enc;
	}


	public Integer getCd_exame_comp() {
		return cd_exame_comp;
	}


	public void setCd_exame_comp(Integer cd_exame_comp) {
		this.cd_exame_comp = cd_exame_comp;
	}


	public String getNm_clinica() {
		return nm_clinica;
	}


	public void setNm_clinica(String nm_clinica) {
		this.nm_clinica = nm_clinica;
	}


	public String getDs_endereco() {
		return ds_endereco;
	}


	public void setDs_endereco(String ds_endereco) {
		this.ds_endereco = ds_endereco;
	}


	public Integer getNr_telefone() {
		return nr_telefone;
	}


	public void setNr_telefone(Integer nr_telefone) {
		this.nr_telefone = nr_telefone;
	}


	public String getDs_observacoes() {
		return ds_observacoes;
	}


	public void setDs_observacoes(String ds_observacoes) {
		this.ds_observacoes = ds_observacoes;
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
		LocaisEnc other = (LocaisEnc) obj;
		return Objects.equals(cd_exame_comp, other.cd_exame_comp);
	}
	
	
	
}
