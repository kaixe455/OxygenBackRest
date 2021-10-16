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

import com.oxygen.backendoxygen.model.Patrocinador;
import com.oxygen.backendoxygen.services.PatrocinadorService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class PatrocinadorController {
	
	@Autowired
	PatrocinadorService patrocinadorService;
	
	@GetMapping("/patrocinadores")
	public List<Patrocinador> getAllPatrocinadores() {
		
		return patrocinadorService.getPatrocinadores();
	}
	
	@GetMapping("/patrocinadores/{id}")
	public ResponseEntity<Patrocinador> getPatrocinadorById (@PathVariable(value="id") Long idPatrocinador) {
		
		Patrocinador patrocinador = patrocinadorService.getPatrocinadorById(idPatrocinador);
		return ResponseEntity.ok().body(patrocinador);
		
	}
	
	@PostMapping("/crearPatrocinador")
	public Patrocinador createPatrocinador(@Valid @RequestBody Patrocinador patrocinador) {
		
		return patrocinadorService.createPatrocinador(patrocinador);
	}
	
	@PutMapping("/updatePatrocinador/{id}")
	public ResponseEntity<Patrocinador> updatePatrocinador(@PathVariable(value = "id") Long idPatrocinador,
			@Valid @RequestBody Patrocinador detallesPatrocinador) {
		
		final Patrocinador patrocinadorActualizado = patrocinadorService.updatePatrocinador(idPatrocinador, detallesPatrocinador);
		
		return ResponseEntity.ok(patrocinadorActualizado);
	}
	
	@DeleteMapping("/borrarPatrocinador/{id}")
	public Map<String, Boolean> deletePatrocinador(@PathVariable(value="id") Long idPatrocinador) {
		
		patrocinadorService.deletePatrocinador(idPatrocinador);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
