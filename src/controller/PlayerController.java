package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kreis.aulas.ListaStrings;

	public class PlayerController {
		
		ListaStrings lista = new ListaStrings();

	    public void adicionaMusica(Lista<Musica> lista, String musica) {
	        String[] campos = musica.split(";");
	        Musica novaMusica = new Musica(campos[0], campos[1], Integer.parseInt(campos[2]));
	        if (lista.estaVazia()) {
	            lista.insereInicio(novaMusica);
	        } else {
	            lista.insereFim(novaMusica);
	        }
	    }

	    public void removeMusica(Lista<Musica> lista, int posicao) {
	        if (lista.estaVazia()) {
	            throw new RuntimeException("A lista está vazia!");
	        }
	        lista.remove(posicao);
	    }

	    public void executaPlaylist(Lista<Musica> lista) {
	        if (lista.estaVazia()) {
	            throw new RuntimeException("A lista está vazia!");
	        }
	        for (int i = 0; i < lista.tamanho(); i++) {
	            Musica musica = lista.recupera(i);
	            System.out.println(musica);
	            try {
	                Thread.sleep(musica.getDuracao() * 1000); // simula a música tocando
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}