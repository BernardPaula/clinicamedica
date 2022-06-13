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
@Table(name="medicos")
public class Medicos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer cdMedico;
	
	@Column(name="cd_laudo", unique=true)
	private Integer cdLaudo;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=40, message= "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name = "nm_medico")
	private String nmMedico;
	
	@Column(name="nr_g", unique=true)
	private Integer nrRg;
	
	@Column(name="nr_cpf", unique=true)
	private Integer nrCpf;
	
	@Column(name="nr_crm", unique=true)
	private Integer nrCrm;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=80, message= "O tamanho deve ser entre 1 e 80 caracteres")
	@Column(name="ds_area", unique=true)
	private String dsArea;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=40, message= "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name="ds_especialidades", unique=true)
	private String dsEspecialidades;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=10, message= "O tamanho deve ser entre 1 e 10 caracteres")
	@Column(name="nm_usuario", unique=true)
	private String nmUsuario;
	
	@Column(name="ds_senha", unique=true)
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=10, message= "O tamano deve ser entre 1 e 10 caracteres")
	private String dsSenha;
	
	@Column(name="fl_admin", unique=true)
	private char flAdmin;
	
	@Column(name= "nr_pessoas", unique=true)
	private Integer nrPessoas;
	
	
	public Medicos() {
		
	}


	public Medicos(Integer cdMedico, Integer cdLaudo,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String nmMedico,
			Integer nrRg, Integer nrCpf, Integer nrCrm,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 80, message = "O tamanho deve ser entre 1 e 80 caracteres") String dsArea,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String dsEspecialidades,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 10, message = "O tamanho deve ser entre 1 e 10 caracteres") String nmUsuario,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 10, message = "O tamano deve ser entre 1 e 10 caracteres") String dsSenha,
			char flAdmin, Integer nrPessoas) {
		super();
		this.cdMedico = cdMedico;
		this.cdLaudo = cdLaudo;
		this.nmMedico = nmMedico;
		this.nrRg = nrRg;
		this.nrCpf = nrCpf;
		this.nrCrm = nrCrm;
		this.dsArea = dsArea;
		this.dsEspecialidades = dsEspecialidades;
		this.nmUsuario = nmUsuario;
		this.dsSenha = dsSenha;
		this.flAdmin = flAdmin;
		this.nrPessoas = nrPessoas;
	}


	public Integer getCdMedico() {
		return cdMedico;
	}


	public void setCdMedico(Integer cdMedico) {
		this.cdMedico = cdMedico;
	}


	public Integer getCdLaudo() {
		return cdLaudo;
	}


	public void setCdLaudo(Integer cdLaudo) {
		this.cdLaudo = cdLaudo;
	}


	public String getNmMedico() {
		return nmMedico;
	}


	public void setNmMedico(String nmMedico) {
		this.nmMedico = nmMedico;
	}


	public Integer getNrRg() {
		return nrRg;
	}


	public void setNrRg(Integer nrRg) {
		this.nrRg = nrRg;
	}


	public Integer getNrCpf() {
		return nrCpf;
	}


	public void setNrCpf(Integer nrCpf) {
		this.nrCpf = nrCpf;
	}


	public Integer getNrCrm() {
		return nrCrm;
	}


	public void setNrCrm(Integer nrCrm) {
		this.nrCrm = nrCrm;
	}


	public String getDsArea() {
		return dsArea;
	}


	public void setDsArea(String dsArea) {
		this.dsArea = dsArea;
	}


	public String getDsEspecialidades() {
		return dsEspecialidades;
	}


	public void setDsEspecialidades(String dsEspecialidades) {
		this.dsEspecialidades = dsEspecialidades;
	}


	public String getNmUsuario() {
		return nmUsuario;
	}


	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}


	public String getDsSenha() {
		return dsSenha;
	}


	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}


	public char getFlAdmin() {
		return flAdmin;
	}


	public void setFlAdmin(char flAdmin) {
		this.flAdmin = flAdmin;
	}


	public Integer getNrPessoas() {
		return nrPessoas;
	}


	public void setNrPessoas(Integer nrPessoas) {
		this.nrPessoas = nrPessoas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdLaudo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicos other = (Medicos) obj;
		return Objects.equals(cdLaudo, other.cdLaudo);
	}

	
	
}
