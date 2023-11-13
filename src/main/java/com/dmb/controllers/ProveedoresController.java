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
public class ProveedoresController {
	
	@Autowired
	private ProveedorService serv;
	
	@GetMapping("/proveedors")
	public List<Proveedor> getAllProveedor() {
		return serv.getAllProveedor();
	}

	@GetMapping("/proveedor/{id}")
	public Proveedor getOneProveedor(@PathVariable(name = "id")String id) {
		return serv.getOneProveedor(id).get();
	}
	
	@PostMapping("/proveedor")
	public Proveedor saveProveedor(@RequestBody Proveedor entity) {
		return serv.createProveedor(entity);
	}
	
	@PutMapping("/proveedor/{id}")
	public Proveedor updateProveedor(@PathVariable(name = "id") String id , @RequestBody Proveedor entity ){
		 Proveedor proveedorOLD = serv.getOneProveedor(id).get();
		 proveedorOLD.setNombre(entity.getNombre());
		 proveedorOLD.setSuministra(entity.getSuministra());
		 return proveedorOLD;
	}
	

	@DeleteMapping("/proveedor/{id}")
	public void deleteProveedor(@PathVariable(name = "id") String id){
		serv.deleteProveedor(id);
	}

}
