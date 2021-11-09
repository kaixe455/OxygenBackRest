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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> getNoticiasByCategoria (long idCategoria) {
		Query query = entityManager.createNativeQuery("SELECT noticias.* FROM oxygendb.noticias as noticias " +
                "where noticias.id in (select rel.id_noticia from oxygendb.rel_noticias_categorias as rel where rel.id_categoria =?1 )", Noticia.class);
		query.setParameter(1, idCategoria);
        return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> getTodasNoticias () {
		Query query = entityManager.createNativeQuery("SELECT noticias.* FROM oxygendb.noticias as noticias " +
                "ORDER BY noticias.fx_publicacion_fx desc", Noticia.class);
        return query.getResultList();
		
	}

}
