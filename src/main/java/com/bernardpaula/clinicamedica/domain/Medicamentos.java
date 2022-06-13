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
	private Integer cdMedicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message="O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="nm_medicamento", unique=true)
	private String nmMedicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_substancia", unique=true)
	private String dsSubstancia;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(name="ds_posologia", unique=true)
	private String dsPosologia;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(name="ds_laboratorio", unique=true)
	private String dsLaboratorio;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(name="ds_contraind", unique=true)
	private String dsContraind;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(name="ds_generico", unique=true)
	private String dsGenerico;
	
	
	public Medicamentos() {
		
	}


	public Medicamentos(Integer cdMedicamento,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String nmMedicamento,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsSubstancia,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ser entre 1 e 80 caracteres") String dsPosologia,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ser entre 1 e 80 caracteres") String dsLaboratorio,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ser entre 1 e 80 caracteres") String dsContraind,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ser entre 1 e 80 caracteres") String dsGenerico) {
		super();
		this.cdMedicamento = cdMedicamento;
		this.nmMedicamento = nmMedicamento;
		this.dsSubstancia = dsSubstancia;
		this.dsPosologia = dsPosologia;
		this.dsLaboratorio = dsLaboratorio;
		this.dsContraind = dsContraind;
		this.dsGenerico = dsGenerico;
	}


	public Integer getCdMedicamento() {
		return cdMedicamento;
	}


	public void setCdMedicamento(Integer cdMedicamento) {
		this.cdMedicamento = cdMedicamento;
	}


	public String getNmMedicamento() {
		return nmMedicamento;
	}


	public void setNmMedicamento(String nmMedicamento) {
		this.nmMedicamento = nmMedicamento;
	}


	public String getDsSubstancia() {
		return dsSubstancia;
	}


	public void setDsSubstancia(String dsSubstancia) {
		this.dsSubstancia = dsSubstancia;
	}


	public String getDsPosologia() {
		return dsPosologia;
	}


	public void setDsPosologia(String dsPosologia) {
		this.dsPosologia = dsPosologia;
	}


	public String getDsLaboratorio() {
		return dsLaboratorio;
	}


	public void setDsLaboratorio(String dsLaboratorio) {
		this.dsLaboratorio = dsLaboratorio;
	}


	public String getDsContraind() {
		return dsContraind;
	}


	public void setDsContraind(String dsContraind) {
		this.dsContraind = dsContraind;
	}


	public String getDsGenerico() {
		return dsGenerico;
	}


	public void setDsGenerico(String dsGenerico) {
		this.dsGenerico = dsGenerico;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdMedicamento);
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
		return Objects.equals(cdMedicamento, other.cdMedicamento);
	}


	
}
