package edu.ifam.tads.dweb.model;

public class Cidade {

    private String nome;
    private Estado estado;

    public Cidade(){

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado(){
        return this.estado;
    }

}
