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

import com.oxygen.backendoxygen.dao.PatrocinadorDao;
import com.oxygen.backendoxygen.model.Patrocinador;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class PatrocinadorController {
	
	@Autowired
	PatrocinadorDao patrocinadorDao;
	
	@GetMapping("/patrocinadores")
	public List<Patrocinador> getAllPatrocinadores() {
		
		return patrocinadorDao.findAll();
	}
	
	@GetMapping("/patrocinadores/{id}")
	public ResponseEntity<Patrocinador> getPatrocinadorbyId (@PathVariable(value = "id") Long idPatrocinador) {
		
		Patrocinador patrocinador = patrocinadorDao.getById(idPatrocinador);
		return ResponseEntity.ok().body(patrocinador);
	}
	
	@PostMapping("/createPatrocinador")
	public Patrocinador createPatrocinador(@Valid @RequestBody Patrocinador patrocinador) {
		
		return patrocinadorDao.save(patrocinador);
	}
	
	@PutMapping("/updatePatrocinador/{id}")
	public ResponseEntity<Patrocinador> updatePatrocinador(@PathVariable(value="id") Long idPatrocinador,
			@Valid @RequestBody Patrocinador detallesPatrocinador) {
		
		Patrocinador patrocinador = patrocinadorDao.getById(idPatrocinador);
		patrocinador.setDescripcion(detallesPatrocinador.getDescripcion());
		patrocinador.setLogo(detallesPatrocinador.getLogo());
		patrocinador.setNombre(detallesPatrocinador.getNombre());
		patrocinador.setUrlEmpresa(detallesPatrocinador.getUrlEmpresa());
		
		final Patrocinador patrocinadorActualizado = patrocinadorDao.save(patrocinador);
		
		
		return ResponseEntity.ok(patrocinadorActualizado);
		
	}
	
	@DeleteMapping("borrarPatrocinador/{id}")
	public Map<String,Boolean> deletePatrocinador(@PathVariable(value="id") Long idPatrocinador) {
		
		Patrocinador patrocinador = patrocinadorDao.getById(idPatrocinador);
		patrocinadorDao.delete(patrocinador);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
