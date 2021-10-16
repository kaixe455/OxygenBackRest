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

import com.oxygen.backendoxygen.model.Rol;
import com.oxygen.backendoxygen.services.RolService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class RolController {
	
	@Autowired
	RolService rolService;
	
	@GetMapping("/roles")
	public List<Rol> getAllRoles() {
		
		return rolService.getRoles();
	}
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<Rol> getRolById (@PathVariable(value="id") Long idRol) {
		
		Rol rol = rolService.getRolById(idRol);
		return ResponseEntity.ok().body(rol);
		
	}
	
	@PostMapping("/crearRol")
	public Rol createRol(@Valid @RequestBody Rol rol) {
		
		return rolService.createRol(rol);
	}
	
	@PutMapping("/updateRol/{id}")
	public ResponseEntity<Rol> updateRol(@PathVariable(value = "id") Long idRol,
			@Valid @RequestBody Rol detallesRol) {
		
		final Rol rolActualizado = rolService.updateRol(idRol, detallesRol);
		
		return ResponseEntity.ok(rolActualizado);
	}
	
	@DeleteMapping("/borrarRol/{id}")
	public Map<String, Boolean> deleteRol(@PathVariable(value="id") Long idRol) {
		
		rolService.deleteRol(idRol);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
