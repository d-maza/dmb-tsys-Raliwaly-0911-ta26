package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Pieza;

public interface IPiezaService {
	
	//CRUD 

	//Read All
	public List<Pieza> getAllPieza();

	//Read One
	public Optional<Pieza> getOnePieza(Long id); 
	//Create

	public Pieza createPieza(Pieza entity);

	//Update
	public Pieza updatePieza(Pieza entity);

	//Delete
	public void deletePieza(Long id); 
}
