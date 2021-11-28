package com.oxygen.backendoxygen.dao;

import com.oxygen.backendoxygen.model.Usuario;

public interface UsuarioDaoCustom {

	Usuario getUsuarioByEmail(String email);

}
