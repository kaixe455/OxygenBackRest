package com.oxygen.backendoxygen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3011448044445394116L;
	private long id;
	private String nombre;
	private byte[] logo;
	
	public Equipo() {
		
	}
	
	public Equipo(String nombre, byte[] logo) {
		this.nombre = nombre;
		this.logo = logo;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "logo", nullable = false)
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

}
