package com.oxygen.backendoxygen.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oxygen.backendoxygen.dao.UsuarioDaoCustom;
import com.oxygen.backendoxygen.model.Usuario;

public class UsuarioDaoCustomImpl implements UsuarioDaoCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Usuario getUsuarioByEmail (String email) {
		Query query = entityManager.createNativeQuery("SELECT usuarios.* FROM oxygendb.usuarios as usuarios " +
                "WHERE usuarios.correo_electronico =?1", Usuario.class);
		query.setParameter(1, email);
        return (Usuario) query.getSingleResult();
		
	}


}
