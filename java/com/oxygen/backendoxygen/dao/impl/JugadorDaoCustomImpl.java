package com.oxygen.backendoxygen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oxygen.backendoxygen.dao.JugadorDaoCustom;
import com.oxygen.backendoxygen.model.Jugador;

public class JugadorDaoCustomImpl implements JugadorDaoCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Jugador> getJugadoresByJuego (long idJuego) {
		Query query = entityManager.createNativeQuery("SELECT jugadores.* FROM oxygendb.jugadores as jugadores " +
                "where jugadores.juego = ?1 ", Jugador.class);
		query.setParameter(1, idJuego);

        return query.getResultList();
		
	}


}
