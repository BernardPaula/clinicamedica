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
public class Funcionarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_funcionario;
	
	private String rm_funcionario;
	private Integer cd_clinica;
	private Integer nr_rg;
	private Integer nr_cpf;
	private Integer cd_cargo;
	private String ds_endereco;
	private Integer nr_numero;
	private Integer ds_complemento;
	private String ds_bairro;
	private Integer nr_cep;
	private Integer nr_telres;
	private Integer nr_telcel;
	private String nm_usuario;
	private String ds_senha;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_ecesso;     // esta como DATETIME
	
	private Integer nr_acessos;
	private char fl_admin;
	
	
	public Funcionarios() {
		
	}


	public Funcionarios(Integer cd_funcionario, String rm_funcionario, Integer cd_clinica, Integer nr_rg,
			Integer nr_cpf, Integer cd_cargo, String ds_endereco, Integer nr_numero, Integer ds_complemento,
			String ds_bairro, Integer nr_cep, Integer nr_telres, Integer nr_telcel, String nm_usuario, String ds_senha,
			Date dt_ecesso, Integer nr_acessos, char fl_admin) {
		super();
		this.cd_funcionario = cd_funcionario;
		this.rm_funcionario = rm_funcionario;
		this.cd_clinica = cd_clinica;
		this.nr_rg = nr_rg;
		this.nr_cpf = nr_cpf;
		this.cd_cargo = cd_cargo;
		this.ds_endereco = ds_endereco;
		this.nr_numero = nr_numero;
		this.ds_complemento = ds_complemento;
		this.ds_bairro = ds_bairro;
		this.nr_cep = nr_cep;
		this.nr_telres = nr_telres;
		this.nr_telcel = nr_telcel;
		this.nm_usuario = nm_usuario;
		this.ds_senha = ds_senha;
		this.dt_ecesso = dt_ecesso;
		this.nr_acessos = nr_acessos;
		this.fl_admin = fl_admin;
	}


	public Integer getCd_funcionario() {
		return cd_funcionario;
	}


	public void setCd_funcionario(Integer cd_funcionario) {
		this.cd_funcionario = cd_funcionario;
	}


	public String getRm_funcionario() {
		return rm_funcionario;
	}


	public void setRm_funcionario(String rm_funcionario) {
		this.rm_funcionario = rm_funcionario;
	}


	public Integer getCd_clinica() {
		return cd_clinica;
	}


	public void setCd_clinica(Integer cd_clinica) {
		this.cd_clinica = cd_clinica;
	}


	public Integer getNr_rg() {
		return nr_rg;
	}


	public void setNr_rg(Integer nr_rg) {
		this.nr_rg = nr_rg;
	}


	public Integer getNr_cpf() {
		return nr_cpf;
	}


	public void setNr_cpf(Integer nr_cpf) {
		this.nr_cpf = nr_cpf;
	}


	public Integer getCd_cargo() {
		return cd_cargo;
	}


	public void setCd_cargo(Integer cd_cargo) {
		this.cd_cargo = cd_cargo;
	}


	public String getDs_endereco() {
		return ds_endereco;
	}


	public void setDs_endereco(String ds_endereco) {
		this.ds_endereco = ds_endereco;
	}


	public Integer getNr_numero() {
		return nr_numero;
	}


	public void setNr_numero(Integer nr_numero) {
		this.nr_numero = nr_numero;
	}


	public Integer getDs_complemento() {
		return ds_complemento;
	}


	public void setDs_complemento(Integer ds_complemento) {
		this.ds_complemento = ds_complemento;
	}


	public String getDs_bairro() {
		return ds_bairro;
	}


	public void setDs_bairro(String ds_bairro) {
		this.ds_bairro = ds_bairro;
	}


	public Integer getNr_cep() {
		return nr_cep;
	}


	public void setNr_cep(Integer nr_cep) {
		this.nr_cep = nr_cep;
	}


	public Integer getNr_telres() {
		return nr_telres;
	}


	public void setNr_telres(Integer nr_telres) {
		this.nr_telres = nr_telres;
	}


	public Integer getNr_telcel() {
		return nr_telcel;
	}


	public void setNr_telcel(Integer nr_telcel) {
		this.nr_telcel = nr_telcel;
	}


	public String getNm_usuario() {
		return nm_usuario;
	}


	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}


	public String getDs_senha() {
		return ds_senha;
	}


	public void setDs_senha(String ds_senha) {
		this.ds_senha = ds_senha;
	}


	public Date getDt_ecesso() {
		return dt_ecesso;
	}


	public void setDt_ecesso(Date dt_ecesso) {
		this.dt_ecesso = dt_ecesso;
	}


	public Integer getNr_acessos() {
		return nr_acessos;
	}


	public void setNr_acessos(Integer nr_acessos) {
		this.nr_acessos = nr_acessos;
	}


	public char getFl_admin() {
		return fl_admin;
	}


	public void setFl_admin(char fl_admin) {
		this.fl_admin = fl_admin;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_cargo);
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
		return Objects.equals(cd_cargo, other.cd_cargo);
	}
	
	
	
}
