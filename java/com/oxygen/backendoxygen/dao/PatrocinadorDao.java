package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Patrocinador;

@Repository
public interface PatrocinadorDao extends JpaRepository<Patrocinador, Long> {

}
