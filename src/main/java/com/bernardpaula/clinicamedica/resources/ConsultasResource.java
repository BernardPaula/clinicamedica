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

import com.bernardpaula.clinicamedica.domain.Consultas;
import com.bernardpaula.clinicamedica.services.ConsultasService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultasResource {

	@Autowired
	private ConsultasService service;
	
	@ApiOperation(value = "Busca por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Consultas> find(@PathVariable Integer id){
		Consultas obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Consultas")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Consultas obj){
		obj.setCdConsulta(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdConsulta()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Consultas")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Consultas> update(@RequestBody Consultas obj, @PathVariable Integer id){
		obj.setCdConsulta(id);
		obj = service.update(obj);
		return  ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Consultas")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna todas as Consultas")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Consultas>> findAll(){
		List<Consultas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma p??gina de consultas")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Consultas>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "dtConsulta")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Consultas> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Consultas>> filtrar(@PathVariable String pesquisa){
		List<Consultas> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
