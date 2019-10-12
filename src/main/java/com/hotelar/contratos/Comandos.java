package com.hotelar.contratos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comandos {
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
