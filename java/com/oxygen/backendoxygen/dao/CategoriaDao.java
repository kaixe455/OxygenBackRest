package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
