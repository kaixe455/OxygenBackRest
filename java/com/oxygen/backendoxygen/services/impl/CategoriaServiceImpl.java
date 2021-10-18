package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.CategoriaDao;
import com.oxygen.backendoxygen.model.Categoria;
import com.oxygen.backendoxygen.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {


	
	private final CategoriaDao categoriaDao;

	public CategoriaServiceImpl(CategoriaDao categoriaDao) {
		super();
		this.categoriaDao = categoriaDao;
	}
	
	@Override
	public List<Categoria> getCategorias() {
		return categoriaDao.findAll();
	}
	
	@Override
	public Categoria getCategoriaById(long id) {
		return categoriaDao.findById(id).get();
	}
	
	@Override
	public Categoria createCategoria(Categoria categoria) {
		return categoriaDao.save(categoria);
		
	}
	
	@Override 
	public Categoria updateCategoria(long id, Categoria categoriaModificado) {
		
		Categoria categoria = categoriaDao.getById(id);
		if(categoria != null) {
			categoria.setNombre(categoriaModificado.getNombre());
			categoria.setDescripcion(categoriaModificado.getDescripcion());
		}
		
		return categoriaDao.save(categoria);
	}
	
	@Override 
	public void deleteCategoria(long id) {
		
		Categoria categoria = categoriaDao.getById(id);
		
		if(categoria != null) {
			categoriaDao.delete(categoria);
		}
	}
	
	@Override
	public List<Categoria> getCategoriasConNoticias() {
		return categoriaDao.getCategoriasConNoticia();
	}



}
