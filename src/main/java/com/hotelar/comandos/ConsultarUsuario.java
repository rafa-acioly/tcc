package com.hotelar.comandos;

import com.hotelar.contratos.Comandos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConsultarUsuario implements Comandos {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "consultar_usuario.jsp";
    }   
}
