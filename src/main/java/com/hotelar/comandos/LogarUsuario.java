package com.hotelar.comandos;

import com.hotelar.contratos.Comandos;
import com.hotelar.models.Usuario;
import com.hotelar.services.UsuarioService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogarUsuario implements Comandos {

    @Inject
    private UsuarioService service;

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getParameter("txtLogin"));
        usuario.setSenha(request.getParameter("txtSenha"));
        Usuario usuarioAutenticado = this.service.autenticar(usuario);

        if (usuarioAutenticado != null) {
            HttpSession sessaoUsuario = request.getSession();
            sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);

            return "admin/index.jsp";
        }

        request.setAttribute("msg", "Login ou Senha Incorreto!");
        return "index.jsp";
    }
}
