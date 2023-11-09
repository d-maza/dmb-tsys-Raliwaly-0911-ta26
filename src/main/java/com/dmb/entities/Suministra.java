package com.dmb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "suminista")
public class Suministra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_pieza")
	private Pieza pieza;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;

	@Column(name = "precio")
	private int precio;

	public Suministra() {
	}

	/**
	 * @param id
	 * @param pieza
	 * @param proveedor
	 * @param precio
	 */
	public Suministra(Long id, Pieza pieza, Proveedor proveedor, int precio) {
		this.id = id;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
