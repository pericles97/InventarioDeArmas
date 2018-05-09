package com.dev.pericles.inventario;

public class Arma {

    private int id;
    private String nome;
    private String calibre;
    private String categoria;
    private String material;
    private String capacidade;
    private String peso;
    private String pais;


    public Arma(int id, String nome, String calibre, String categoria, String material, String capacidade, String peso, String pais) {
        this.id = id;
        this.nome = nome;
        this.calibre = calibre;
        this.categoria = categoria;
        this.material = material;
        this.capacidade = capacidade;
        this.peso = peso;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    /*
    * Nome
    Calibre
    Categoria
    Acabamento/Material
    Capacidade
    Peso
    País

    * */

}
