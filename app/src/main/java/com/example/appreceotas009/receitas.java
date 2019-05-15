package com.example.appreceotas009;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class receitas implements Serializable {


    private Integer id;
    private String nome;
    private String ingredientes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String descricao) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString(){
        return nome;
    }
}
