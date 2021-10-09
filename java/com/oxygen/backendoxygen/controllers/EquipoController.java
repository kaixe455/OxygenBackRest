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

import com.oxygen.backendoxygen.dao.EquipoDao;
import com.oxygen.backendoxygen.model.Equipo;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class EquipoController {
	
	@Autowired
	EquipoDao equipoDao;
	
	@GetMapping("/equipos")
	public List<Equipo> getAllEquipos() {
		
		return equipoDao.findAll();
	}
	
	@GetMapping("/equipos/{id}")
	public ResponseEntity<Equipo> getEquipoById (@PathVariable(value="id") Long idEquipo) {
		
		Equipo equipo = equipoDao.getById(idEquipo);
		return ResponseEntity.ok().body(equipo);
		
	}
	
	@PostMapping("/crearEquipo")
	public Equipo createEquipo(@Valid @RequestBody Equipo equipo) {
		
		return equipoDao.save(equipo);
	}
	
	@PutMapping("/updateEquipo/{id}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable(value = "id") Long idEquipo,
			@Valid @RequestBody Equipo detallesEquipo) {
		Equipo equipo = equipoDao.getById(idEquipo);
		
		equipo.setNombre(detallesEquipo.getNombre());
		equipo.setLogo(detallesEquipo.getLogo());
		
		final Equipo equipoActualizado = equipoDao.save(equipo);
		
		return ResponseEntity.ok(equipoActualizado);
	}
	
	@DeleteMapping("/borrarEquipo/{id}")
	public Map<String, Boolean> deleteEquipo(@PathVariable(value="id") Long idEquipo) {
		
		Equipo equipo = equipoDao.getById(idEquipo);
		equipoDao.delete(equipo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
