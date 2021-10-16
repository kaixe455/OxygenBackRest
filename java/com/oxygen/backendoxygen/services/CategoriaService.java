package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Categoria;

public interface CategoriaService {

	List<Categoria> getCategorias();

	Categoria getCategoriaById(long id);

	Categoria createCategoria(Categoria categoria);

	Categoria updateCategoria(long id, Categoria categoriaModificado);

	void deleteCategoria(long id);

}
