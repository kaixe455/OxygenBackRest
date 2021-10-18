package com.oxygen.backendoxygen.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.oxygen.backendoxygen.model.Noticia;
import com.oxygen.backendoxygen.model.dto.NoticiaHomeDto;
import com.oxygen.backendoxygen.model.dto.NoticiaSeccionDto;
import com.oxygen.backendoxygen.services.NoticiaService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class NoticiaController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping("/noticias")
	public List<Noticia> getAllNoticias() {
		
		return noticiaService.getNoticias();
	}
	
	@GetMapping("/noticias/{id}")
	public ResponseEntity<Noticia> getNoticiabyId (@PathVariable(value = "id") Long idNoticia) {
		
		Noticia noticia = noticiaService.getNoticiaById(idNoticia);
		return ResponseEntity.ok().body(noticia);
	}
	
	@PostMapping("/createNoticia")
	public Noticia createNoticia(@Valid @RequestBody Noticia noticia) {
		return noticiaService.createNoticia(noticia);
	}
	
	@PutMapping("/updateNoticia/{id}")
	public ResponseEntity<Noticia> updateNoticia(@PathVariable(value="id") Long idNoticia,
			@Valid @RequestBody Noticia detallesNoticia) {

		
		final Noticia noticiaActualizado = noticiaService.updateNoticia(idNoticia, detallesNoticia);
		
		return ResponseEntity.ok(noticiaActualizado);
		
	}
	
	@DeleteMapping("borrarNoticia/{id}")
	public Map<String,Boolean> deleteNoticia(@PathVariable(value="id") Long idNoticia) {
		
		noticiaService.deleteNoticia(idNoticia);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/noticiasHome")
	public List<NoticiaHomeDto> getAllNoticiasHome() {
		List<Noticia> noticias = noticiaService.getNoticiasHome();
		return noticias
		.stream()
		.map(noticia -> mapper.map(noticia,NoticiaHomeDto.class))
		.collect(Collectors.toList());
	}
	
	@GetMapping("/noticiasSeccion")
	public List<NoticiaSeccionDto> getAllNoticiasSeccion() {
		List<Noticia> noticias = noticiaService.getNoticiasHome();
		return noticias
		.stream()
		.map(noticia -> mapper.map(noticia,NoticiaSeccionDto.class))
		.collect(Collectors.toList());
	}
	
	@GetMapping("/noticiasporcategoria/{id}")
	public List<NoticiaSeccionDto> getNoticiabyCategoria (@PathVariable(value = "id") Long idCategoria) {
		
		
		return noticiaService.getNoticiasPorCategoria(idCategoria).stream()
				.map(noticia -> mapper.map(noticia,NoticiaSeccionDto.class))
				.collect(Collectors.toList());
	}

}
