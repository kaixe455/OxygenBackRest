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

import com.oxygen.backendoxygen.model.Jugador;
import com.oxygen.backendoxygen.services.JugadorService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class JugadorController {
	
	@Autowired
	JugadorService jugadorService;
	
	@GetMapping("/jugadores")
	public List<Jugador> getAllJugadores() {
		
		return jugadorService.getJugadores();
	}
	
	@GetMapping("/jugadores/{id}")
	public ResponseEntity<Jugador> getJugadorById (@PathVariable(value="id") Long idJugador) {
		
		Jugador jugador = jugadorService.getJugadorById(idJugador);
		return ResponseEntity.ok().body(jugador);
		
	}
	
	@PostMapping("/crearJugador")
	public Jugador createJugador(@Valid @RequestBody Jugador jugador) {
		
		return jugadorService.createJugador(jugador);
	}
	
	@PutMapping("/updateJugador/{id}")
	public ResponseEntity<Jugador> updateJugador(@PathVariable(value = "id") Long idJugador,
			@Valid @RequestBody Jugador detallesJugador) {
		
		final Jugador jugadorActualizado = jugadorService.updateJugador(idJugador, detallesJugador);
		
		return ResponseEntity.ok(jugadorActualizado);
	}
	
	@DeleteMapping("/borrarJugador/{id}")
	public Map<String, Boolean> deleteJugador(@PathVariable(value="id") Long idJugador) {
		
		jugadorService.deleteJugador(idJugador);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
