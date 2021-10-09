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

import com.oxygen.backendoxygen.dao.JugadorDao;
import com.oxygen.backendoxygen.model.Jugador;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class JugadorController {

	@Autowired
	JugadorDao jugadorDao;
	
	@GetMapping("/jugadores")
	public List<Jugador> getAlljugadores() {
		
		return jugadorDao.findAll();
	}
	
	@GetMapping("/jugadores/{id}")
	public ResponseEntity<Jugador> getjugadorbyId (@PathVariable(value = "id") Long idJugador) {
		
		Jugador jugador = jugadorDao.getById(idJugador);
		return ResponseEntity.ok().body(jugador);
	}
	
	@PostMapping("/createJugador")
	public Jugador createJugador(@Valid @RequestBody Jugador jugador) {
		
		return jugadorDao.save(jugador);
	}
	
	@PutMapping("/updateJugador/{id}")
	public ResponseEntity<Jugador> updateJugador(@PathVariable(value="id") Long idJugador,
			@Valid @RequestBody Jugador detallesJugador) {
		Jugador jugador = jugadorDao.getById(idJugador);
		
		jugador.setNombre(detallesJugador.getNombre());
		jugador.setApellido1(detallesJugador.getApellido1());
		jugador.setApellido2(detallesJugador.getApellido2());
		jugador.setFoto(detallesJugador.getFoto());
		jugador.setJuego(detallesJugador.getJuego());
		jugador.setNickname(detallesJugador.getNickname());
		jugador.setRol_equipo(detallesJugador.getRol_equipo());
		jugador.setTwitch(detallesJugador.getTwitch());
		jugador.setTwitter(detallesJugador.getTwitter());
		
		final Jugador jugadorActualizado = jugadorDao.save(jugador);
		
		return ResponseEntity.ok(jugadorActualizado);
		
	}
	
	@DeleteMapping("borrarJugador/{id}")
	public Map<String,Boolean> deleteJugador(@PathVariable(value="id") Long idJugador) {
		
		Jugador jugador = jugadorDao.getById(idJugador);
		jugadorDao.delete(jugador);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
