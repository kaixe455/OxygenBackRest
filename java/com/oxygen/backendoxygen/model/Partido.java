package com.oxygen.backendoxygen.model;

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
@Table(name = "partidos")
public class Partido {
	
	private long id;
	private Juego juego;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Date fx_inicio_fx;
	private String competicion;
	private Boolean check_finalizado;
	private Integer puntuacionLocal;
	private Integer puntuacionVisitante;
	
	

	public Partido() {
		
	}
	
	public Partido(Juego juego, Equipo equipoLocal, Equipo equipoVisitante, Date fx_inicio_fx, String competicion,Boolean check_finalizado,Integer puntuacionLocal,Integer puntuacionVisitante) {
		
		this.juego = juego;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fx_inicio_fx = fx_inicio_fx;
		this.competicion = competicion;
		this.check_finalizado = check_finalizado;
		this.puntuacionLocal = puntuacionLocal;
		this.puntuacionVisitante = puntuacionVisitante;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "juego", referencedColumnName = "id")
	public Juego getJuego() {
		return juego;
	}
	
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_local", referencedColumnName = "id")
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "id")
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
	@Column(name = "fx_inicio_fx", nullable = false)
	public Date getFx_inicio_fx() {
		return fx_inicio_fx;
	}

	public void setFx_inicio_fx(Date fx_inicio_fx) {
		this.fx_inicio_fx = fx_inicio_fx;
	}
	
	@Column(name = "competicion", nullable = false)
	public String getCompeticion() {
		return competicion;
	}

	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}
	
	@Column(name = "check_finalizado", nullable = true)
	public Boolean getCheck_finalizado() {
		return check_finalizado;
	}

	public void setCheck_finalizado(Boolean check_finalizado) {
		this.check_finalizado = check_finalizado;
	}
	
	@Column(name = "puntuacion_local", nullable = true)
	public Integer getPuntuacionLocal() {
		return puntuacionLocal;
	}

	public void setPuntuacionLocal(Integer puntuacionLocal) {
		this.puntuacionLocal = puntuacionLocal;
	}
	
	@Column(name = "puntuacion_visitante", nullable = true)
	public Integer getPuntuacionVisitante() {
		return puntuacionVisitante;
	}

	public void setPuntuacionVisitante(Integer puntuacionVisitante) {
		this.puntuacionVisitante = puntuacionVisitante;
	}

}
