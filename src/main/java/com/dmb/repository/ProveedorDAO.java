package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Proveedor;
@Repository
public interface ProveedorDAO extends JpaRepository<Proveedor, String>{

}
