package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Noticia;

public interface NoticiaService {

	List<Noticia> getNoticias();

	Noticia getNoticiaById(long id);

	Noticia createNoticia(Noticia noticia);

	Noticia updateNoticia(long id, Noticia noticiaModificado);

	void deleteNoticia(long id);

	List<Noticia> getNoticiasHome();

	List<Noticia> getNoticiasPorCategoria(long idCategoria);

	List<Noticia> getTodasNoticias();

}
