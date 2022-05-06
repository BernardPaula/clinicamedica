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

import com.bernardpaula.clinicamedica.domain.Pacientes;
import com.bernardpaula.clinicamedica.services.PacientesService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pacientes")
public class PacientesResource {

	@Autowired
	public PacientesService service;
	
	@ApiOperation(value = "Retorna Pacientes por id")
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pacientes> find(@PathVariable Integer id){
		Pacientes obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Pacientes")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Pacientes obj){
		obj.setCd_paciente(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_paciente()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Pacientes")
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Pacientes obj, @PathVariable Integer id){
		obj.setCd_paciente(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remove Pacientes")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todas os Pacientes")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Pacientes>> findAll(){
		List<Pacientes> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
