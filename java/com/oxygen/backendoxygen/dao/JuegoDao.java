package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Juego;

@Repository
public interface JuegoDao extends JpaRepository<Juego, Long> {

}
