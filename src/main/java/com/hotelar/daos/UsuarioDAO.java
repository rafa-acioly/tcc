package com.hotelar.daos;

import com.hotelar.enums.PerfilDeAcesso;
import com.hotelar.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Inject;


public class UsuarioDAO {
    
    @Inject
    private Connection conexao;

    private String LISTAR_USUARIO = "SELECT * FROM usuarios";
    
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public UsuarioDAO() {
        this(null);
    }
    
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.conexao.prepareStatement(LISTAR_USUARIO);
            ResultSet rsUsuario = pstmt.executeQuery();
            while (rsUsuario.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rsUsuario.getInt("id"));
                usuario.setEmail(rsUsuario.getString("email"));
                usuario.setSenha(rsUsuario.getString("senha"));
                usuario.setPerfil(PerfilDeAcesso.valueOf(rsUsuario.getString("perfil")));
                usuario.setCpf(rsUsuario.getString("cpf"));
                usuarios.add(usuario);
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        }

        return usuarios;
    }
}
