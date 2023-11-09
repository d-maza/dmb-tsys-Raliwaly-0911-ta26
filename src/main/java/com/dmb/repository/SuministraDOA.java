package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Suministra;

@Repository
public interface SuministraDOA extends JpaRepository<Suministra,Long >{

}
