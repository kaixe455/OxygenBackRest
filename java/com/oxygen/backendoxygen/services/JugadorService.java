package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Jugador;

public interface JugadorService {

	List<Jugador> getJugadores();

	Jugador getJugadorById(long id);

	Jugador createJugador(Jugador jugador);

	Jugador updateJugador(long id, Jugador jugadorModificado);

	void deleteJugador(long id);

}
