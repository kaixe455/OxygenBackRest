package com.oxygen.backendoxygen.dao;

import java.util.List;

import com.oxygen.backendoxygen.model.Partido;

public interface PartidoDaoCustom {

	List<Partido> getProximoPartido();

	List<Partido> getUltimosResultados();

}
