package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.RolDao;
import com.oxygen.backendoxygen.model.Rol;
import com.oxygen.backendoxygen.services.RolService;

@Service
public class RolServiceImpl implements RolService {


	
	private final RolDao rolDao;

	public RolServiceImpl(RolDao rolDao) {
		super();
		this.rolDao = rolDao;
	}
	
	@Override
	public List<Rol> getRoles() {
		return rolDao.findAll();
	}
	
	@Override
	public Rol getRolById(long id) {
		return rolDao.getById(id);
	}
	
	@Override
	public Rol createRol(Rol rol) {
		return rolDao.save(rol);
		
	}
	
	@Override 
	public Rol updateRol(long id, Rol rolModificado) {
		
		Rol rol = rolDao.getById(id);
		if(rol != null) {
			
			rol.setDescripcion(rolModificado.getDescripcion());
			rol.setNombre(rolModificado.getNombre());
		}
		
		return rolDao.save(rol);
	}
	
	@Override 
	public void deleteRol(long id) {
		
		Rol rol = rolDao.getById(id);
		
		if(rol != null) {
			rolDao.delete(rol);
		}
	}



}
