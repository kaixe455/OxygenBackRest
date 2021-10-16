package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.EquipoDao;
import com.oxygen.backendoxygen.model.Equipo;
import com.oxygen.backendoxygen.services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {


	
	private final EquipoDao equipoDao;

	public EquipoServiceImpl(EquipoDao equipoDao) {
		super();
		this.equipoDao = equipoDao;
	}
	
	@Override
	public List<Equipo> getEquipos() {
		return equipoDao.findAll();
	}
	
	@Override
	public Equipo getEquipoById(long id) {
		return equipoDao.getById(id);
	}
	
	@Override
	public Equipo createEquipo(Equipo equipo) {
		return equipoDao.save(equipo);
		
	}
	
	@Override 
	public Equipo updateEquipo(long id, Equipo equipoModificado) {
		
		Equipo equipo = equipoDao.getById(id);
		if(equipo != null) {
			equipo.setNombre(equipoModificado.getNombre());
			equipo.setLogo(equipoModificado.getLogo());
		}
		
		return equipoDao.save(equipo);
	}
	
	@Override 
	public void deleteEquipo(long id) {
		
		Equipo equipo = equipoDao.getById(id);
		
		if(equipo != null) {
			equipoDao.delete(equipo);
		}
	}



}
