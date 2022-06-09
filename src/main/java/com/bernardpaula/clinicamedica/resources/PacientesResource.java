package com.bernardpaula.clinicamedica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bernardpaula.clinicamedica.domain.Pacientes;
import com.bernardpaula.clinicamedica.services.PacientesService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pacientes")
public class PacientesResource {

	@Autowired
	private PacientesService service;
	
	@ApiOperation(value = "Retorna Pacientes por id")
	@RequestMapping(value = "/pesquisar/{id}", method=RequestMethod.GET)
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
	@RequestMapping(value = "/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Pacientes> update(@RequestBody Pacientes obj, @PathVariable Integer id){
		obj.setCd_paciente(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Pacientes")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
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
	
	@ApiOperation(value = "Retorna uma página de Pacientes")
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Pacientes>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nm_paciente")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Pacientes> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Pacientes filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Pacientes>> filtrar(@PathVariable String pesquisa){
		List<Pacientes> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
