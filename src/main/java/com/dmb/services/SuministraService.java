package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Suministra;
import com.dmb.repository.SuministraDOA;

@Service
public class SuministraService implements ISuministaService{
	
	@Autowired
	private SuministraDOA dao;

	@Override
	public List<Suministra> getAllSuministra() {

		return dao.findAll();
	}

	@Override
	public Optional<Suministra> getOneSuministra(Long id) {
		return dao.findById(id);
	}

	@Override
	public Suministra createSuministra(Suministra entity) {
		return dao.save(entity);
	}

	@Override
	public Suministra updateSuministra(Suministra entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteSuministra(Long id) {
		dao.deleteById(id);
		
	}


}
