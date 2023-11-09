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

import com.dmb.entities.Proveedor;
import com.dmb.services.ProveedorService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin (origins = "*")
public class ProveedoresController {
	
	@Autowired
	private ProveedorService serv;
	
	@GetMapping("/proveedors")
	public ResponseEntity<List<Proveedor>> getAllProveedor() {
		return ResponseEntity.ok(serv.getAllProveedor());
	}

	@GetMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> getOneProveedor(@PathVariable(name = "id")String id) {
		Optional<Proveedor> proveedor = serv.getOneProveedor(id);

		if (proveedor.isPresent()) {
			return ResponseEntity.ok( proveedor.get());
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/proveedor")
	public ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor entity) {
		return ResponseEntity.ok( serv.createProveedor(entity));
	}
	
	@PutMapping("/proveedor/{id}")
	public ResponseEntity<Proveedor> updateProveedor(@PathVariable(name = "id") String id , @RequestBody Proveedor entity ){
		Optional<Proveedor> proveedor = serv.getOneProveedor(id);
		
		if (proveedor.isPresent()) {
			entity.setId(id);
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<Void> deleteProveedor(@PathVariable(name = "id") String id){
		Optional<Proveedor> proveedor = serv.getOneProveedor(id);
		if (proveedor.isPresent()) {
			serv.deleteProveedor(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
