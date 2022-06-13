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
@Table(name = "prontuarios")
public class Prontuarios implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdProntuario;
	
	@Column(name="cd_paciente", unique=true)
	private Integer cdPaciente;
	
	@Column(name="cd_medicamento", unique=true)
	private Integer cdMedicamento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=20, message= "O tamanho deve ser entre 1 e 20 caracteres")
	@Column(name="ds_posologia", unique=true)
	private String dsPosologia;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dtIniciomed;      // ver- DATETIME - é o que está no projeto
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dFinalmed;
	
	@Column(name="cd_exame", unique=true)
	private Integer cdExame;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dtExame;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=40, message=  "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name="ds_resultado", unique=true)
	private String dsResultado;
	
	@NotEmpty(message= "Preechimento obrigatório")
	@Length(min=1, max=40, message= "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name="ds_observacao", unique=true)
	private String dsObservacao;
	
	
	public Prontuarios() {
		
	}


	public Prontuarios(Integer cdProntuario, Integer cdPaciente, Integer cdMedicamento,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 20, message = "O tamanho deve ser entre 1 e 20 caracteres") String dsPosologia,
			Date dtIniciomed, Date dFinalmed, Integer cdExame, Date dtExame,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String dsResultado,
			@NotEmpty(message = "Preechimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String dsObservacao) {
		super();
		this.cdProntuario = cdProntuario;
		this.cdPaciente = cdPaciente;
		this.cdMedicamento = cdMedicamento;
		this.dsPosologia = dsPosologia;
		this.dtIniciomed = dtIniciomed;
		this.dFinalmed = dFinalmed;
		this.cdExame = cdExame;
		this.dtExame = dtExame;
		this.dsResultado = dsResultado;
		this.dsObservacao = dsObservacao;
	}


	public Integer getCdProntuario() {
		return cdProntuario;
	}


	public void setCdProntuario(Integer cdProntuario) {
		this.cdProntuario = cdProntuario;
	}


	public Integer getCdPaciente() {
		return cdPaciente;
	}


	public void setCdPaciente(Integer cdPaciente) {
		this.cdPaciente = cdPaciente;
	}


	public Integer getCdMedicamento() {
		return cdMedicamento;
	}


	public void setCdMedicamento(Integer cdMedicamento) {
		this.cdMedicamento = cdMedicamento;
	}


	public String getDsPosologia() {
		return dsPosologia;
	}


	public void setDsPosologia(String dsPosologia) {
		this.dsPosologia = dsPosologia;
	}


	public Date getDtIniciomed() {
		return dtIniciomed;
	}


	public void setDtIniciomed(Date dtIniciomed) {
		this.dtIniciomed = dtIniciomed;
	}


	public Date getdFinalmed() {
		return dFinalmed;
	}


	public void setdFinalmed(Date dFinalmed) {
		this.dFinalmed = dFinalmed;
	}


	public Integer getCdExame() {
		return cdExame;
	}


	public void setCdExame(Integer cdExame) {
		this.cdExame = cdExame;
	}


	public Date getDtExame() {
		return dtExame;
	}


	public void setDtExame(Date dtExame) {
		this.dtExame = dtExame;
	}


	public String getDsResultado() {
		return dsResultado;
	}


	public void setDsResultado(String dsResultado) {
		this.dsResultado = dsResultado;
	}


	public String getDsObservacao() {
		return dsObservacao;
	}


	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdProntuario);
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
		return Objects.equals(cdProntuario, other.cdProntuario);
	}


	
	
}
