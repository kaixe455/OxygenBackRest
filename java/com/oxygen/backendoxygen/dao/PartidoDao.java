package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Partido;

@Repository
public interface PartidoDao extends JpaRepository<Partido, Long>, PartidoDaoCustom {

}
