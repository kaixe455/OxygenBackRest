package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.UsuarioDao;
import com.oxygen.backendoxygen.model.Usuario;
import com.oxygen.backendoxygen.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {


	
	private final UsuarioDao usuarioDao;

	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		super();
		this.usuarioDao = usuarioDao;
	}
	
	@Override
	public List<Usuario> getUsuarios() {
		return usuarioDao.findAll();
	}
	
	@Override
	public Usuario getUsuarioById(long id) {
		return usuarioDao.getById(id);
	}
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
		
	}
	
	@Override 
	public Usuario updateUsuario(long id, Usuario usuarioModificado) {
		
		Usuario usuario = usuarioDao.getById(id);
		if(usuario != null) {
			usuario.setCorreoElectronico(usuarioModificado.getCorreoElectronico());
			usuario.setFx_creacion_fx(usuarioModificado.getFx_creacion_fx());
			usuario.setNickname(usuarioModificado.getNickname());
			usuario.setNombre(usuarioModificado.getNombre());
			usuario.setPassword(usuarioModificado.getPassword());
			usuario.setPrimer_apellido(usuarioModificado.getPrimer_apellido());
			usuario.setRol(usuarioModificado.getRol());
			usuario.setSegundo_apellido(usuarioModificado.getSegundo_apellido());
			usuario.setTwitch(usuarioModificado.getTwitch());
			usuario.setTwitter(usuarioModificado.getTwitter());
		}
		
		return usuarioDao.save(usuario);
	}
	
	@Override 
	public void deleteUsuario(long id) {
		
		Usuario usuario = usuarioDao.getById(id);
		
		if(usuario != null) {
			usuarioDao.delete(usuario);
		}
	}



}
