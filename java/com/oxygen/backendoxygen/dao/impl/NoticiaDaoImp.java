package com.oxygen.backendoxygen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.dao.NoticiaCustomDao;
import com.oxygen.backendoxygen.model.Noticia;

@Repository
public abstract class NoticiaDaoImp implements NoticiaCustomDao {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> obtenerUltimasNoticias () {
		Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.employee as em " +
                "WHERE em.firstname LIKE ?", Noticia.class);
        query.setParameter(1, "parametro");

        return query.getResultList();
		
	}

}
