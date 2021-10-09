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

import com.oxygen.backendoxygen.dao.JuegoDao;
import com.oxygen.backendoxygen.model.Juego;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class JuegoController {
	
	@Autowired
	JuegoDao juegoDao;
	
	@GetMapping("/juegos")
	public List<Juego> getAllJuegos() {
		
		return juegoDao.findAll();
	}
	
	@GetMapping("/juegos/{id}")
	public ResponseEntity<Juego> getJuegobyId (@PathVariable(value = "id") Long idJuego) {
		
		Juego juego = juegoDao.getById(idJuego);
		return ResponseEntity.ok().body(juego);
	}
	
	@PostMapping("/createJuego")
	public Juego createJuego(@Valid @RequestBody Juego juego) {
		
		return juegoDao.save(juego);
	}
	
	@PutMapping("/updateJuego/{id}")
	public ResponseEntity<Juego> updateJuego(@PathVariable(value="id") Long idJuego,
			@Valid @RequestBody Juego detallesJuego) {
		Juego juego = juegoDao.getById(idJuego);
		
		juego.setNombre(detallesJuego.getNombre());
		juego.setLogo(detallesJuego.getLogo());
		
		final Juego juegoActualizado = juegoDao.save(juego);
		
		return ResponseEntity.ok(juegoActualizado);
		
	}
	
	@DeleteMapping("borrarJuego/{id}")
	public Map<String,Boolean> deleteJuego(@PathVariable(value="id") Long idJuego) {
		
		Juego juego = juegoDao.getById(idJuego);
		juegoDao.delete(juego);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}
	

}
