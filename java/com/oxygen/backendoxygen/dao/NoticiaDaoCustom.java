package com.oxygen.backendoxygen.dao;

import java.util.List;

import com.oxygen.backendoxygen.model.Noticia;


public interface NoticiaDaoCustom {

	List<Noticia> getUltimasNoticias();

	List<Noticia> getNoticiasByCategoria(long idCategoria);

}
