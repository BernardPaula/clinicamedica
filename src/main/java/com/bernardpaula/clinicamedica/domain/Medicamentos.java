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
@Table(name= "medicamentos")
public class Medicamentos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_medicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message="O tamanho deve ser entre 1 e 30 caracteres")
	@Column(unique=true)
	private String nm_medicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(unique=true)
	private String ds_substancia;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(unique=true)
	private String ds_posologia;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(unique=true)
	private String ds_laboratorio;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(unique=true)
	private String ds_contraind;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(unique=true)
	private String ds_generico;
	
	
	public Medicamentos() {
		
	}


	public Medicamentos(Integer cd_medicamento, String nm_medicamento, String ds_substancia, String ds_posologia,
			String ds_laboratorio, String ds_contraind, String ds_generico) {
		super();
		this.cd_medicamento = cd_medicamento;
		this.nm_medicamento = nm_medicamento;
		this.ds_substancia = ds_substancia;
		this.ds_posologia = ds_posologia;
		this.ds_laboratorio = ds_laboratorio;
		this.ds_contraind = ds_contraind;
		this.ds_generico = ds_generico;
	}


	public Integer getCd_medicamento() {
		return cd_medicamento;
	}


	public void setCd_medicamento(Integer cd_medicamento) {
		this.cd_medicamento = cd_medicamento;
	}


	public String getNm_medicamento() {
		return nm_medicamento;
	}


	public void setNm_medicamento(String nm_medicamento) {
		this.nm_medicamento = nm_medicamento;
	}


	public String getDs_substancia() {
		return ds_substancia;
	}


	public void setDs_substancia(String ds_substancia) {
		this.ds_substancia = ds_substancia;
	}


	public String getDs_posologia() {
		return ds_posologia;
	}


	public void setDs_posologia(String ds_posologia) {
		this.ds_posologia = ds_posologia;
	}


	public String getDs_laboratorio() {
		return ds_laboratorio;
	}


	public void setDs_laboratorio(String ds_laboratorio) {
		this.ds_laboratorio = ds_laboratorio;
	}


	public String getDs_contraind() {
		return ds_contraind;
	}


	public void setDs_contraind(String ds_contraind) {
		this.ds_contraind = ds_contraind;
	}


	public String getDs_generico() {
		return ds_generico;
	}


	public void setDs_generico(String ds_generico) {
		this.ds_generico = ds_generico;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_medicamento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamentos other = (Medicamentos) obj;
		return Objects.equals(cd_medicamento, other.cd_medicamento);
	}
	
	
}
