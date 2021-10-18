package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.JuegoDao;
import com.oxygen.backendoxygen.model.Juego;
import com.oxygen.backendoxygen.services.JuegoService;

@Service
public class JuegoServiceImpl implements JuegoService {


	
	private final JuegoDao juegoDao;

	public JuegoServiceImpl(JuegoDao juegoDao) {
		super();
		this.juegoDao = juegoDao;
	}
	
	@Override
	public List<Juego> getJuegos() {
		return juegoDao.findAll();
	}
	
	@Override
	public Juego getJuegoById(long id) {
		return juegoDao.findById(id).get();
	}
	
	@Override
	public Juego createJuego(Juego juego) {
		return juegoDao.save(juego);
		
	}
	
	@Override 
	public Juego updateJuego(long id, Juego juegoModificado) {
		
		Juego juego = juegoDao.getById(id);
		if(juego != null) {
			juego.setNombre(juegoModificado.getNombre());
			juego.setLogo(juegoModificado.getLogo());
		}
		
		return juegoDao.save(juego);
	}
	
	@Override 
	public void deleteJuego(long id) {
		
		Juego juego = juegoDao.getById(id);
		
		if(juego != null) {
			juegoDao.delete(juego);
		}
	}



}
