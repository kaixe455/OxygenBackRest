package com.oxygen.backendoxygen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oxygen.backendoxygen.dao.PartidoDaoCustom;
import com.oxygen.backendoxygen.model.Partido;

public class PartidoDaoCustomImpl implements PartidoDaoCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Partido> getProximoPartido () {
		
		Query query = entityManager.createNativeQuery("SELECT partidos.* FROM oxygendb.partidos as partidos " +
                "WHERE partidos.check_finalizado = 0 " +
				"AND partidos.fx_inicio_fx >= CURDATE() " +
				"ORDER BY partidos.fx_inicio_fx asc", Partido.class);
        return query.getResultList();
		
	}
}
