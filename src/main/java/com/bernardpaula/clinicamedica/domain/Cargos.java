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
@Table(name = "cargos")
public class Cargos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdCargo;
	
	@NotEmpty(message = "preenchimento obrigatório")
	@Length(min=1, max=25, message = "O tamanho deve ser entre 1 e 25 caracteres")
	@Column(name = "nm_cargo", unique = true)
	private String nmCargo;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=50, message = "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name="ds_cargo", unique=true)
	private String dsCargo;
	
	
	public Cargos() {
		
	}


	public Cargos(Integer cdCargo,
			@NotEmpty(message = "preenchimento obrigatório") @Length(min = 1, max = 25, message = "O tamanho deve ser entre 1 e 25 caracteres") String nmCargo,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres") String dsCargo) {
		super();
		this.cdCargo = cdCargo;
		this.nmCargo = nmCargo;
		this.dsCargo = dsCargo;
	}


	public Integer getCdCargo() {
		return cdCargo;
	}


	public void setCdCargo(Integer cdCargo) {
		this.cdCargo = cdCargo;
	}


	public String getNmCargo() {
		return nmCargo;
	}


	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}


	public String getDsCargo() {
		return dsCargo;
	}


	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdCargo);
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
		return Objects.equals(cdCargo, other.cdCargo);
	}


	
	
}
