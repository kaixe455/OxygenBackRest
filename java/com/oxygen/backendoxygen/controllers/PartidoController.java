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

import com.oxygen.backendoxygen.dao.PartidoDao;
import com.oxygen.backendoxygen.model.Partido;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class PartidoController {
	
	@Autowired
	PartidoDao partidoDao;
	
	@GetMapping("/partidos")
	public List<Partido> getAllPartidos() {
		
		return partidoDao.findAll();
	}
	
	@GetMapping("/partidos/{id}")
	public ResponseEntity<Partido> getPartidobyId (@PathVariable(value = "id") Long idPartido) {
		
		Partido partido = partidoDao.getById(idPartido);
		return ResponseEntity.ok().body(partido);
	}
	
	@PostMapping("/createPartido")
	public Partido createPartido(@Valid @RequestBody Partido partido) {
		
		return partidoDao.save(partido);
	}
	
	@PutMapping("/updatePartido/{id}")
	public ResponseEntity<Partido> updatePartido(@PathVariable(value="id") Long idPartido,
			@Valid @RequestBody Partido detallesPartido) {
		
		Partido partido = partidoDao.getById(idPartido);
		partido.setCheck_finalizado(detallesPartido.getCheck_finalizado());
		partido.setCompeticion(detallesPartido.getCompeticion());
		partido.setEquipoLocal(detallesPartido.getEquipoLocal());
		partido.setEquipoVisitante(detallesPartido.getEquipoVisitante());
		partido.setFx_inicio_fx(detallesPartido.getFx_inicio_fx());
		partido.setJuego(detallesPartido.getJuego());
		partido.setPuntuacionLocal(detallesPartido.getPuntuacionLocal());
		partido.setPuntuacionVisitante(detallesPartido.getPuntuacionVisitante());
		
		final Partido partidoActualizado = partidoDao.save(partido);
		
		
		return ResponseEntity.ok(partidoActualizado);
		
	}
	
	@DeleteMapping("borrarPartido/{id}")
	public Map<String,Boolean> deletePartido(@PathVariable(value="id") Long idPartido) {
		
		Partido partido = partidoDao.getById(idPartido);
		partidoDao.delete(partido);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}


}
