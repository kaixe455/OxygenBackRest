package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.PatrocinadorDao;
import com.oxygen.backendoxygen.model.Patrocinador;
import com.oxygen.backendoxygen.services.PatrocinadorService;

@Service
public class PatrocinadorServiceImpl implements PatrocinadorService {


	
	private final PatrocinadorDao patrocinadorDao;

	public PatrocinadorServiceImpl(PatrocinadorDao patrocinadorDao) {
		super();
		this.patrocinadorDao = patrocinadorDao;
	}
	
	@Override
	public List<Patrocinador> getPatrocinadores() {
		return patrocinadorDao.findAll();
	}
	
	@Override
	public Patrocinador getPatrocinadorById(long id) {
		return patrocinadorDao.findById(id).get();
	}
	
	@Override
	public Patrocinador createPatrocinador(Patrocinador patrocinador) {
		return patrocinadorDao.save(patrocinador);
		
	}
	
	@Override 
	public Patrocinador updatePatrocinador(long id, Patrocinador patrocinadorModificado) {
		
		Patrocinador patrocinador = patrocinadorDao.getById(id);
		if(patrocinador != null) {
			
			patrocinador.setDescripcion(patrocinadorModificado.getDescripcion());
			patrocinador.setLogo(patrocinadorModificado.getLogo());
			patrocinador.setNombre(patrocinadorModificado.getNombre());
			patrocinador.setUrlEmpresa(patrocinadorModificado.getUrlEmpresa());
		}
		
		return patrocinadorDao.save(patrocinador);
	}
	
	@Override 
	public void deletePatrocinador(long id) {
		
		Patrocinador patrocinador = patrocinadorDao.getById(id);
		
		if(patrocinador != null) {
			patrocinadorDao.delete(patrocinador);
		}
	}



}
