package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Juego;

public interface JuegoService {

	List<Juego> getJuegos();

	Juego getJuegoById(long id);

	Juego createJuego(Juego juego);

	Juego updateJuego(long id, Juego juegoModificado);

	void deleteJuego(long id);

}
