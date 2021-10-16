package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Rol;

public interface RolService {

	List<Rol> getRoles();

	Rol getRolById(long id);

	Rol createRol(Rol rol);

	Rol updateRol(long id, Rol rolModificado);

	void deleteRol(long id);

}
