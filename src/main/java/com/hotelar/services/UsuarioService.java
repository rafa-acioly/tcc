package com.hotelar.services;

import com.hotelar.daos.UsuarioDAO;
import javax.inject.Inject;

public class UsuarioService {
    
    @Inject
    private UsuarioDAO usuarioDAO;
    
    public UsuarioService(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }
    
    public UsuarioService() {
        this(null);
    }
}
