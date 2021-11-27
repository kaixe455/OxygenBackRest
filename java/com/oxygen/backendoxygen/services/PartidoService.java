package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Partido;

public interface PartidoService {

	List<Partido> getPartidos();

	Partido getPartidoById(long id);

	Partido createPartido(Partido partido);

	Partido updatePartido(long id, Partido partidoModificado);

	void deletePartido(long id);

	List<Partido> getPartidosAdmin();

	Partido getReiniciarPartido(long id);

}
