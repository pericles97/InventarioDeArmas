package com.dev.pericles.inventario;

import java.util.ArrayList;

public class ListaArmas {

    private static ArrayList<Arma> listaArmas = new ArrayList<>();

    public static void addArma(Arma arma){
        listaArmas.add(arma);
    }

    public static ArrayList<Arma> getListaArmas(){
        return listaArmas;
    }

    public static void excluirArma(int index){
        listaArmas.remove(index);
    }

    /*public static void carregarContatos(){ //Adicionando dados pre cadastrados
        listaContatos.add(new Contato("Battlefield 1", 85248443, "teste@teste" ));
        listaContatos.add(new Contato("Titanfall 2", 85248443, "teste@teste"));
        listaContatos.add(new Contato("Star Wars: Battlefront 2", 85248443, "teste@teste"));
        listaContatos.add(new Contato("Horizon: Zero Dawn", 85248443, "teste@teste" ));
        listaContatos.add(new Contato("Teamfortess 2", 85248443, "teste@teste"));
        listaContatos.add(new Contato("Destiny 2", 85248443, "teste@teste"));
        listaContatos.add(new Contato("Zelda: Ocarina of Time", 85248443, "teste@teste" ));
        listaContatos.add(new Contato("The Last of Us", 85248443, "teste@teste"));
        listaContatos.add(new Contato("Star Wars: Episode I - Racer", 85248443, "teste@teste"));
    }*/

    public static int getTamanhoListaArmas(){
        return listaArmas.size();
    }
}
