package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Slider;

public interface SliderService {

	List<Slider> getSliders();

	Slider getSliderById(long id);

	Slider createSlider(Slider slider);

	Slider updateSlider(long id, Slider sliderModificado);

	void deleteSlider(long id);

}
