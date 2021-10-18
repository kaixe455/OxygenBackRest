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

import com.oxygen.backendoxygen.model.Categoria;
import com.oxygen.backendoxygen.services.CategoriaService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List <Categoria> getAllCategorias() {
		return categoriaService.getCategorias();
	}
	
	@GetMapping("categorias/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value="id") Long idCategoria) {
		
		Categoria categoria = categoriaService.getCategoriaById(idCategoria);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	@PostMapping("/crearCategoria")
	public Categoria createCategoria(@Valid @RequestBody Categoria categoria) {
		return categoriaService.createCategoria(categoria);
	}
	
	@PutMapping("/updateCategoria/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable(value = "id") Long idCategoria,
			@Valid @RequestBody Categoria detallesCategoria) {

			final Categoria categoriaActualizada = categoriaService.updateCategoria(idCategoria, detallesCategoria);
			return ResponseEntity.ok(categoriaActualizada);
	}
	
	@DeleteMapping("/borrarCategoria/{id}")
	public Map<String,Boolean> borrarCategoria(@PathVariable(value = "id") Long idCategoria) {
		
		categoriaService.deleteCategoria(idCategoria);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("borrado",Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/categoriasConNoticia")
	public List <Categoria> getCategoriasConNoticia() {
		return categoriaService.getCategoriasConNoticias();
	}

	
}
