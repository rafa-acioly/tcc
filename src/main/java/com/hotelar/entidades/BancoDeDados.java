package com.hotelar.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;


public class BancoDeDados {
    
    @Produces
    @RequestScoped
    public static Connection getConexao(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:15432/postgres", "postgres", "Postgres2019!");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
    
    public void fechaConexao(@Disposes Connection conexao) {
        try {
            conexao.close();
        } catch (SQLException e) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }
}
