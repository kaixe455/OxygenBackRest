package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Jugador;

@Repository
public interface JugadorDao extends JpaRepository<Jugador, Long> {

}
