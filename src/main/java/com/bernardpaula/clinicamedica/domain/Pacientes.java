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
@Table(name="pacientes")
public class Pacientes implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_paciente;
	
	@Column(unique=true)
	private Integer cd_convenio;
	
	@Column(unique=true)
	private Integer cd_laudo;
	
	@Column(unique=true)
	private Integer cd_prontuario;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(unique=true)
	private String nm_paciente;
	
	@Column(unique=true)
	private Integer nr_cpf;
	
	@Column(unique=true)
	private Integer nr_rg;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamano deve ser entre 1 e 50 caracteres")
	@Column(unique=true)
	private String nm_pai;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(unique=true)
	private String nm_mae;
	
	@Column(unique=true)
	private Integer nr_carteira;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(unique=true)
	private String ds_endereco;
	
	@Column(unique=true)
	private Integer nr_telefone_res;
	
	@Column(unique=true)
	private Integer nr_telefone_cel;
	
	@Column(unique=true)
	private Integer nr_telefone_com;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(unique=true)
	private String de_email;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=10, message= "O tamanho deve ser entre 1 e 10 caracteres")
	@Column(unique=true)
	private String ds_senhaweb;
	
	@Column(unique=true)
	private Integer nr_acessos;
	
	
	public Pacientes(){
		
	}


	public Pacientes(Integer cd_paciente, Integer cd_convenio, Integer cd_laudo, Integer cd_prontuario,
			String nm_paciente, Integer nr_cpf, Integer nr_rg, String nm_pai, String nm_mae, Integer nr_carteira,
			String ds_endereco, Integer nr_telefone_res, Integer nr_telefone_cel, Integer nr_telefone_com,
			String de_email, String ds_senhaweb, Integer nr_acessos) {
		super();
		this.cd_paciente = cd_paciente;
		this.cd_convenio = cd_convenio;
		this.cd_laudo = cd_laudo;
		this.cd_prontuario = cd_prontuario;
		this.nm_paciente = nm_paciente;
		this.nr_cpf = nr_cpf;
		this.nr_rg = nr_rg;
		this.nm_pai = nm_pai;
		this.nm_mae = nm_mae;
		this.nr_carteira = nr_carteira;
		this.ds_endereco = ds_endereco;
		this.nr_telefone_res = nr_telefone_res;
		this.nr_telefone_cel = nr_telefone_cel;
		this.nr_telefone_com = nr_telefone_com;
		this.de_email = de_email;
		this.ds_senhaweb = ds_senhaweb;
		this.nr_acessos = nr_acessos;
	}


	public Integer getCd_paciente() {
		return cd_paciente;
	}


	public void setCd_paciente(Integer cd_paciente) {
		this.cd_paciente = cd_paciente;
	}


	public Integer getCd_convenio() {
		return cd_convenio;
	}


	public void setCd_convenio(Integer cd_convenio) {
		this.cd_convenio = cd_convenio;
	}


	public Integer getCd_laudo() {
		return cd_laudo;
	}


	public void setCd_laudo(Integer cd_laudo) {
		this.cd_laudo = cd_laudo;
	}


	public Integer getCd_prontuario() {
		return cd_prontuario;
	}


	public void setCd_prontuario(Integer cd_prontuario) {
		this.cd_prontuario = cd_prontuario;
	}


	public String getNm_paciente() {
		return nm_paciente;
	}


	public void setNm_paciente(String nm_paciente) {
		this.nm_paciente = nm_paciente;
	}


	public Integer getNr_cpf() {
		return nr_cpf;
	}


	public void setNr_cpf(Integer nr_cpf) {
		this.nr_cpf = nr_cpf;
	}


	public Integer getNr_rg() {
		return nr_rg;
	}


	public void setNr_rg(Integer nr_rg) {
		this.nr_rg = nr_rg;
	}


	public String getNm_pai() {
		return nm_pai;
	}


	public void setNm_pai(String nm_pai) {
		this.nm_pai = nm_pai;
	}


	public String getNm_mae() {
		return nm_mae;
	}


	public void setNm_mae(String nm_mae) {
		this.nm_mae = nm_mae;
	}


	public Integer getNr_carteira() {
		return nr_carteira;
	}


	public void setNr_carteira(Integer nr_carteira) {
		this.nr_carteira = nr_carteira;
	}


	public String getDs_endereco() {
		return ds_endereco;
	}


	public void setDs_endereco(String ds_endereco) {
		this.ds_endereco = ds_endereco;
	}


	public Integer getNr_telefone_res() {
		return nr_telefone_res;
	}


	public void setNr_telefone_res(Integer nr_telefone_res) {
		this.nr_telefone_res = nr_telefone_res;
	}


	public Integer getNr_telefone_cel() {
		return nr_telefone_cel;
	}


	public void setNr_telefone_cel(Integer nr_telefone_cel) {
		this.nr_telefone_cel = nr_telefone_cel;
	}


	public Integer getNr_telefone_com() {
		return nr_telefone_com;
	}


	public void setNr_telefone_com(Integer nr_telefone_com) {
		this.nr_telefone_com = nr_telefone_com;
	}


	public String getDe_email() {
		return de_email;
	}


	public void setDe_email(String de_email) {
		this.de_email = de_email;
	}


	public String getDs_senhaweb() {
		return ds_senhaweb;
	}


	public void setDs_senhaweb(String ds_senhaweb) {
		this.ds_senhaweb = ds_senhaweb;
	}


	public Integer getNr_acessos() {
		return nr_acessos;
	}


	public void setNr_acessos(Integer nr_acessos) {
		this.nr_acessos = nr_acessos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cd_convenio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacientes other = (Pacientes) obj;
		return Objects.equals(cd_convenio, other.cd_convenio);
	}
	
	
	
	
}
