package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Usuario;

public interface UsuarioService {

	List<Usuario> getUsuarios();

	Usuario getUsuarioById(long id);

	Usuario createUsuario(Usuario usuario);

	Usuario updateUsuario(long id, Usuario usuarioModificado);

	void deleteUsuario(long id);

}
