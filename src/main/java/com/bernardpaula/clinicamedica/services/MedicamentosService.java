package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Medicamentos;
import com.bernardpaula.clinicamedica.repository.MedicamentosRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class MedicamentosService {

	@Autowired
	public MedicamentosRepository repo;
	
	public Medicamentos find(Integer id) {
		Optional<Medicamentos> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + "Tipo: " + Medicamentos.class.getName()));
	}
	
	public Medicamentos insert(Medicamentos obj) {
		return repo.save(obj);
	}
	
	public Medicamentos update(Medicamentos obj) {
		Medicamentos newObj = find(obj.getCd_medicamento());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Medicamentos newObj, Medicamentos obj) {
		newObj.setDs_contraind(obj.getDs_contraind());
		newObj.setDs_generico(obj.getDs_contraind());
		newObj.setDs_laboratorio(obj.getDs_laboratorio());
		newObj.setDs_posologia(obj.getDs_posologia());
		newObj.setDs_substancia(obj.getDs_substancia());
		newObj.setNm_medicamento(obj.getNm_medicamento());
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Medicamentos> findAll(){
		return repo.findAll();
	}
	
	public Page<Medicamentos> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
