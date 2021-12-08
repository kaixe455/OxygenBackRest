package com.oxygen.backendoxygen.dao;

import java.util.List;

import com.oxygen.backendoxygen.model.Jugador;

public interface JugadorDaoCustom {

	List<Jugador> getJugadoresByJuego(long idJuego);

}
