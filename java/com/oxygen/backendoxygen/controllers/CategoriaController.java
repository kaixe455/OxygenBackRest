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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.oxygen.backendoxygen.dao.CategoriaDao;
import com.oxygen.backendoxygen.model.Categoria;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class CategoriaController {
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@GetMapping("/categorias")
	public List <Categoria> getAllCategorias() {
		return categoriaDao.findAll();
	}
	
	@GetMapping("categorias/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value="id") Long idCategoria) {
		
		Categoria categoria = categoriaDao.getById(idCategoria);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	@PostMapping("/crearCategoria")
	public Categoria createCategoria(@Valid @RequestBody Categoria categoria) {
		return categoriaDao.save(categoria);
	}
	
	@PutMapping("/updateCategoria/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable(value = "id") Long idCategoria,
			@Valid @RequestBody Categoria detallesCategoria) {
		
			Categoria categoria = categoriaDao.getById(idCategoria);
			categoria.setNombre(detallesCategoria.getNombre());
			categoria.setDescripcion(detallesCategoria.getDescripcion());
			final Categoria categoriaActualizada = categoriaDao.save(categoria);
			return ResponseEntity.ok(categoriaActualizada);
	}
	
	@DeleteMapping("/borrarCategoria/{id}")
	public Map<String,Boolean> borrarCategoria(@PathVariable(value = "id") Long idCategoria) {
		Categoria categoria = categoriaDao.getById(idCategoria);
		categoriaDao.delete(categoria);
		Map<String,Boolean> response = new HashMap<>();
		response.put("borrado",Boolean.TRUE);
		return response;
	}

	
}
