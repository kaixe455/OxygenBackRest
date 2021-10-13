package com.oxygen.backendoxygen.dao;

import java.util.List;

import com.oxygen.backendoxygen.model.Noticia;

public interface NoticiaCustomDao {

	List<Noticia> obtenerUltimasNoticias();

}
