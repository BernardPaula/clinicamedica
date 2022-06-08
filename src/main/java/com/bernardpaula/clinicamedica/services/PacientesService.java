package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Pacientes;
import com.bernardpaula.clinicamedica.repository.PacientesRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class PacientesService {

	@Autowired
	public PacientesRepository repo;
	
	public Pacientes find(Integer id) {
		Optional<Pacientes> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + Pacientes.class.getName()));
	}
	
	public Pacientes insert (Pacientes obj) {
		return repo.save(obj);
	}
	
	
	public Pacientes update(Pacientes obj) {
		Pacientes newObj = find(obj.getCd_paciente());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Pacientes newObj, Pacientes obj) {
		newObj.setCd_convenio(obj.getCd_convenio());
		newObj.setCd_laudo(obj.getCd_laudo());
		newObj.setCd_prontuario(obj.getCd_prontuario());
		newObj.setDe_email(obj.getDe_email());
		newObj.setDs_endereco(obj.getDs_endereco());
		newObj.setDs_senhaweb(obj.getDs_senhaweb());
		newObj.setNm_mae(obj.getNm_mae());
		newObj.setNm_pai(obj.getNm_pai());
		newObj.setNm_paciente(obj.getNm_paciente());
		newObj.setNr_acessos(obj.getNr_acessos());
		newObj.setNr_carteira(obj.getNr_carteira());
		newObj.setNr_cpf(obj.getNr_cpf());
		newObj.setNr_rg(obj.getNr_rg());
		newObj.setNr_telefone_cel(obj.getNr_telefone_cel());
		newObj.setNr_telefone_com(obj.getNr_telefone_com());
		newObj.setNr_telefone_res(obj.getNr_telefone_res());
		
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Pacientes> findAll(){
		return repo.findAll();
	}
	
	public Page<Pacientes> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
