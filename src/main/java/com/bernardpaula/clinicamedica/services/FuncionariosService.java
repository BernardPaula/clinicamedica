package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Funcionarios;
import com.bernardpaula.clinicamedica.repository.FuncionariosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionariosService {

	@Autowired
	public FuncionariosRepository repo;
	
	
	public Funcionarios find(Integer id) {
		Optional<Funcionarios> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + Funcionarios.class.getName()));
	}
	
	public Funcionarios insert(Funcionarios obj) {
		return repo.save(obj);
	}
	
	public Funcionarios update(Funcionarios obj) {
		Funcionarios newObj = find(obj.getCd_cargo());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Funcionarios newObj, Funcionarios obj) {
		newObj.setCd_clinica(obj.getCd_clinica());
		newObj.setDs_bairro(obj.getDs_bairro());
		newObj.setDs_complemento(obj.getDs_complemento());
		newObj.setDs_endereco(obj.getDs_endereco());
		newObj.setDs_senha(obj.getDs_senha());
		newObj.setDt_ecesso(obj.getDt_ecesso());
		newObj.setFl_admin(obj.getFl_admin());
		newObj.setNm_usuario(obj.getNm_usuario());
		newObj.setNr_acessos(obj.getNr_acessos());
		newObj.setNr_cep(obj.getNr_cep());
		newObj.setNr_cpf(obj.getNr_cpf());
		newObj.setNr_numero(obj.getNr_numero());
		newObj.setNr_rg(obj.getNr_rg());
		newObj.setNr_telcel(obj.getNr_telcel());
		newObj.setNr_telres(obj.getNr_telres());
		newObj.setRm_funcionario(obj.getRm_funcionario());
		newObj.setCd_cargo(obj.getCd_cargo());
	}
	
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	
	public List<Funcionarios> findAll(){
		return repo.findAll();
	}
	
}
