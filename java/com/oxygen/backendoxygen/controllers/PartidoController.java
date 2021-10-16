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

import com.oxygen.backendoxygen.model.Partido;
import com.oxygen.backendoxygen.services.PartidoService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class PartidoController {
	
	@Autowired
	PartidoService partidoService;
	
	@GetMapping("/partidos")
	public List<Partido> getAllPartidos() {
		
		return partidoService.getPartidos();
	}
	
	@GetMapping("/partidos/{id}")
	public ResponseEntity<Partido> getPartidoById (@PathVariable(value="id") Long idPartido) {
		
		Partido partido = partidoService.getPartidoById(idPartido);
		return ResponseEntity.ok().body(partido);
		
	}
	
	@PostMapping("/crearPartido")
	public Partido createPartido(@Valid @RequestBody Partido partido) {
		
		return partidoService.createPartido(partido);
	}
	
	@PutMapping("/updatePartido/{id}")
	public ResponseEntity<Partido> updatePartido(@PathVariable(value = "id") Long idPartido,
			@Valid @RequestBody Partido detallesPartido) {
		
		final Partido partidoActualizado = partidoService.updatePartido(idPartido, detallesPartido);
		
		return ResponseEntity.ok(partidoActualizado);
	}
	
	@DeleteMapping("/borrarPartido/{id}")
	public Map<String, Boolean> deletePartido(@PathVariable(value="id") Long idPartido) {
		
		partidoService.deletePartido(idPartido);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
