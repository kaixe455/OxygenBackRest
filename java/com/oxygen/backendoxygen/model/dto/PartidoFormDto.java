package com.oxygen.backendoxygen.model.dto;

import java.util.Date;

public class PartidoFormDto {

	private long id;
	private String juego;
	private String equipoLocal;
	private String equipoVisitante;
	private Date fx_inicio_fx;
	private String competicion;
	private Boolean check_finalizado;
	private Integer puntuacionLocal;
	private Integer puntuacionVisitante;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJuego() {
		return juego;
	}
	public void setJuego(String juego) {
		this.juego = juego;
	}
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public Date getFx_inicio_fx() {
		return fx_inicio_fx;
	}
	public void setFx_inicio_fx(Date fx_inicio_fx) {
		this.fx_inicio_fx = fx_inicio_fx;
	}
	public String getCompeticion() {
		return competicion;
	}
	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}
	public Boolean getCheck_finalizado() {
		return check_finalizado;
	}
	public void setCheck_finalizado(Boolean check_finalizado) {
		this.check_finalizado = check_finalizado;
	}
	public Integer getPuntuacionLocal() {
		return puntuacionLocal;
	}
	public void setPuntuacionLocal(Integer puntuacionLocal) {
		this.puntuacionLocal = puntuacionLocal;
	}
	public Integer getPuntuacionVisitante() {
		return puntuacionVisitante;
	}
	public void setPuntuacionVisitante(Integer puntuacionVisitante) {
		this.puntuacionVisitante = puntuacionVisitante;
	}

}
