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

import com.oxygen.backendoxygen.model.Equipo;
import com.oxygen.backendoxygen.services.EquipoService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class EquipoController {
	
	@Autowired
	EquipoService equipoService;
	
	@GetMapping("/equipos")
	public List<Equipo> getAllEquipos() {
		
		return equipoService.getEquipos();
	}
	
	@GetMapping("/equipos/{id}")
	public ResponseEntity<Equipo> getEquipoById (@PathVariable(value="id") Long idEquipo) {
		
		Equipo equipo = equipoService.getEquipoById(idEquipo);
		return ResponseEntity.ok().body(equipo);
		
	}
	
	@PostMapping("/crearEquipo")
	public Equipo createEquipo(@Valid @RequestBody Equipo equipo) {
		
		return equipoService.createEquipo(equipo);
	}
	
	@PutMapping("/updateEquipo/{id}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable(value = "id") Long idEquipo,
			@Valid @RequestBody Equipo detallesEquipo) {
		
		final Equipo equipoActualizado = equipoService.updateEquipo(idEquipo, detallesEquipo);
		
		return ResponseEntity.ok(equipoActualizado);
	}
	
	@DeleteMapping("/borrarEquipo/{id}")
	public Map<String, Boolean> deleteEquipo(@PathVariable(value="id") Long idEquipo) {
		
		equipoService.deleteEquipo(idEquipo);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
