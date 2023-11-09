package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

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

import com.dmb.entities.Suministra;
import com.dmb.services.SuministraService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin (origins = "*")
public class SuministraController {
	
	@Autowired
	private SuministraService serv;
	
	@GetMapping("/suministas")
	public ResponseEntity<List<Suministra>> getAllSuministra() {
		return ResponseEntity.ok(serv.getAllSuministra());
	}

	@GetMapping("/suministra/{id}")
	public ResponseEntity<Suministra> getOneSuministra(@PathVariable(name = "id") Long id) {
		Optional<Suministra> suministra = serv.getOneSuministra(id);

		if (suministra.isPresent()) {
			return ResponseEntity.ok(suministra.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/suministra")
	public ResponseEntity<Suministra> saveSuministra(@RequestBody Suministra entity) {
		return ResponseEntity.ok( serv.createSuministra(entity));
	}
	
	@PutMapping("/suministra/{id}")
	public ResponseEntity<Suministra> updateSuministra(@PathVariable(name = "id") Long id , @RequestBody Suministra entity ){
		Optional<Suministra> suministra = serv.getOneSuministra(id);
		
		if (suministra.isPresent()) {
			entity.setId(id);
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@DeleteMapping("/suministra/{id}")
	public ResponseEntity<Void> deleteSuministra(@PathVariable(name = "id") Long id){
		Optional<Suministra> suministra = serv.getOneSuministra(id);
		if (suministra.isPresent()) {
			serv.deleteSuministra(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
