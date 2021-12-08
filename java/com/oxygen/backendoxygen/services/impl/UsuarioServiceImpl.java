package com.oxygen.backendoxygen.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oxygen.backendoxygen.dao.UsuarioDao;
import com.oxygen.backendoxygen.model.Usuario;
import com.oxygen.backendoxygen.model.dto.LoginFormDto;
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
		return usuarioDao.findById(id).get();
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
			usuario.setNickname(usuarioModificado.getNickname());
			usuario.setNombre(usuarioModificado.getNombre());
			usuario.setPrimer_apellido(usuarioModificado.getPrimer_apellido());
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
	
	@Override
	public Usuario loginUsuario(LoginFormDto credenciales) {
		// primero busco si existe el usuario en bbdd.
		Usuario user = new Usuario();
		if(credenciales != null && credenciales.getCorreoElectronico() != null && !credenciales.getCorreoElectronico().isEmpty()) {
			user = usuarioDao.getUsuarioByEmail(credenciales.getCorreoElectronico());
			if(credenciales.getPassword() != null && !credenciales.getPassword().isEmpty() && user != null) {
				// verifico que la contraseña introducida sea correcta.
				if(user.getPassword().equals(credenciales.getPassword())) {
					return user;
				}else {
					return null;
				}
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}



}
