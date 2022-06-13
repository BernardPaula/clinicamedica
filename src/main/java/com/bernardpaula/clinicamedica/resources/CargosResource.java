package com.bernardpaula.clinicamedica.resources;

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

import com.bernardpaula.clinicamedica.domain.Cargos;
import com.bernardpaula.clinicamedica.services.CargosService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/cargos")
public class CargosResource {

	@Autowired
	private CargosService service;
	
	@ApiOperation(value= "Busca por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cargos> find(@PathVariable Integer id){
		Cargos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value= "Insere Cargos")
	@RequestMapping(value = "/inserir", method = RequestMethod.POST )
	public ResponseEntity<Cargos> insert(@Valid @RequestBody Cargos obj){
		obj.setCdCargo(null);
		obj = service.insert(obj);
		
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_cargo()).toUri();
		//return ResponseEntity.created(uri).build();
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Atualiza Cargos")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cargos> update(@Valid @RequestBody Cargos obj, @PathVariable Integer id){
		obj.setCdCargo(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value= "Remove Cargos")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Retorna todos os Cargos")
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cargos>> findAll(){
		List<Cargos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma página de Cargos")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Cargos>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nmCargo")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Cargos> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Cargos filtrados pela pesquisa")
	@RequestMapping(value = "/filtrar/{pesquisa}", method = RequestMethod.GET)
	public ResponseEntity<List<Cargos>> filtrar(@PathVariable String pesquisa){
		List<Cargos> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
