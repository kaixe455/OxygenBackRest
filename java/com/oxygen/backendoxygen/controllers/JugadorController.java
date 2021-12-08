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

import com.oxygen.backendoxygen.model.Juego;
import com.oxygen.backendoxygen.model.Jugador;
import com.oxygen.backendoxygen.model.dto.JugadorFormDto;
import com.oxygen.backendoxygen.services.JuegoService;
import com.oxygen.backendoxygen.services.JugadorService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class JugadorController {
	
	@Autowired
	JugadorService jugadorService;
	
	@Autowired
	JuegoService juegoService;
	
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
	public Jugador createJugador(@Valid @RequestBody JugadorFormDto jugador) {
		Juego juego = juegoService.getJuegoById(jugador.getJuego());
		
		Jugador jugadorInsertar = new Jugador();
		jugadorInsertar.setApellido1(jugador.getApellido1());
		jugadorInsertar.setApellido2(jugador.getApellido2());
		jugadorInsertar.setFoto(jugador.getFoto());
		jugadorInsertar.setJuego(juego);
		jugadorInsertar.setNickname(jugador.getNickname());
		jugadorInsertar.setNombre(jugador.getNombre());
		jugadorInsertar.setRol_equipo(jugador.getRol_equipo());
		jugadorInsertar.setTwitch(jugador.getTwitch());
		jugadorInsertar.setTwitter(jugador.getTwitter());
		
		
		return jugadorService.createJugador(jugadorInsertar);
	}
	
	@PutMapping("/updateJugador/{id}")
	public ResponseEntity<Jugador> updateJugador(@PathVariable(value = "id") Long idJugador,
			@Valid @RequestBody JugadorFormDto detallesJugador) {
		
		Juego juego = juegoService.getJuegoById(detallesJugador.getJuego());
		
		Jugador jugadorInsertar = new Jugador();
		jugadorInsertar.setApellido1(detallesJugador.getApellido1());
		jugadorInsertar.setApellido2(detallesJugador.getApellido2());
		jugadorInsertar.setFoto(detallesJugador.getFoto());
		jugadorInsertar.setJuego(juego);
		jugadorInsertar.setNickname(detallesJugador.getNickname());
		jugadorInsertar.setNombre(detallesJugador.getNombre());
		jugadorInsertar.setRol_equipo(detallesJugador.getRol_equipo());
		jugadorInsertar.setTwitch(detallesJugador.getTwitch());
		jugadorInsertar.setTwitter(detallesJugador.getTwitter());
		
		final Jugador jugadorActualizado = jugadorService.updateJugador(idJugador, jugadorInsertar);
		
		return ResponseEntity.ok(jugadorActualizado);
	}
	
	@DeleteMapping("/borrarJugador/{id}")
	public Map<String, Boolean> deleteJugador(@PathVariable(value="id") Long idJugador) {
		
		jugadorService.deleteJugador(idJugador);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/jugadoresbyjuego/{idjuego}")
	public List<Jugador> getJugadoresByJuego(@PathVariable(value="idjuego") Long idJuego) {
		
		return jugadorService.getJugadoresByJuego(idJuego);
	}

}
