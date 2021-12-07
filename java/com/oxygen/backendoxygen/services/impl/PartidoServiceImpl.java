package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.PartidoDao;
import com.oxygen.backendoxygen.model.Equipo;
import com.oxygen.backendoxygen.model.Juego;
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
	public List<Partido> getPartidosAdmin() {
		
		List<Partido> partidosAdmin = partidoDao.findAll();
		for (Partido partido : partidosAdmin) {
			Juego juego = partido.getJuego();
			juego.setLogo(null);
			Equipo local = partido.getEquipoLocal();
			local.setLogo(null);
			Equipo visitante = partido.getEquipoVisitante();
			visitante.setLogo(null);
			partido.setJuego(juego);
			partido.setEquipoLocal(local);
			partido.setEquipoVisitante(visitante);
		}
		return partidosAdmin;
	}
	
	@Override
	public Partido getPartidoById(long id) {
		return partidoDao.findById(id).get();
	}
	
	@Override
	public Partido createPartido(Partido partido) {
		return partidoDao.save(partido);
		
	}
	
	@Override 
	public Partido updatePartido(long id, Partido partidoModificado) {
		
		Partido partido = partidoDao.getById(id);
		if(partido != null) {
			
			// si viene informado alguna puntuación pongo finalizado a true
			
			if(partidoModificado.getPuntuacionLocal() != null || partidoModificado.getPuntuacionVisitante() != null) {
				partido.setCheck_finalizado(true);
			}else {
				partido.setCheck_finalizado(partidoModificado.getCheck_finalizado());
			}
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
	
	@Override
	public Partido getReiniciarPartido(long id) {
		
		Partido partido = partidoDao.getById(id);
		partido.setPuntuacionLocal(null);
		partido.setPuntuacionVisitante(null);
		partido.setCheck_finalizado(false);
		partidoDao.save(partido);
		return partido;
	}
	
	@Override
	public Partido getProximoPartido() {
		try {
			return partidoDao.getProximoPartido().get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Partido> getUltimosResultados() {
		return partidoDao.getUltimosResultados();
	}



}
