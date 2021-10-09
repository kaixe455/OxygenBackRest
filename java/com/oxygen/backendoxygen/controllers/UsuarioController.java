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

import com.oxygen.backendoxygen.dao.UsuarioDao;
import com.oxygen.backendoxygen.model.Usuario;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class UsuarioController {

	@Autowired
	UsuarioDao usuarioDao;
	
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		
		return usuarioDao.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuariobyId (@PathVariable(value = "id") Long idUsuario) {
		
		Usuario usuario = usuarioDao.getById(idUsuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping("/createUsuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		
		return usuarioDao.save(usuario);
	}
	
	@PutMapping("/updateUsuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value="id") Long idUsuario,
			@Valid @RequestBody Usuario detallesUsuario) {
		
		Usuario usuario = usuarioDao.getById(idUsuario);
		usuario.setCorreoElectronico(detallesUsuario.getCorreoElectronico());
		usuario.setFx_creacion_fx(detallesUsuario.getFx_creacion_fx());
		usuario.setNickname(detallesUsuario.getNickname());
		usuario.setNombre(detallesUsuario.getNombre());
		usuario.setPassword(detallesUsuario.getPassword());
		usuario.setPrimer_apellido(detallesUsuario.getPrimer_apellido());
		usuario.setRol(detallesUsuario.getRol());
		usuario.setSegundo_apellido(detallesUsuario.getSegundo_apellido());
		usuario.setTwitch(detallesUsuario.getTwitch());
		usuario.setTwitter(detallesUsuario.getTwitter());
		
		final Usuario usuarioActualizado = usuarioDao.save(usuario);
		
		
		return ResponseEntity.ok(usuarioActualizado);
		
	}
	
	@DeleteMapping("borrarUsuario/{id}")
	public Map<String,Boolean> deleteUsuario(@PathVariable(value="id") Long idUsuario) {
		
		Usuario usuario = usuarioDao.getById(idUsuario);
		usuarioDao.delete(usuario);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}

}
