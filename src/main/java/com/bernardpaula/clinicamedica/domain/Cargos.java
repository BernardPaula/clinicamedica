package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Cargos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_cargo;
	
	@NotEmpty(message = "preenchimento obrigatório")
	@Length(min=5, max=25, message = "O tamanho deve ser entre 5 e 25 caracteres")
	private String nm_cargo;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=50, message = "O tamanho deve ser entre 5 e 50 caracteres")
	private String ds_cargo;
	
	
	public Cargos() {
		
	}


	public Cargos(Integer cd_cargo, String nm_cargo, String ds_cargo) {
		super();
		this.cd_cargo = cd_cargo;
		this.nm_cargo = nm_cargo;
		this.ds_cargo = ds_cargo;
	}


	public Integer getCd_cargo() {
		return cd_cargo;
	}


	public void setCd_cargo(Integer cd_cargo) {
		this.cd_cargo = cd_cargo;
	}


	public String getNm_cargo() {
		return nm_cargo;
	}


	public void setNm_cargo(String nm_cargo) {
		this.nm_cargo = nm_cargo;
	}


	public String getDs_cargo() {
		return ds_cargo;
	}


	public void setDs_cargo(String ds_cargo) {
		this.ds_cargo = ds_cargo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_cargo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargos other = (Cargos) obj;
		return Objects.equals(cd_cargo, other.cd_cargo);
	}
	
	
	
	
}
