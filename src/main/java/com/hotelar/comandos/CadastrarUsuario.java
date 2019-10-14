package com.hotelar.comandos;

import com.hotelar.contratos.Comandos;
import com.hotelar.models.Usuario;
import com.hotelar.services.UsuarioService;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastrarUsuario implements Comandos {
    
    private static final String TEMPLATE_FOLDER = "usuarios";
    
    @Inject
    private UsuarioService service;

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Usuario> usuarios = this.service.listar();
        request.setAttribute("usuarios", usuarios);
        return "/admin/"+ TEMPLATE_FOLDER +"/cadastrar_usuario.jsp";
    }
}
