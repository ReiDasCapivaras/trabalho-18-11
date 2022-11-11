package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table (name="Produto_Trabalho")
public class Produto {
    @Id //(GeneratedValue = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String descricao;
    @Column
    private String marca;
    @Column
    private float preco;


    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
