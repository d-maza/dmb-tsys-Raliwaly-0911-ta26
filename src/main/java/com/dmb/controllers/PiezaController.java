package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Pieza;
import com.dmb.services.PiezaService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class PiezaController {

	@Autowired
	private PiezaService serv;

	@GetMapping("/piezas")
	public List<Pieza> getAllPieza() {
		return serv.getAllPieza();
	}

	@GetMapping("/pieza/{id}")
	public Pieza getOnePieza(@PathVariable(name = "id") Long id) {
			return serv.getOnePieza(id).get();

	}

	@PostMapping("/pieza")
	public Pieza savePieza(@RequestBody Pieza entity) {
		return serv.createPieza(entity);
	}

	@PutMapping("/pieza/{id}")
	public Pieza updatePieza(@PathVariable(name = "id") Long id, @RequestBody Pieza entity) {
		  Pieza entityOld = serv.getOnePieza(id).get();
		  entity.setId(entityOld.getId());
		  entity.setNombre(entity.getNombre());
		  entity.setSuministra(entityOld.getSuministra());		  
		  return serv.updatePieza(entity);	  
	
	}

	@DeleteMapping("/pieza/{id}")
	public void deletePieza(@PathVariable(name = "id") Long id) {
			serv.deletePieza(id);
		
	}

}
