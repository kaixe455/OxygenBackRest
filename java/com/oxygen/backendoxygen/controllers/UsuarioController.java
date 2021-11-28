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

import com.oxygen.backendoxygen.model.Usuario;
import com.oxygen.backendoxygen.model.dto.LoginFormDto;
import com.oxygen.backendoxygen.services.UsuarioService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById (@PathVariable(value="id") Long idUsuario) {
		
		Usuario usuario = usuarioService.getUsuarioById(idUsuario);
		return ResponseEntity.ok().body(usuario);
		
	}
	
	@PostMapping("/crearUsuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		
		return usuarioService.createUsuario(usuario);
	}
	
	@PutMapping("/updateUsuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long idUsuario,
			@Valid @RequestBody Usuario detallesUsuario) {
		
		final Usuario usuarioActualizado = usuarioService.updateUsuario(idUsuario, detallesUsuario);
		
		return ResponseEntity.ok(usuarioActualizado);
	}
	
	@DeleteMapping("/borrarUsuario/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value="id") Long idUsuario) {
		
		usuarioService.deleteUsuario(idUsuario);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/login")
	public Usuario loginUsuario(@Valid @RequestBody LoginFormDto login) {
		
		return usuarioService.loginUsuario(login);
	}

}
