package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Prontuarios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_prontuario;
	
	private Integer cd_paciente;
	private Integer cd_medicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=5, max=20, message= "O tamanho deve ser entre 5 e 20 caracteres")
	private String ds_posologia;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_iniciomed;      // ver- DATETIME - é o que está no projeto
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_finalmed;
	
	private Integer cd_exame;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dt_exame;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=40, message=  "O tamanho deve ser entre 5 e 40 caracteres")
	private String ds_resultado;
	
	@NotEmpty(message= "Preechimento obrigatório")
	@Length(min=5, max=40, message= "O tamanho deve ser entre 5 e 40 caracteres")
	private String ds_observacao;
	
	
	public Prontuarios() {
		
	}


	public Prontuarios(Integer cd_prontuario, Integer cd_paciente, Integer cd_medicamento, String ds_posologia,
			Date dt_iniciomed, Date dt_finalmed, Integer cd_exame, Date dt_exame, String ds_resultado,
			String ds_observacao) {
		super();
		this.cd_prontuario = cd_prontuario;
		this.cd_paciente = cd_paciente;
		this.cd_medicamento = cd_medicamento;
		this.ds_posologia = ds_posologia;
		this.dt_iniciomed = dt_iniciomed;
		this.dt_finalmed = dt_finalmed;
		this.cd_exame = cd_exame;
		this.dt_exame = dt_exame;
		this.ds_resultado = ds_resultado;
		this.ds_observacao = ds_observacao;
	}


	public Integer getCd_prontuario() {
		return cd_prontuario;
	}


	public void setCd_prontuario(Integer cd_prontuario) {
		this.cd_prontuario = cd_prontuario;
	}


	public Integer getCd_paciente() {
		return cd_paciente;
	}


	public void setCd_paciente(Integer cd_paciente) {
		this.cd_paciente = cd_paciente;
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


	public Date getDt_iniciomed() {
		return dt_iniciomed;
	}


	public void setDt_iniciomed(Date dt_iniciomed) {
		this.dt_iniciomed = dt_iniciomed;
	}


	public Date getDt_finalmed() {
		return dt_finalmed;
	}


	public void setDt_finalmed(Date dt_finalmed) {
		this.dt_finalmed = dt_finalmed;
	}


	public Integer getCd_exame() {
		return cd_exame;
	}


	public void setCd_exame(Integer cd_exame) {
		this.cd_exame = cd_exame;
	}


	public Date getDt_exame() {
		return dt_exame;
	}


	public void setDt_exame(Date dt_exame) {
		this.dt_exame = dt_exame;
	}


	public String getDs_resultado() {
		return ds_resultado;
	}


	public void setDs_resultado(String ds_resultado) {
		this.ds_resultado = ds_resultado;
	}


	public String getDs_observacao() {
		return ds_observacao;
	}


	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_exame);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuarios other = (Prontuarios) obj;
		return Objects.equals(cd_exame, other.cd_exame);
	}
	
	
	
}
