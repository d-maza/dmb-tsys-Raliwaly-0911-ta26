package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Proveedor;

public interface IProveedorService {

	//CRUD
	public List<Proveedor> getAllProveedor();
	public Optional<Proveedor> getOneProveedor(String id);
	public Proveedor createProveedor(Proveedor entity);
	public Proveedor updateProveedor(Proveedor entity);
	public void deleteProveedor(String id);
}
