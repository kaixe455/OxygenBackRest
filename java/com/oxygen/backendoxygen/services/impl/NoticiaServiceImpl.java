package com.oxygen.backendoxygen.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.NoticiaDao;
import com.oxygen.backendoxygen.dao.UsuarioDao;
import com.oxygen.backendoxygen.model.Noticia;
import com.oxygen.backendoxygen.model.Usuario;
import com.oxygen.backendoxygen.services.NoticiaService;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	
	private final NoticiaDao noticiaDao;
	private final UsuarioDao usuarioDao;


	public NoticiaServiceImpl(NoticiaDao noticiaDao, UsuarioDao usuarioDao) {
		super();
		this.noticiaDao = noticiaDao;
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public List<Noticia> getNoticias() {
		return noticiaDao.findAll();
	}
	
	@Override
	public Noticia getNoticiaById(long id) {
		return noticiaDao.findById(id).get();
	}
	
	@Override
	public Noticia createNoticia(Noticia noticia) {
		Usuario autor = usuarioDao.getById(noticia.getAutor().getId());
		noticia.setAutor(autor);
		return noticiaDao.save(noticia);
		
	}
	
	@Override 
	public Noticia updateNoticia(long id, Noticia noticiaModificado) {
		
		Noticia noticia = noticiaDao.getById(id);
		if(noticia != null) {
			noticia.setAutor(noticiaModificado.getAutor());
			noticia.setContenido(noticiaModificado.getContenido());
			noticia.setCategorias(noticiaModificado.getCategorias());
			noticia.setFx_edicion_fx(new Date());
			noticia.setFx_publicacion_fx(noticiaModificado.getFx_publicacion_fx());
			noticia.setImagen_destacada(noticiaModificado.getImagen_destacada());
			noticia.setSubtitulo(noticiaModificado.getSubtitulo());
			noticia.setTitulo(noticiaModificado.getTitulo());
		}
		
		return noticiaDao.save(noticia);
	}
	
	@Override 
	public void deleteNoticia(long id) {
		
		Noticia noticia = noticiaDao.getById(id);
		
		if(noticia != null) {
			noticiaDao.delete(noticia);
		}
	}
	
	@Override
	public List<Noticia> getNoticiasHome() {
		return noticiaDao.getUltimasNoticias();
	}
	
	@Override
	public List<Noticia> getNoticiasPorCategoria(long idCategoria) {
		return noticiaDao.getNoticiasByCategoria(idCategoria);
	}
	
	@Override
	public List<Noticia> getTodasNoticias() {
		return noticiaDao.getTodasNoticias();
	}
}
