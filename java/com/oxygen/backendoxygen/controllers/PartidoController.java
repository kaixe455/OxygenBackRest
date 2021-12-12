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
import com.oxygen.backendoxygen.model.Juego;
import com.oxygen.backendoxygen.model.Partido;
import com.oxygen.backendoxygen.model.dto.PartidoFormDto;
import com.oxygen.backendoxygen.services.EquipoService;
import com.oxygen.backendoxygen.services.JuegoService;
import com.oxygen.backendoxygen.services.PartidoService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest")
public class PartidoController {
	
	@Autowired
	PartidoService partidoService;
	
	@Autowired
	JuegoService juegoService;
	
	@Autowired
	EquipoService equipoService;
	
	@GetMapping("/partidos")
	public List<Partido> getAllPartidos() {
		
		return partidoService.getPartidos();
	}
	
	@GetMapping("/partidos/{id}")
	public ResponseEntity<Partido> getPartidoById (@PathVariable(value="id") Long idPartido) {
		
		Partido partido = partidoService.getPartidoById(idPartido);
		return ResponseEntity.ok().body(partido);
		
	}
	
	@PostMapping("/crearPartido")
	public Partido createPartido(@Valid @RequestBody PartidoFormDto partido) {
		Juego juego = juegoService.getJuegoById(Long.valueOf(partido.getJuego().getId()));
		Equipo equipoLocal = equipoService.getEquipoById(Long.valueOf(partido.getEquipoLocal().getId()));
		Equipo equipoVisitante = equipoService.getEquipoById(Long.valueOf(partido.getEquipoVisitante().getId()));
		
		 Partido partidoGuardar = new Partido();
		 partidoGuardar.setCheck_finalizado(partido.getCheck_finalizado());
		 partidoGuardar.setCompeticion(partido.getCompeticion());
		 partidoGuardar.setEquipoLocal(equipoLocal);
		 partidoGuardar.setEquipoVisitante(equipoVisitante);
		 partidoGuardar.setFx_inicio_fx(partido.getFx_inicio_fx());
		 partidoGuardar.setJuego(juego);
		 if(partido.getPuntuacionLocal() == -1 && partido.getPuntuacionVisitante() == -1) {
			 //partido de nueva creación
			 partidoGuardar.setPuntuacionLocal(null);
			 partidoGuardar.setPuntuacionVisitante(null);
		 }else {
			 partidoGuardar.setPuntuacionLocal(partido.getPuntuacionLocal());
			 partidoGuardar.setPuntuacionVisitante(partido.getPuntuacionVisitante());
		 }
		 
		return partidoService.createPartido(partidoGuardar);
	}
	
	@PutMapping("/updatePartido/{id}")
	public ResponseEntity<Partido> updatePartido(@PathVariable(value = "id") Long idPartido,
			@Valid @RequestBody Partido detallesPartido) {
		
		final Partido partidoActualizado = partidoService.updatePartido(idPartido, detallesPartido);
		
		return ResponseEntity.ok(partidoActualizado);
	}
	
	@DeleteMapping("/borrarPartido/{id}")
	public Map<String, Boolean> deletePartido(@PathVariable(value="id") Long idPartido) {
		
		partidoService.deletePartido(idPartido);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/partidosAdmin")
	public List<Partido> getPartidosAdmin() {
		
		return partidoService.getPartidosAdmin();
	}
	
	@GetMapping("/reiniciarPartido/{id}")
	public Partido getReiniciarPartido(@PathVariable(value = "id") Long idPartido) {
		
		return partidoService.getReiniciarPartido(idPartido);
	}
	
	@GetMapping("/proximoPartido")
	public Partido getProximoPartido() {
		
		return partidoService.getProximoPartido();
	}
	
	@GetMapping("/ultimosResultados")
	public List<Partido> getUltimosResultados() {
		
		return partidoService.getUltimosResultados();
	}

}
