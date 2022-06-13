package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="receitas")
public class Receitas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdReceitas;
	
	@Column(name="cd_paciente", unique=true)
	private Integer cd_paciente;
	
	@Column(name="cd_medico", unique=true)
	private Integer cd_medico;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_receita;    // - esta como DATETIME
	
	@Column(name="cd_medicamento", unique=true)
	private Integer cd_medicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_posologia", unique=true)
	private String ds_posologia;
	
	@Column(name="cd_exame", unique=true)
	private Integer cd_exame;
	
	@Column(name="cd_clinica", unique=true)
	private Integer cd_clinica;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=100, message= "O tamanho deve ser entre 1 e 100 caracteres")
	@Column(name="ds_observacoes", unique=true)
	private String ds_observacoes;
	
	
	public Receitas() {
		
	}


	public Receitas(Integer cdReceitas, Integer cd_paciente, Integer cd_medico, Date dt_receita, Integer cd_medicamento,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String ds_posologia,
			Integer cd_exame, Integer cd_clinica,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 100, message = "O tamanho deve ser entre 1 e 100 caracteres") String ds_observacoes) {
		super();
		this.cdReceitas = cdReceitas;
		this.cd_paciente = cd_paciente;
		this.cd_medico = cd_medico;
		this.dt_receita = dt_receita;
		this.cd_medicamento = cd_medicamento;
		this.ds_posologia = ds_posologia;
		this.cd_exame = cd_exame;
		this.cd_clinica = cd_clinica;
		this.ds_observacoes = ds_observacoes;
	}


	public Integer getCdReceitas() {
		return cdReceitas;
	}


	public void setCdReceitas(Integer cdReceitas) {
		this.cdReceitas = cdReceitas;
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
		return Objects.hash(cdReceitas);
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
		return Objects.equals(cdReceitas, other.cdReceitas);
	}

	
	
	
}
