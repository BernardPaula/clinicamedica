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

import com.bernardpaula.clinicamedica.domain.Medicos;
import com.bernardpaula.clinicamedica.services.MedicosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/medicos")
public class MidicosResource {

	@Autowired
	private MedicosService service;
	
	@ApiOperation(value = "Busca Medicos por id")
	@RequestMapping(value = "/pesquisar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Medicos> find(@PathVariable Integer id){
		Medicos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Medicos")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Medicos obj){
		obj.setCd_medico(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_medico()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Medicos")
	@RequestMapping(value = "/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Medicos> update(@RequestBody Medicos obj, @PathVariable Integer id){
		obj.setCd_medico(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Medicos")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todos os Medicos")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Medicos>> findAll(){
		List<Medicos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma de página de Medicos")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Medicos>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nm_medico")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Medicos> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Medicos filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Medicos>> filtrar(@PathVariable String pesquisa){
		List<Medicos> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
