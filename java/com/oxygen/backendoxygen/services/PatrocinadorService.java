package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Patrocinador;

public interface PatrocinadorService {

	List<Patrocinador> getPatrocinadores();

	Patrocinador getPatrocinadorById(long id);

	Patrocinador createPatrocinador(Patrocinador patrocinador);

	Patrocinador updatePatrocinador(long id, Patrocinador patrocinadorModificado);

	void deletePatrocinador(long id);

}
