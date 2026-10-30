package edu.ifam.tads.dweb.model;

public class Pessoa {

    private String nome;
    private String email;
    private String telefone;

    private Cidade cidade;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setCidade(Cidade cidade){
        this.cidade = cidade;
    }

    public Cidade getCidade(){
        return this.cidade;
    }

}
