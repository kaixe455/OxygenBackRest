package com.oxygen.backendoxygen.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "noticias")
public class Noticia {
	
	private long id;
	private String titulo;
	private String subtitulo;
	private String contenido;
	private byte[] imagen_destacada;
	private Usuario autor;
	private Date fx_publicacion_fx;
	private Date fx_edicion_fx;
	private Set<Categoria> categorias;

	public Noticia() {
	
	}
	
	public Noticia(String titulo,String subtitulo,String contenido,Usuario autor, Date fx_publicacion_fx,Date fx_edicion_fx,Set<Categoria> categorias) {
		
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.contenido = contenido;
		this.autor = autor;
		this.fx_publicacion_fx = fx_publicacion_fx;
		this.fx_edicion_fx = fx_edicion_fx;
		this.categorias = categorias;
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name = "subtitulo", nullable = false)
	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	
	@Column(name = "contenido", nullable = false)
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	@Column(name = "imagen_destacada", nullable = false)
	public byte[] getImagen_destacada() {
		return imagen_destacada;
	}

	public void setImagen_destacada(byte[] imagen_destacada) {
		this.imagen_destacada = imagen_destacada;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor", referencedColumnName = "id")
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	@Column(name = "fx_publicacion_fx", nullable = false)
	public Date getFx_publicacion_fx() {
		return fx_publicacion_fx;
	}

	public void setFx_publicacion_fx(Date fx_publicacion_fx) {
		this.fx_publicacion_fx = fx_publicacion_fx;
	}
	
	@Column(name = "fx_edicion_fx", nullable = false)
	public Date getFx_edicion_fx() {
		return fx_edicion_fx;
	}

	public void setFx_edicion_fx(Date fx_edicion_fx) {
		this.fx_edicion_fx = fx_edicion_fx;
	}
	
	@ManyToMany
	@JoinTable(name = "rel_noticias_categorias", joinColumns = @JoinColumn(name = "id_noticia"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	@JsonManagedReference
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

}
