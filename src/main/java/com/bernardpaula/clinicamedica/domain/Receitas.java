package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Receitas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_receitas;
	
	private Integer cd_paciente;
	private Integer cd_medico;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_receita;    // - esta como DATETIME
	
	private Integer cd_medicamento;
	private String ds_posologia;
	private Integer cd_exame;
	private Integer cd_clinica;
	private String ds_observacoes;
	
	
	public Receitas() {
		
	}


	public Receitas(Integer cd_receitas, Integer cd_paciente, Integer cd_medico, Date dt_receita,
			Integer cd_medicamento, String ds_posologia, Integer cd_exame, Integer cd_clinica, String ds_observacoes) {
		super();
		this.cd_receitas = cd_receitas;
		this.cd_paciente = cd_paciente;
		this.cd_medico = cd_medico;
		this.dt_receita = dt_receita;
		this.cd_medicamento = cd_medicamento;
		this.ds_posologia = ds_posologia;
		this.cd_exame = cd_exame;
		this.cd_clinica = cd_clinica;
		this.ds_observacoes = ds_observacoes;
	}


	public Integer getCd_receitas() {
		return cd_receitas;
	}


	public void setCd_receitas(Integer cd_receitas) {
		this.cd_receitas = cd_receitas;
	}


	public Integer getCd_paciente() {
		return cd_paciente;
	}


	public void setCd_paciente(Integer cd_paciente) {
		this.cd_paciente = cd_paciente;
	}


	public Integer getCd_medico() {
		return cd_medico;
	}


	public void setCd_medico(Integer cd_medico) {
		this.cd_medico = cd_medico;
	}


	public Date getDt_receita() {
		return dt_receita;
	}


	public void setDt_receita(Date dt_receita) {
		this.dt_receita = dt_receita;
	}


	public Integer getCd_medicamento() {
		return cd_medicamento;
	}


	public void setCd_medicamento(Integer cd_medicamento) {
		this.cd_medicamento = cd_medicamento;
	}


	public String getDs_posologia() {
		return ds_posologia;
	}


	public void setDs_posologia(String ds_posologia) {
		this.ds_posologia = ds_posologia;
	}


	public Integer getCd_exame() {
		return cd_exame;
	}


	public void setCd_exame(Integer cd_exame) {
		this.cd_exame = cd_exame;
	}


	public Integer getCd_clinica() {
		return cd_clinica;
	}


	public void setCd_clinica(Integer cd_clinica) {
		this.cd_clinica = cd_clinica;
	}


	public String getDs_observacoes() {
		return ds_observacoes;
	}


	public void setDs_observacoes(String ds_observacoes) {
		this.ds_observacoes = ds_observacoes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_clinica);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receitas other = (Receitas) obj;
		return Objects.equals(cd_clinica, other.cd_clinica);
	}
	
	
	
	
}
