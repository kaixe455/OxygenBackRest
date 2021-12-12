package com.oxygen.backendoxygen.model.dto;

import com.oxygen.backendoxygen.model.Juego;

public class JugadorFormDto {

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
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getTwitch() {
		return twitch;
	}
	public void setTwitch(String twitch) {
		this.twitch = twitch;
	}
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getRol_equipo() {
		return rol_equipo;
	}
	public void setRol_equipo(String rol_equipo) {
		this.rol_equipo = rol_equipo;
	}

}
