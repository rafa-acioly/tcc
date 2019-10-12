package com.hotelar.comandos;

import com.hotelar.contratos.Comandos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastrarUsuario implements Comandos {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "cadastrar_usuario.jsp";
    }
}
