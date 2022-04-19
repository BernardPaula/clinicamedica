package com.bernardpaula.clinicamedica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bernardpaula.clinicamedica.domain.Medicamentos;
import com.bernardpaula.clinicamedica.services.MedicamentosService;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentosResource {

	@Autowired
	public MedicamentosService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Medicamentos> find(@PathVariable Integer id){
		Medicamentos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Medicamentos obj){
		obj.setCd_medicamento(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_medicamento()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Medicamentos obj, @PathVariable Integer id){
		obj.setCd_medicamento(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Medicamentos>> findAll(){
		List<Medicamentos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}