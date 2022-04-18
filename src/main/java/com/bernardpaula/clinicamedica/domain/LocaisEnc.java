package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocaisEnc implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_local_enc;
	
	private Integer cd_exame_comp;
	private String nm_clinica;
	private String ds_endereco;
	private Integer nr_telefone;
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
