package com.hotelar.models;


public class Acomodacao {

    private int id;
    private String tipo;
    private String descricao;
    private Double valorPadrao;

    public Acomodacao(int id, String tipo, String descricao, Double valorPadrao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorPadrao = valorPadrao;
    }
    
    public Acomodacao(String tipo, String descricao, Double valorPadrao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorPadrao = valorPadrao;
    }
    
    public Acomodacao() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorPadrao() {
        return valorPadrao;
    }

    public void setValorPadrao(Double valorPadrao) {
        this.valorPadrao = valorPadrao;
    }
}
