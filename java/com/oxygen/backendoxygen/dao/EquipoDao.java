package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Equipo;

@Repository
public interface EquipoDao extends JpaRepository<Equipo, Long> {
	
}
