package com.oxygen.backendoxygen.model.dto;

import java.util.Date;
import java.util.Set;

import com.oxygen.backendoxygen.model.Categoria;

public class NoticiaAdminDto {

	private long id;
	private String titulo;
	private Date fx_publicacion_fx;
	private Set<Categoria> categorias;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFx_publicacion_fx() {
		return fx_publicacion_fx;
	}
	public void setFx_publicacion_fx(Date fx_publicacion_fx) {
		this.fx_publicacion_fx = fx_publicacion_fx;
	}
	public Set<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

}
