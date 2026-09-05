package model;

public class Cidade {

    private String nome;
    private Estado estado;

    public Cidade () {

    }

    public String getNome () {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado () {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
/*
|    - Cidade -   |         |      - Estado -    |
|- nome: String   | *     1 |- nome: String      |
|- estado: Estado | ------> |- sigla: String     |
|---------------- |         |- cidades: Cidade[] |
|   - metodos -   |         |     - metodos -    |
|---------------- |         |------------------- |

 */