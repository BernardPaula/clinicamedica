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

import com.bernardpaula.clinicamedica.domain.Medicamentos;
import com.bernardpaula.clinicamedica.services.MedicamentosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentosResource {

	@Autowired
	private MedicamentosService service;
	
	@ApiOperation(value = "Busca Medicamentos por id")
	@RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Medicamentos> find(@PathVariable Integer id){
		Medicamentos obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Insere Medicamentos")
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Medicamentos obj){
		obj.setCdMedicamento(null);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCdMedicamento()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualiza Medicamentos")
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Medicamentos> update(@RequestBody Medicamentos obj, @PathVariable Integer id){
		obj.setCdMedicamento(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Remove Medicamentos")
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Lista todos os Medicamentos")
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Medicamentos>> findAll(){
		List<Medicamentos> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma página de Medicamentos")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Medicamentos>> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nmMedicamento")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Medicamentos> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Retorna uma lista de Medicamentos filtrados pela pesquisa")
	@RequestMapping(value="/filtrar/{pesquisa}", method=RequestMethod.GET)
	public ResponseEntity<List<Medicamentos>> filtrar(@PathVariable String pesquisa){
		List<Medicamentos> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
	
}
