package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.SliderDao;
import com.oxygen.backendoxygen.model.Slider;
import com.oxygen.backendoxygen.services.SliderService;

@Service
public class SliderServiceImpl implements SliderService {
	
	private final SliderDao sliderDao;

	public SliderServiceImpl(SliderDao sliderDao) {
		super();
		this.sliderDao = sliderDao;
	}
	
	@Override
	public List<Slider> getSliders() {
		return sliderDao.findAll();
	}
	
	@Override
	public Slider getSliderById(long id) {
		return sliderDao.getById(id);
	}
	
	@Override
	public Slider createSlider(Slider slider) {
		return sliderDao.save(slider);
		
	}
	
	@Override 
	public Slider updateSlider(long id, Slider sliderModificado) {
		
		Slider slider = sliderDao.getById(id);
		if(slider != null) {
			slider.setImagen(sliderModificado.getImagen());
			slider.setNombre(sliderModificado.getNombre());
		}
		
		return sliderDao.save(slider);
	}
	
	@Override 
	public void deleteSlider(long id) {
		
		Slider slider = sliderDao.getById(id);
		
		if(slider != null) {
			sliderDao.delete(slider);
		}
	}

}
