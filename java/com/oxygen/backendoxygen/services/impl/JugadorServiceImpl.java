package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.JugadorDao;
import com.oxygen.backendoxygen.model.Jugador;
import com.oxygen.backendoxygen.services.JugadorService;

@Service
public class JugadorServiceImpl implements JugadorService {


	
	private final JugadorDao jugadorDao;

	public JugadorServiceImpl(JugadorDao jugadorDao) {
		super();
		this.jugadorDao = jugadorDao;
	}
	
	@Override
	public List<Jugador> getJugadores() {
		return jugadorDao.findAll();
	}
	
	@Override
	public Jugador getJugadorById(long id) {
		return jugadorDao.findById(id).get();
	}
	
	@Override
	public Jugador createJugador(Jugador jugador) {
		return jugadorDao.save(jugador);
		
	}
	
	@Override 
	public Jugador updateJugador(long id, Jugador jugadorModificado) {
		
		Jugador jugador = jugadorDao.getById(id);
		if(jugador != null) {
			
			jugador.setNombre(jugadorModificado.getNombre());
			jugador.setApellido1(jugadorModificado.getApellido1());
			jugador.setApellido2(jugadorModificado.getApellido2());
			jugador.setFoto(jugadorModificado.getFoto());
			jugador.setJuego(jugadorModificado.getJuego());
			jugador.setNickname(jugadorModificado.getNickname());
			jugador.setRol_equipo(jugadorModificado.getRol_equipo());
			jugador.setTwitch(jugadorModificado.getTwitch());
			jugador.setTwitter(jugadorModificado.getTwitter());
		}
		
		return jugadorDao.save(jugador);
	}
	
	@Override 
	public void deleteJugador(long id) {
		
		Jugador jugador = jugadorDao.getById(id);
		
		if(jugador != null) {
			jugadorDao.delete(jugador);
		}
	}



}
