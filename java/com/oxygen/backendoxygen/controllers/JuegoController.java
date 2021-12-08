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

import com.oxygen.backendoxygen.model.Juego;
import com.oxygen.backendoxygen.model.dto.JuegosFooterDto;
import com.oxygen.backendoxygen.services.JuegoService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class JuegoController {
	
	@Autowired
	JuegoService juegoService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/juegos")
	public List<Juego> getAllJuegos() {
		
		return juegoService.getJuegos();
	}
	
	@GetMapping("/juegos/{id}")
	public ResponseEntity<Juego> getJuegoById (@PathVariable(value="id") Long idJuego) {
		
		Juego juego = juegoService.getJuegoById(idJuego);
		return ResponseEntity.ok().body(juego);
		
	}
	
	@PostMapping("/crearJuego")
	public Juego createJuego(@Valid @RequestBody Juego juego) {
		
		return juegoService.createJuego(juego);
	}
	
	@PutMapping("/updateJuego/{id}")
	public ResponseEntity<Juego> updateJuego(@PathVariable(value = "id") Long idJuego,
			@Valid @RequestBody Juego detallesJuego) {
		
		final Juego juegoActualizado = juegoService.updateJuego(idJuego, detallesJuego);
		
		return ResponseEntity.ok(juegoActualizado);
	}
	
	@DeleteMapping("/borrarJuego/{id}")
	public Map<String, Boolean> deleteJuego(@PathVariable(value="id") Long idJuego) {
		
		juegoService.deleteJuego(idJuego);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/juegosFooter")
	public List<JuegosFooterDto> getJuegosFooter() {
		
		List<Juego> juegos =  juegoService.getJuegos();
		return juegos
				.stream()
				.map(juego -> mapper.map(juego,JuegosFooterDto.class))
				.collect(Collectors.toList());
	}

}
