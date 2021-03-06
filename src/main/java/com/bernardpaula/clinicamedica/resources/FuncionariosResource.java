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

import com.bernardpaula.clinicamedica.domain.Funcionarios;
import com.bernardpaula.clinicamedica.services.FuncionariosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionariosResource {

	@Autowired
	private FuncionariosService service;
	
	@ApiOperation(value = "Busca Funcionarios por id")
	@RequestMapping(value = "/pesquisar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Funcionarios> find(@PathVariable Integer id){
		Funcionarios obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Funcionarios")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Funcionarios obj){
		obj.setCdCargo(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdCargo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Funcionarios")
	@RequestMapping(value = "/atualizar/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Funcionarios> update(@Valid @RequestBody Funcionarios obj, @PathVariable Integer id){
		obj.setCdCargo(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Funcionarios")
	@RequestMapping(value = "/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna todas of Funcionarios")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Funcionarios>> findAll(){
		List<Funcionarios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma p??gina de Funcionarios")
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Funcionarios>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nmFuncionario")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Funcionarios> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value= "Retorna uma lista de Funcionarios filtrados pela pesquisa")
	@RequestMapping(value = "/filtrar{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Funcionarios>> filtrar(@PathVariable String pesquisa){
		List<Funcionarios> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
