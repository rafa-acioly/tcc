package com.hotelar.comandos;

import com.hotelar.contratos.Comandos;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeslogarUsuario implements Comandos {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sessaoUsuario = request.getSession();
        sessaoUsuario.removeAttribute("usuarioAutenticado");

        return "index.jsp";
    }
}
