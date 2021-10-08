package com.oxygen.backendoxygen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patrocinadores")
public class Patrocinador {
	
	private long id;
	private String nombre;
	private String descripcion;
	private byte[] logo;
	private String urlEmpresa;

	public Patrocinador() {
		
	}
	
	public Patrocinador(String nombre, String descripcion, byte[] logo,String urlEmpresa) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.logo = logo;
		this.urlEmpresa = urlEmpresa;
		
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
	
	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "logo", nullable = false)
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	@Column(name = "url_empresa", nullable = false)
	public String getUrlEmpresa() {
		return urlEmpresa;
	}

	public void setUrlEmpresa(String urlEmpresa) {
		this.urlEmpresa = urlEmpresa;
	}

}
