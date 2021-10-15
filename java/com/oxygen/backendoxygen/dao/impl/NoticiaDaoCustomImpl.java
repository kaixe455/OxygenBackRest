package com.oxygen.backendoxygen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.oxygen.backendoxygen.dao.NoticiaDaoCustom;
import com.oxygen.backendoxygen.model.Noticia;

@Component
public class NoticiaDaoCustomImpl implements NoticiaDaoCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> getUltimasNoticias () {
		Query query = entityManager.createNativeQuery("SELECT noticias.* FROM oxygendb.noticias as noticias " +
                "ORDER BY noticias.fx_publicacion_fx desc LIMIT 3", Noticia.class);

        return query.getResultList();
		
	}

}
