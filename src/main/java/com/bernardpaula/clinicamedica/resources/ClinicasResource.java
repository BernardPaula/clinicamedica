package com.bernardpaula.clinicamedica.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.bernardpaula.clinicamedica.domain.Clinicas;
import com.bernardpaula.clinicamedica.services.ClinicasService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clinicas")
public class ClinicasResource {

	@Autowired
	private ClinicasService service;
	
	@ApiOperation(value= "Busca por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Clinicas> find(@PathVariable Integer id){
		Clinicas obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Clinicas")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public ResponseEntity<Clinicas> insert(@Valid @RequestBody Clinicas obj){
		obj = service.insert(obj);
		
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdClinica()).toUri();
		//return ResponseEntity.created(uri).build();
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Atualiza Clinicas")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Clinicas> update(@Valid @RequestBody Clinicas obj, @PathVariable Integer id){
		obj.setCdClinica(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Clinicas")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna todas as Clinicas")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Clinicas>> findAll(){
		List<Clinicas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Clinicas>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nmClinica")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Clinicas> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/filtrar/{pesquisa}", method = RequestMethod.GET)
	public ResponseEntity<List<Clinicas>> filtrar(@PathVariable String pesquisa){
		List<Clinicas> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
 	}
	
}
