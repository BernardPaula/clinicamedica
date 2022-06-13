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
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "funcionarios")
public class Funcionarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdFuncionario;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=40, message= "O tamanho deve ser entre 1 e 40 caracteres")
	@Column(name="nm_funcionario", unique=true)
	private String nmFuncionario;
	
	@Column(name="cd_clinica", unique=true)
	private Integer cdClinica;
	
	@Column(name="nr_RG", unique=true)
	private Integer nrRg;
	
	@CPF
	@Column(name="nr_cpf", unique=true)
	private Integer nrCpf;
	
	@Column(name="cd_cargo", unique=true)
	private Integer cdCargo;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=30, message= "O tamanho deve ser entre 1 e 30 caracteres")
	@Column(name="ds_endereco", unique=true)
	private String dsEndereco;
	
	@Column(name="nr_numero", unique=true)
	private Integer nrNumero;
	
	@Column(name="ds_complemento", unique=true)
	private Integer dsComplemento;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=15, message= "O tamanho deve ser entre 1 e 15 caracteres")
	@Column(name="ds_bairro", unique=true)
	private String dsBairro;
	
	@Column(name="nr_cep", unique=true)
	private Integer nrCep;
	
	@Column(name="nr_telres", unique=true)
	private Integer nrTelres;
	
	@Column(name="nr_telcel", unique=true)
	private Integer nrTelcel;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=10, message= "O tamanho deve ser entre 1 e 10 caracteres")
	@Column(name="nm_usuario", unique=true)
	private String nmUsuario;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=10, message= "O tamanho deve ser entre 1 e 10 caracteres")
	@Column(name="ds_senha", unique=true)
	private String dsSenha;
	
	@JsonFormat( pattern = "yyyy/MM/dd")
	private Date dtEcesso;     // esta como DATETIME
	
	@Column(name="nr_acessos", unique=true)
	private Integer nrAcessos;
	
	@Column(name="fl_admin", unique=true)
	private char flAdmin;
	
	
	public Funcionarios() {
		
	}


	public Funcionarios(Integer cdFuncionario,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 40, message = "O tamanho deve ser entre 1 e 40 caracteres") String nmFuncionario,
			Integer cdClinica, Integer nrRg, @CPF Integer nrCpf, Integer cdCargo,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres") String dsEndereco,
			Integer nrNumero, Integer dsComplemento,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 15, message = "O tamanho deve ser entre 1 e 15 caracteres") String dsBairro,
			Integer nrCep, Integer nrTelres, Integer nrTelcel,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 10, message = "O tamanho deve ser entre 1 e 10 caracteres") String nmUsuario,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 10, message = "O tamanho deve ser entre 1 e 10 caracteres") String dsSenha,
			Date dtEcesso, Integer nrAcessos, char flAdmin) {
		super();
		this.cdFuncionario = cdFuncionario;
		this.nmFuncionario = nmFuncionario;
		this.cdClinica = cdClinica;
		this.nrRg = nrRg;
		this.nrCpf = nrCpf;
		this.cdCargo = cdCargo;
		this.dsEndereco = dsEndereco;
		this.nrNumero = nrNumero;
		this.dsComplemento = dsComplemento;
		this.dsBairro = dsBairro;
		this.nrCep = nrCep;
		this.nrTelres = nrTelres;
		this.nrTelcel = nrTelcel;
		this.nmUsuario = nmUsuario;
		this.dsSenha = dsSenha;
		this.dtEcesso = dtEcesso;
		this.nrAcessos = nrAcessos;
		this.flAdmin = flAdmin;
	}


	public Integer getCdFuncionario() {
		return cdFuncionario;
	}


	public void setCdFuncionario(Integer cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}


	public String getNmFuncionario() {
		return nmFuncionario;
	}


	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}


	public Integer getCdClinica() {
		return cdClinica;
	}


	public void setCdClinica(Integer cdClinica) {
		this.cdClinica = cdClinica;
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


	public Integer getCdCargo() {
		return cdCargo;
	}


	public void setCdCargo(Integer cdCargo) {
		this.cdCargo = cdCargo;
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


	public Integer getDsComplemento() {
		return dsComplemento;
	}


	public void setDsComplemento(Integer dsComplemento) {
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


	public Integer getNrTelres() {
		return nrTelres;
	}


	public void setNrTelres(Integer nrTelres) {
		this.nrTelres = nrTelres;
	}


	public Integer getNrTelcel() {
		return nrTelcel;
	}


	public void setNrTelcel(Integer nrTelcel) {
		this.nrTelcel = nrTelcel;
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


	public Date getDtEcesso() {
		return dtEcesso;
	}


	public void setDtEcesso(Date dtEcesso) {
		this.dtEcesso = dtEcesso;
	}


	public Integer getNrAcessos() {
		return nrAcessos;
	}


	public void setNrAcessos(Integer nrAcessos) {
		this.nrAcessos = nrAcessos;
	}


	public char getFlAdmin() {
		return flAdmin;
	}


	public void setFlAdmin(char flAdmin) {
		this.flAdmin = flAdmin;
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
		Funcionarios other = (Funcionarios) obj;
		return Objects.equals(cdCargo, other.cdCargo);
	}

	
}
