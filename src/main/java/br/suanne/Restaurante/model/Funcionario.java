package br.suanne.Restaurante.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Funcionario {
    private static Long idBase = 0L;
    private Long id;
    private String nome;
    private String cpf;



    public  Funcionario(String nome, String cpf) {
        this.id = idBase++;
        this.nome = nome;
        this.cpf = cpf;

    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
