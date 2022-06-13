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
	private Integer cdPaciente;
	
	@Column(name="cd_convenio", unique=true)
	private Integer cdConvenio;
	
	@Column(name="cd_laudo", unique=true)
	private Integer cdLaudo;
	
	@Column(name="cd_prontuario", unique=true)
	private Integer cdProntuario;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name="nm_paciente", unique=true)
	private String nmPaciente;
	
	@Column(name="nr_cpf", unique=true)
	private Integer nrCpf;
	
	@Column(name="nr_rg", unique=true)
	private Integer nrRg;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamano deve ser entre 1 e 50 caracteres")
	@Column(name="nm_pai", unique=true)
	private String nmPai;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name="nm_mae", unique=true)
	private String nmMae;
	
	@Column(name="nr_carteira", unique=true)
	private Integer nrCarteira;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name="ds_endereco", unique=true)
	private String dsEndereco;
	
	@Column(name="nr_telefone_res", unique=true)
	private Integer nrTelefone_res;
	
	@Column(name="nr_telefone_cel", unique=true)
	private Integer nrTelefone_cel;
	
	@Column(name="nr_telefone_com", unique=true)
	private Integer nrTelefone_com;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=50, message= "O tamanho deve ser entre 1 e 50 caracteres")
	@Column(name="de_email", unique=true)
	private String deEmail;
	
	@NotEmpty(message= "Preenchimento obrigatório")
	@Length(min=1, max=10, message= "O tamanho deve ser entre 1 e 10 caracteres")
	@Column(name="ds_senhaweb", unique=true)
	private String dsSenhaweb;
	
	@Column(name="nr_acessos", unique=true)
	private Integer nrAcessos;
	
	
	public Pacientes(){
		
	}


	public Pacientes(Integer cdPaciente, Integer cdConvenio, Integer cdLaudo, Integer cdProntuario,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres") String nmPaciente,
			Integer nrCpf, Integer nrRg,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamano deve ser entre 1 e 50 caracteres") String nmPai,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres") String nmMae,
			Integer nrCarteira,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres") String dsEndereco,
			Integer nrTelefone_res, Integer nrTelefone_cel, Integer nrTelefone_com,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 50, message = "O tamanho deve ser entre 1 e 50 caracteres") String deEmail,
			@NotEmpty(message = "Preenchimento obrigatório") @Length(min = 1, max = 10, message = "O tamanho deve ser entre 1 e 10 caracteres") String dsSenhaweb,
			Integer nrAcessos) {
		super();
		this.cdPaciente = cdPaciente;
		this.cdConvenio = cdConvenio;
		this.cdLaudo = cdLaudo;
		this.cdProntuario = cdProntuario;
		this.nmPaciente = nmPaciente;
		this.nrCpf = nrCpf;
		this.nrRg = nrRg;
		this.nmPai = nmPai;
		this.nmMae = nmMae;
		this.nrCarteira = nrCarteira;
		this.dsEndereco = dsEndereco;
		this.nrTelefone_res = nrTelefone_res;
		this.nrTelefone_cel = nrTelefone_cel;
		this.nrTelefone_com = nrTelefone_com;
		this.deEmail = deEmail;
		this.dsSenhaweb = dsSenhaweb;
		this.nrAcessos = nrAcessos;
	}


	public Integer getCdPaciente() {
		return cdPaciente;
	}


	public void setCdPaciente(Integer cdPaciente) {
		this.cdPaciente = cdPaciente;
	}


	public Integer getCdConvenio() {
		return cdConvenio;
	}


	public void setCdConvenio(Integer cdConvenio) {
		this.cdConvenio = cdConvenio;
	}


	public Integer getCdLaudo() {
		return cdLaudo;
	}


	public void setCdLaudo(Integer cdLaudo) {
		this.cdLaudo = cdLaudo;
	}


	public Integer getCdProntuario() {
		return cdProntuario;
	}


	public void setCdProntuario(Integer cdProntuario) {
		this.cdProntuario = cdProntuario;
	}


	public String getNmPaciente() {
		return nmPaciente;
	}


	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}


	public Integer getNrCpf() {
		return nrCpf;
	}


	public void setNrCpf(Integer nrCpf) {
		this.nrCpf = nrCpf;
	}


	public Integer getNrRg() {
		return nrRg;
	}


	public void setNrRg(Integer nrRg) {
		this.nrRg = nrRg;
	}


	public String getNmPai() {
		return nmPai;
	}


	public void setNmPai(String nmPai) {
		this.nmPai = nmPai;
	}


	public String getNmMae() {
		return nmMae;
	}


	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}


	public Integer getNrCarteira() {
		return nrCarteira;
	}


	public void setNrCarteira(Integer nrCarteira) {
		this.nrCarteira = nrCarteira;
	}


	public String getDsEndereco() {
		return dsEndereco;
	}


	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}


	public Integer getNrTelefone_res() {
		return nrTelefone_res;
	}


	public void setNrTelefone_res(Integer nrTelefone_res) {
		this.nrTelefone_res = nrTelefone_res;
	}


	public Integer getNrTelefone_cel() {
		return nrTelefone_cel;
	}


	public void setNrTelefone_cel(Integer nrTelefone_cel) {
		this.nrTelefone_cel = nrTelefone_cel;
	}


	public Integer getNrTelefone_com() {
		return nrTelefone_com;
	}


	public void setNrTelefone_com(Integer nrTelefone_com) {
		this.nrTelefone_com = nrTelefone_com;
	}


	public String getDeEmail() {
		return deEmail;
	}


	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}


	public String getDsSenhaweb() {
		return dsSenhaweb;
	}


	public void setDsSenhaweb(String dsSenhaweb) {
		this.dsSenhaweb = dsSenhaweb;
	}


	public Integer getNrAcessos() {
		return nrAcessos;
	}


	public void setNrAcessos(Integer nrAcessos) {
		this.nrAcessos = nrAcessos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cdPaciente);
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
		return Objects.equals(cdPaciente, other.cdPaciente);
	}
	
	
}
