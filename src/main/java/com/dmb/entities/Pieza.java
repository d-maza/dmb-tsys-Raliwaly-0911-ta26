package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "piezas")
public class Pieza {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany
	@JoinColumn(name = "id_pieza")
	private List<Suministra> suministro;


	public Pieza() {
	}

	/**
	 * @param id
	 * @param nombre
	 */
	public Pieza(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_pieza")
	public List<Suministra> getSuministra() {
		return suministro;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSuministra(List<Suministra> suministro) {
		this.suministro = suministro;
	}

}