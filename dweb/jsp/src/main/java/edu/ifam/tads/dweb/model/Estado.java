package edu.ifam.tads.dweb.model;

public class Estado {

    private String nome;
    private String sigla;
    private Pais pais;

    //Construtor
    public Estado(){
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setSigla(String sigla){
        this.sigla = sigla;
    }

    public String getSigla(){
        return this.sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
