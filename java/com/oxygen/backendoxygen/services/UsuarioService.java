package com.oxygen.backendoxygen.services;

import java.util.List;

import com.oxygen.backendoxygen.model.Usuario;
import com.oxygen.backendoxygen.model.dto.LoginFormDto;

public interface UsuarioService {

	List<Usuario> getUsuarios();

	Usuario getUsuarioById(long id);

	Usuario createUsuario(Usuario usuario);

	Usuario updateUsuario(long id, Usuario usuarioModificado);

	void deleteUsuario(long id);

	Usuario loginUsuario(LoginFormDto credenciales);

}
