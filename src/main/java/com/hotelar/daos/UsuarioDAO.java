package com.hotelar.daos;

import java.sql.Connection;
import javax.inject.Inject;


public class UsuarioDAO {
    
    @Inject
    private Connection conexao;
    
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public UsuarioDAO() {
        this(null);
    }
}
