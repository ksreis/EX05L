package view;

import java.util.Scanner;

import kreis.aulas.ListaStrings;

public class Principal {
    
	ListaStrings lista = new ListaStrings();
	
    private static Scanner scanner = new Scanner(System.in);
    private static ListaStrings playlist = new ListaStrings();
    
    public static void main(String[] args) {
        int opcao = 0;
        
        while (opcao != 4) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar música");
            System.out.println("2 - Remover música");
            System.out.println("3 - Executar playlist");
            System.out.println("4 - Sair");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer de entrada
            
            switch (opcao) {
                case 1:
                    adicionarMusica();
                    break;
                case 2:
                    removerMusica();
                    break;
                case 3:
                    executarPlaylist();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    
    private static void adicionarMusica() {
        System.out.println("Digite o nome da música:");
        String nome = scanner.nextLine();
        
        System.out.println("Digite o nome do artista:");
        String artista = scanner.nextLine();
        
        System.out.println("Digite a duração da música (em segundos):");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer de entrada
        
        String musica = nome + ";" + artista + ";" + duracao;
        playlist.adicionar(musica);
        
        System.out.println("Música adicionada à playlist!");
    }
    
    private static void removerMusica() {
        if (playlist.tamanho() == 0) {
            System.out.println("Playlist vazia!");
            return;
        }
        
        System.out.println("Digite o índice da música que deseja remover:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer de entrada
        
        try {
            String musicaRemovida = playlist.remover(indice);
            System.out.println("Música \"" + musicaRemovida + "\" removida da playlist!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice inválido!");
        }
    }
    
    private static void executarPlaylist() {
        if (playlist.tamanho() == 0) {
            System.out.println("Playlist vazia!");
            return;
        }
        
        System.out.println("Executando playlist:");
        
        for (int i = 0; i < playlist.tamanho(); i++) {
            String musica = playlist.obter(i);
            String[] dadosMusica = musica.split(";");
            String nome = dadosMusica[0];
            String artista = dadosMusica[1];
            int duracao = Integer.parseInt(dadosMusica[2]);
            
            System.out.println("[Música: " + nome + " - Artista: " + artista + " - Duração: " + duracao + "]");
            
            try {
                Thread.sleep(duracao * 1000); // Converter para milissegundos
            } catch (InterruptedException e) {
                System.out.println("Erro ao executar música!");
            }
        }
        
        System.out.println("Fim da playlist!");
    }

}
