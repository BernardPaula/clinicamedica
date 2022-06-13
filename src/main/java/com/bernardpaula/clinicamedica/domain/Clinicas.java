package com.bernardpaula.clinicamedica.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "clinicas")
public class Clinicas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdClinica;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name="nm_clinica", unique=true)
	private String nmClinica;
	
	@Column(name="nr_cnpj", unique=true)
	private Integer nrCnpj;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name="ds_especialidades", unique=true)
	private String dsEspecialidades;
	
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=30, message = "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_endereco", unique=true)
	private String dsEndereco;
	
	@Column(name="nr_numero", unique=true)
	private Integer nrNumero;
	
	@NotEmpty(message = "Preenchimento obrigatóri")
	@Length(min=1, max=30, message = "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_complemento", unique=true)
	private String dsComplemento;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=20, message = "O tamanho deve ser entre 1 e 20 caracteres")
	@Column(name="ds_bairro", unique=true)
	private String dsBairro;
	
	@Column(name="nr_cep", unique=true)
	private Integer nrCep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=20, message = "O tamanho deve ser entre 1 e 20 caracteres")
	@Column(name= "ds_cidade", unique=true)
	private String dsCidade;
	
	@Column(name="ds_uf", unique=true)
	private char dsUf;
	
	@Email
	@Column(name="ds_email", unique=true)
	@Length(min=1, max=30, message = "O tamanho deve ser entre 1 e 30 caracteres")
	private String dsEmail;
	
	@Column(name="nrTelefone", unique=true)
	private Integer nrTelefone;
	
	@Column(name="nr_fax", unique=true)
	private Integer nrFax;
	
	
	public Clinicas() {
		
	}


	public Clinicas(Integer cdClinica,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String nmClinica,
			Integer nrCnpj,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres") String dsEspecialidades,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsEndereco,
			Integer nrNumero,
			@NotEmpty(message = "Preenchimento obrigatóri") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsComplemento,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 20, message = "O tamanho deve ser entre 1 e 20 caracteres") String dsBairro,
			Integer nrCep,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 20, message = "O tamanho deve ser entre 1 e 20 caracteres") String dsCidade,
			char dsUf,
			@Email @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsEmail,
			Integer nrTelefone, Integer nrFax) {
		super();
		this.cdClinica = cdClinica;
		this.nmClinica = nmClinica;
		this.nrCnpj = nrCnpj;
		this.dsEspecialidades = dsEspecialidades;
		this.dsEndereco = dsEndereco;
		this.nrNumero = nrNumero;
		this.dsComplemento = dsComplemento;
		this.dsBairro = dsBairro;
		this.nrCep = nrCep;
		this.dsCidade = dsCidade;
		this.dsUf = dsUf;
		this.dsEmail = dsEmail;
		this.nrTelefone = nrTelefone;
		this.nrFax = nrFax;
	}


	public Integer getCdClinica() {
		return cdClinica;
	}


	public void setCdClinica(Integer cdClinica) {
		this.cdClinica = cdClinica;
	}


	public String getNmClinica() {
		return nmClinica;
	}


	public void setNmClinica(String nmClinica) {
		this.nmClinica = nmClinica;
	}


	public Integer getNrCnpj() {
		return nrCnpj;
	}


	public void setNrCnpj(Integer nrCnpj) {
		this.nrCnpj = nrCnpj;
	}


	public String getDsEspecialidades() {
		return dsEspecialidades;
	}


	public void setDsEspecialidades(String dsEspecialidades) {
		this.dsEspecialidades = dsEspecialidades;
	}


	public String getDsEndereco() {
		return dsEndereco;
	}


	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}


	public Integer getNrNumero() {
		return nrNumero;
	}


	public void setNrNumero(Integer nrNumero) {
		this.nrNumero = nrNumero;
	}


	public String getDsComplemento() {
		return dsComplemento;
	}


	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}


	public String getDsBairro() {
		return dsBairro;
	}


	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}


	public Integer getNrCep() {
		return nrCep;
	}


	public void setNrCep(Integer nrCep) {
		this.nrCep = nrCep;
	}


	public String getDsCidade() {
		return dsCidade;
	}


	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}


	public char getDsUf() {
		return dsUf;
	}


	public void setDsUf(char dsUf) {
		this.dsUf = dsUf;
	}


	public String getDsEmail() {
		return dsEmail;
	}


	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}


	public Integer getNrTelefone() {
		return nrTelefone;
	}


	public void setNrTelefone(Integer nrTelefone) {
		this.nrTelefone = nrTelefone;
	}


	public Integer getNrFax() {
		return nrFax;
	}


	public void setNrFax(Integer nrFax) {
		this.nrFax = nrFax;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdClinica);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clinicas other = (Clinicas) obj;
		return Objects.equals(cdClinica, other.cdClinica);
	}


	
	
}
