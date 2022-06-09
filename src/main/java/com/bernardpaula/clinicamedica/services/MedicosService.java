package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Medicos;
import com.bernardpaula.clinicamedica.repository.MedicosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class MedicosService {

	@Autowired
	public MedicosRepository repo;
	
	public Medicos find(Integer id) {
		Optional<Medicos> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + Medicos.class.getName()));
	}
	
	public Medicos insert (Medicos obj) {
		return repo.save(obj);
	}
	
	
	public Medicos update(Medicos obj) {
		Medicos newObj = find(obj.getCd_medico());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Medicos newObj, Medicos obj) {
		newObj.setCd_laudo(obj.getCd_laudo());
		newObj.setDs_area(obj.getDs_area());
		newObj.setDs_especialidades(obj.getDs_especialidades());
		newObj.setDs_senha(obj.getDs_senha());
		newObj.setFl_admin(obj.getFl_admin());
		newObj.setNm_medico(obj.getNm_medico());
		newObj.setNm_usuario(obj.getNm_usuario());
		newObj.setNr_cpf(obj.getNr_cpf());
		newObj.setNr_crm(obj.getNr_crm());
		newObj.setNr_pessoas(obj.getNr_pessoas());
		newObj.setNr_rg(obj.getNr_rg());
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Medicos> findAll(){
		return repo.findAll();
	}

	public Page<Medicos> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Medicos> filtrar(String pesquisa){
		return repo.filtrar(pesquisa);
	}
	
}
