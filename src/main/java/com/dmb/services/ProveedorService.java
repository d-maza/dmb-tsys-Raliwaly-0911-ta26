package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Proveedor;
import com.dmb.repository.ProveedorDAO;

@Service
public class ProveedorService implements IProveedorService{
	
	@Autowired
	private ProveedorDAO dao;

	@Override
	public List<Proveedor> getAllProveedor() {
		return dao.findAll();
	}

	@Override
	public Optional<Proveedor> getOneProveedor(String id) {
		return dao.findById(id);
	}

	@Override
	public Proveedor createProveedor(Proveedor entity) {
		return dao.save(entity);
	}

	@Override
	public Proveedor updateProveedor(Proveedor entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteProveedor(String id) {
		dao.deleteById(id);
	}
}
