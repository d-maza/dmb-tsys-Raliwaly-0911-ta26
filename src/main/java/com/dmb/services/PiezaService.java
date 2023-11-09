package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Pieza;
import com.dmb.repository.PiezaDAO;

@Service
public class PiezaService implements IPiezaService {
	
	@Autowired
	private PiezaDAO dao;
	
	
	@Override
	public List<Pieza> getAllPieza() {
		return dao.findAll();
	}

	@Override
	public Optional<Pieza> getOnePieza(Long id) {
		return dao.findById(id);
	}

	@Override
	public Pieza createPieza(Pieza entity) {
		return dao.save(entity);
	}

	@Override
	public Pieza updatePieza(Pieza entity) {
		return dao.save(entity);
	}

	@Override
	public void deletePieza(Long id) {
		dao.deleteById(id);
	}


	


}
