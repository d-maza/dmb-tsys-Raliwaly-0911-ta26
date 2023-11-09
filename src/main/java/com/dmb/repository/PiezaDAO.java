package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Pieza;
@Repository
public interface PiezaDAO extends JpaRepository<Pieza, Long> {

}
