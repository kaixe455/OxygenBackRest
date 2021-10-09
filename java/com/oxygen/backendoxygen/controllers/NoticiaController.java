package com.oxygen.backendoxygen.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oxygen.backendoxygen.dao.NoticiaDao;
import com.oxygen.backendoxygen.model.Noticia;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class NoticiaController {
	
	@Autowired
	NoticiaDao noticiaDao;
	
	@GetMapping("/noticias")
	public List<Noticia> getAllNoticias() {
		
		return noticiaDao.findAll();
	}
	
	@GetMapping("/noticias/{id}")
	public ResponseEntity<Noticia> getNoticiabyId (@PathVariable(value = "id") Long idNoticia) {
		
		Noticia noticia = noticiaDao.getById(idNoticia);
		return ResponseEntity.ok().body(noticia);
	}
	
	@PostMapping("/createNoticia")
	public Noticia createNoticia(@Valid @RequestBody Noticia noticia) {
		
		return noticiaDao.save(noticia);
	}
	
	@PutMapping("/updateNoticia/{id}")
	public ResponseEntity<Noticia> updateNoticia(@PathVariable(value="id") Long idNoticia,
			@Valid @RequestBody Noticia detallesNoticia) {
		
		Noticia noticia = noticiaDao.getById(idNoticia);
		noticia.setAutor(detallesNoticia.getAutor());
		noticia.setContenido(detallesNoticia.getContenido());
		noticia.setCategorias(detallesNoticia.getCategorias());
		noticia.setFx_edicion_fx(detallesNoticia.getFx_edicion_fx());
		noticia.setFx_publicacion_fx(detallesNoticia.getFx_publicacion_fx());
		noticia.setImagen_destacada(detallesNoticia.getImagen_destacada());
		noticia.setSubtitulo(detallesNoticia.getSubtitulo());
		noticia.setTitulo(detallesNoticia.getTitulo());
		
		final Noticia noticiaActualizado = noticiaDao.save(noticia);
		
		return ResponseEntity.ok(noticiaActualizado);
		
	}
	
	@DeleteMapping("borrarNoticia/{id}")
	public Map<String,Boolean> deleteNoticia(@PathVariable(value="id") Long idNoticia) {
		
		Noticia noticia = noticiaDao.getById(idNoticia);
		noticiaDao.delete(noticia);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
