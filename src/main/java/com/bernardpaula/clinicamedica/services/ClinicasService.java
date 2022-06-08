package com.bernardpaula.clinicamedica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bernardpaula.clinicamedica.domain.Clinicas;
import com.bernardpaula.clinicamedica.repository.ClinicasRepository;
import com.bernardpaula.clinicamedica.services.exceptions.ObjectNotFoundException;

@Service
public class ClinicasService {

	@Autowired
	public ClinicasRepository repo;
	
	
	public Clinicas find(Integer id) {
		Optional<Clinicas> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + "Tipo: " + Clinicas.class.getName()));
	}
	
	public Clinicas insert(Clinicas obj) {
		obj.setCd_clinica(null);
		return repo.save(obj);
	}
	
	public Clinicas update (Clinicas obj) {
		Clinicas newObj = find(obj.getCd_clinica());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Clinicas newObj, Clinicas obj) {
		newObj.setDs_bairro(obj.getDs_bairro());
		newObj.setDs_cidade(obj.getDs_cidade());
		newObj.setDs_complemento(obj.getDs_complemento());
		newObj.setDs_email(obj.getDs_email());
		newObj.setDs_endereco(obj.getDs_endereco());
		newObj.setDs_especialidades(obj.getDs_especialidades());
		newObj.setDs_uf(obj.getDs_uf());
		newObj.setNm_clinica(obj.getNm_clinica());
		newObj.setNr_cep(obj.getNr_cep());
		newObj.setNr_cnpj(obj.getNr_cnpj());
		newObj.setNr_fax(obj.getNr_fax());
		newObj.setNr_numero(obj.getNr_numero());
		newObj.setNr_telefone(obj.getNr_telefone());
		
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		}
	
	public List<Clinicas> findAll(){
		return repo.findAll();
	}
	
	public Page<Clinicas> findPage(Integer nome, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(nome, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Clinicas> filtrar(String pesquisa){
		return repo.filtrarPesquisa(pesquisa);
	}
}
