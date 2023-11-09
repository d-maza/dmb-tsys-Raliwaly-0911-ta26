package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Suministra;

public interface ISuministaService {

	//CRUD
	public List<Suministra> getAllSuministra();
	public Optional<Suministra> getOneSuministra(Long id);
	public Suministra createSuministra(Suministra entity);
	public Suministra updateSuministra(Suministra entity);
	public void deleteSuministra(Long id);
}
