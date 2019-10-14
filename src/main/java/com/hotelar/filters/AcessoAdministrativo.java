package com.hotelar.filters;

import com.hotelar.enums.PerfilDeAcesso;
import com.hotelar.models.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/admin/*"})
public class AcessoAdministrativo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sessaoUsuario = ((HttpServletRequest)request).getSession();
        Usuario usuario = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");
        
        if(usuario != null && usuario.getPerfil().equals(PerfilDeAcesso.ADMINISTRADOR)){
            chain.doFilter(request, response);
        } else{
            ((HttpServletResponse)response).sendRedirect("erro.jsp");
        }
    }
}
