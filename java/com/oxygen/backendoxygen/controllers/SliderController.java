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

import com.oxygen.backendoxygen.model.Slider;
import com.oxygen.backendoxygen.services.SliderService;

@RestController @CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/rest")
public class SliderController {
	
	@Autowired
	private SliderService sliderService;
	
	@GetMapping("/sliders")
	public List<Slider> getAllSliders() {
		
		return sliderService.getSliders();
	}
	
	@GetMapping("/sliders/{id}")
	public ResponseEntity<Slider> getSliderbyId (@PathVariable(value = "id") Long idSlider) {
		
		Slider slider = sliderService.getSliderById(idSlider);
		return ResponseEntity.ok().body(slider);
	}
	
	@PostMapping("/createSlider")
	public Slider createSlider(@Valid @RequestBody Slider slider) {
		
		return sliderService.createSlider(slider);
	}
	
	@PutMapping("/updateSlider/{id}")
	public ResponseEntity<Slider> updateSlider(@PathVariable(value="id") Long idSlider,
			@Valid @RequestBody Slider detallesSlider) {
		
		final Slider sliderActualizado = sliderService.updateSlider(idSlider, detallesSlider);
		return ResponseEntity.ok(sliderActualizado);
		
	}
	
	@DeleteMapping("borrarSlider/{id}")
	public Map<String,Boolean> deleteSlider(@PathVariable(value="id") Long idSlider) {
		
		sliderService.deleteSlider(idSlider);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("borrado", Boolean.TRUE);
		return response;
	}


}
