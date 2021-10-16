package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Equipo;

public interface EquipoService {

	List<Equipo> getEquipos();

	Equipo getEquipoById(long id);

	Equipo createEquipo(Equipo equipo);

	Equipo updateEquipo(long id, Equipo equipoModificado);

	void deleteEquipo(long id);

}
