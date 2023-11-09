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
@OpenAPIDefinition(
		  servers = {
		    @Server(url = "https://dmb-tsys-raliwaly-0911-ta26-production.up.railway.app/", description = "Default Server URL")
		  }
		)
public class PiezaController {

	@Autowired
	private PiezaService serv;

	@GetMapping("/piezas")
	public ResponseEntity<List<Pieza>> getAllPieza() {
		return ResponseEntity.ok(serv.getAllPieza());
	}

	@GetMapping("/pieza/{id}")
	public ResponseEntity<Pieza> getOnePieza(@PathVariable(name = "id") Long id) {
		Optional<Pieza> pieza = serv.getOnePieza(id);

		if (pieza.isPresent()) {
			return ResponseEntity.ok(pieza.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/pieza")
	public ResponseEntity<Pieza> savePieza(@RequestBody Pieza entity) {
		return ResponseEntity.ok(serv.createPieza(entity));
	}

	@PutMapping("/pieza/{id}")
	public ResponseEntity<Pieza> updatePieza(@PathVariable(name = "id") Long id, @RequestBody Pieza entity) {
		Optional<Pieza> entityOld = serv.getOnePieza(id);

		if (entityOld.isPresent()) {
			Pieza entityUpdate = serv.createPieza(entity);
			return ResponseEntity.ok(entityUpdate);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/pieza/{id}")
	public ResponseEntity<Void> deletePieza(@PathVariable(name = "id") Long id) {
		Optional<Pieza> entity = serv.getOnePieza(id);
		if (entity.isPresent()) {
			serv.deletePieza(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
