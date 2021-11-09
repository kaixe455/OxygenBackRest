package com.oxygen.backendoxygen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -2659945906021296916L;
	private long id;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String correoElectronico;
	private String nickname;
	private String password;
	private Date fx_creacion_fx;
	private String twitter;
	private String twitch;
	private Rol rol;

	public Usuario() {
		
	}
	
	public Usuario(String nombre,String primer_apellido,String segundo_apellido,String correoElectronico,String nickname,String password, Date fx_creacion_fx,String twitter,String twitch,Rol rol) {
		
		this.nombre = nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.correoElectronico = correoElectronico;
		this.nickname = nickname;
		this.password = password;
		this.fx_creacion_fx = fx_creacion_fx;
		this.twitter = twitter;
		this.twitch = twitch;
		this.rol = rol;
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
	
	@Column(name = "primer_apellido", nullable = false)
	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	
	@Column(name = "segundo_apellido", nullable = false)
	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	
	@Column(name = "correo_electronico", nullable = false)
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	@Column(name = "nickname", nullable = false)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "fx_creacion_fx", nullable = false)
	public Date getFx_creacion_fx() {
		return fx_creacion_fx;
	}

	public void setFx_creacion_fx(Date fx_creacion_fx) {
		this.fx_creacion_fx = fx_creacion_fx;
	}
	
	@Column(name = "twitter", nullable = false)
	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
	@Column(name = "twitch", nullable = false)
	public String getTwitch() {
		return twitch;
	}

	public void setTwitch(String twitch) {
		this.twitch = twitch;
	}
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rol", referencedColumnName = "id")
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
