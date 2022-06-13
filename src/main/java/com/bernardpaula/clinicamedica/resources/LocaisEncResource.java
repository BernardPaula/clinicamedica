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

import com.bernardpaula.clinicamedica.domain.LocaisEnc;
import com.bernardpaula.clinicamedica.services.LocaisEncService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/locaisencs")
public class LocaisEncResource {

	@Autowired
	private LocaisEncService service;
	
	@ApiOperation(value = "Busca LocaisEnc por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<LocaisEnc> find(@PathVariable Integer id){
		LocaisEnc obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere LocaisEnc")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody LocaisEnc obj){
		obj.setCodLocalEnc(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodLocalEnc()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza LocaisEnc")
	@RequestMapping(value = "/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<LocaisEnc> update(@RequestBody LocaisEnc obj, @PathVariable Integer id){
		obj.setCodLocalEnc(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove LocaisEnc")
	@RequestMapping(value = "/deletar/{id}", method =RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todos os LocaisEnc")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<LocaisEnc>> findAll(){
		List<LocaisEnc> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Retorna uma página de LocaisEncs")
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<LocaisEnc>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nmClinica")String OrderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<LocaisEnc> list = service.findPage(page, linesPerPage, OrderBy, direction);
		return ResponseEntity.ok().body(list);
		}
	
	@ApiOperation(value = "Retorna uma lista de LocaisEncs filtrados pela pesquisa")
	@RequestMapping(value = "/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<LocaisEnc>> filtrar(@PathVariable String pesquisa){
		List<LocaisEnc> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
