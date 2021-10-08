package com.oxygen.backendoxygen.model;

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
@Table(name = "jugadores")
public class Jugador {

	private long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nickname;
	private String twitter;
	private String twitch;
	private Juego juego;
	private byte[] foto;
	private String rol_equipo;
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre, String apellido1, String apellido2, String nickname
			,String twitter, String twitch, 
			Juego juego, byte[] foto,String rol_equipo) {
		
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nickname = nickname;
		this.twitter = twitter;
		this.twitch = twitch;
		this.juego = juego;
		this.foto = foto;
		this.rol_equipo = rol_equipo;
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
	
	@Column(name = "apellido_1", nullable = false)
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	@Column(name = "apellido_2", nullable = false)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	@Column(name = "nickname", nullable = false)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "juego", referencedColumnName = "id")
	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	@Column(name = "foto", nullable = false)
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Column(name = "rol_equipo", nullable = false)
	public String getRol_equipo() {
		return rol_equipo;
	}

	public void setRol_equipo(String rol_equipo) {
		this.rol_equipo = rol_equipo;
	}

}
