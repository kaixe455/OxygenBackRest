package com.oxygen.backendoxygen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.backendoxygen.model.Noticia;

@Repository
public interface NoticiaDao extends JpaRepository<Noticia, Long>, NoticiaCustomDao {

}
