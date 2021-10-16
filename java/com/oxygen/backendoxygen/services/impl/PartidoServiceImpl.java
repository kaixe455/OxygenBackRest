package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.PartidoDao;
import com.oxygen.backendoxygen.model.Partido;
import com.oxygen.backendoxygen.services.PartidoService;

@Service
public class PartidoServiceImpl implements PartidoService {


	
	private final PartidoDao partidoDao;

	public PartidoServiceImpl(PartidoDao partidoDao) {
		super();
		this.partidoDao = partidoDao;
	}
	
	@Override
	public List<Partido> getPartidos() {
		return partidoDao.findAll();
	}
	
	@Override
	public Partido getPartidoById(long id) {
		return partidoDao.getById(id);
	}
	
	@Override
	public Partido createPartido(Partido partido) {
		return partidoDao.save(partido);
		
	}
	
	@Override 
	public Partido updatePartido(long id, Partido partidoModificado) {
		
		Partido partido = partidoDao.getById(id);
		if(partido != null) {
			partido.setCheck_finalizado(partidoModificado.getCheck_finalizado());
			partido.setCompeticion(partidoModificado.getCompeticion());
			partido.setEquipoLocal(partidoModificado.getEquipoLocal());
			partido.setEquipoVisitante(partidoModificado.getEquipoVisitante());
			partido.setFx_inicio_fx(partidoModificado.getFx_inicio_fx());
			partido.setJuego(partidoModificado.getJuego());
			partido.setPuntuacionLocal(partidoModificado.getPuntuacionLocal());
			partido.setPuntuacionVisitante(partidoModificado.getPuntuacionVisitante());
		}
		
		return partidoDao.save(partido);
	}
	
	@Override 
	public void deletePartido(long id) {
		
		Partido partido = partidoDao.getById(id);
		
		if(partido != null) {
			partidoDao.delete(partido);
		}
	}



}
