package com.oxygen.backendoxygen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.oxygen.backendoxygen.dao.CategoriaDaoCustom;
import com.oxygen.backendoxygen.model.Categoria;

@Component
public class CategoriaDaoCustomImpl implements CategoriaDaoCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> getCategoriasConNoticia () {
		Query query = entityManager.createNativeQuery("SELECT categorias.* FROM oxygendb.categorias as categorias " +
                "where categorias.id in(select distinct(id_categoria) from oxygendb.rel_noticias_categorias) ", Categoria.class);

        return query.getResultList();
		
	}

}
