import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {

    static ArrayList<Album> meusAlbuns = new ArrayList<Album>(); // lista de albuns
    static ArrayList<Musica> minhasMusicas = new ArrayList<Musica>(); // lista de músicas
    static ArrayList<Musica> favoritas = new ArrayList<Musica>(); // lista de músicas favoritas

    /* Cadastrar o Album */
    public static void Cadastro_Album() {

        Scanner leitor = new Scanner(System.in);
        String titulo;
        int anoLancamento;
        String nomeBanda;

        System.out.println("\n---- Cadastro do Album -----");
        System.out.print("Digite o nome do Album: ");
        titulo = leitor.nextLine();
        System.out.print("Digite o nome da banda: ");
        nomeBanda = leitor.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        anoLancamento = leitor.nextInt();

        // adicionar na lista de albuns
        meusAlbuns.add(new Album(titulo, nomeBanda, anoLancamento));

        System.out.println("\nAlbum: " + titulo + " | Nome da banda: " + nomeBanda + " | Ano:" + anoLancamento
                + " foi cadastrado com sucesso!");
    }

    /* Cadastrar as músicas do album */
    public static void Cadastro_Musica() {

        Scanner leitor = new Scanner(System.in);
        String nomeMusica;
        double duracao;
        String op;

        System.out.println("\n---- Cadastro das Músicas -----");
        System.out.print("Digite o nome da música: ");
        nomeMusica = leitor.nextLine();
        System.out.print("Digite a duração da música (min): ");
        duracao = Double.parseDouble(leitor.nextLine());

        // adicionar na lista de musica
        minhasMusicas.add(new Musica(nomeMusica, duracao));

        System.out.println("\nMúsica: " + nomeMusica + "| Duração:(min) " + duracao + " foi cadastrada com sucesso!");

        // verificar se deseja adicionar as favoritas
        System.out.print("\nDeseja adicionar a música as favoritas? ");
        op = leitor.nextLine();

        // somente serão aceitos esses dois tipos de entrada
        switch ((op)) {
            case "sim":
            case "Sim":

                // adicionar na lista de músicas favoritas
                favoritas.add(new Musica(nomeMusica, duracao));
                System.out.println("\nMúsica adicionada as favoritas com sucesso!");
                break;

            case "nao":
            case "Nao":
                System.out.println("\nMúsica não foi adicionada as favoritas!");
                leitor.nextLine();
                break;

            default:
                System.out.println("\nOpção inválida!");
                break;
        }// fim switch
    }

    /* Pesquisar Album pelo titulo */
    public static void Pesquisar_Album_Titulo() {

        Scanner leitor = new Scanner(System.in);
        String titulo;
        boolean encontrado = false;

        try {
            // verificar se a lista de album está vazia
            if (meusAlbuns.isEmpty()) {
                System.out.println("Lista de albuns está vazia!");
            } else {
                System.out.print("Informe o titulo do album pesquisa: ");
                titulo = leitor.nextLine();

                // printar os albuns e suas respectivas músicas ja cadastradas
                for (Album album : meusAlbuns) {
                    System.out.println("\nAlbun(s) já cadastrados: " + album.titulo());

                    for (Musica musica : minhasMusicas) {
                        System.out.println("Música(s) já cadastradas: " + musica.nomeMusica());
                    }

                    // verificar se o titulo é o mesmo da lista
                    if (titulo.equals(album.titulo())) {

                        encontrado = true;
                        System.out.println("Album: " + album.titulo() + "| Nome da banda: " + album.nomeBanda()
                                + "| Ano: " + album.anoLancamento() + " foi encontrado com sucesso!");
                        break;
                    }
                    if (!encontrado) {
                        System.out.println("ERROR: Album não encontrado ou cadastrado!");
                    } // fim if
                } // fim for
            } // fim if
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Pesquisa retornou NULL.");
        }
    }

    /* Pesquisar Album pelo nome da banda */
    public static void Pesquisar_Album_NomeBanda() {

        Scanner leitor = new Scanner(System.in);
        String nomeBanda;
        boolean encontrado = false;

        try {
            // verificar se a lista de album está vazia
            if (meusAlbuns.isEmpty()) {
                System.out.println("Lista de albuns está vazia!");
            } else {
                System.out.print("Informe o nome da banda para pesquisa: ");
                nomeBanda = leitor.nextLine();

                // printar os albuns e suas respectivas músicas ja cadastradas
                for (Album album : meusAlbuns) {
                    System.out.println("\nAlbun(s) já cadastrados: " + album.titulo());

                    for (Musica musica : minhasMusicas) {
                        System.out.println("Música já cadastradas: " + musica.nomeMusica());
                    }

                    // verificar se o titulo é o mesmo da lista
                    if (nomeBanda.equals(album.nomeBanda())) {

                        encontrado = true;
                        System.out.println("Album: " + album.titulo() + "| Nome da banda: " + album.nomeBanda()
                                + "| Ano: " + album.anoLancamento() + " foi encontrado com sucesso!");
                        break;
                    }
                    if (!encontrado) {
                        System.out.println("ERROR: Album não encontrado ou cadastrado!");
                    } // fim if
                } // fim for
            } // fim if
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Pesquisa retornou NULL.");
        }
    }

    /* Pesquisar Música */
    public static void Pesquisar_Musica() {

        Scanner leitor = new Scanner(System.in);
        String nomeMusica;
        Musica musica;
        boolean encontrado = false;

        try {
            // verificar se a lista de música está vazia
            if (minhasMusicas.isEmpty()) {
                System.out.println("A Lista de música está vazia!");
            } else {
                System.out.print("Informe o nome da música para pesquisa: ");
                nomeMusica = leitor.nextLine();

                // obter a posicao da musica na lista de musica
                for (int i = 0; i < minhasMusicas.size(); i++) {
                    musica = (Musica) minhasMusicas.get(i);

                    // verificar se o nome da musica é igual ao do objeto
                    if (nomeMusica.equals(musica.nomeMusica())) {
                        encontrado = true;

                        System.out.println("Título da música: " + musica.nomeMusica() + " | Duração: "
                                + musica.duracao() + " foi encontrada com sucesso!");
                        break;
                    }
                    if (!encontrado) {
                        System.out.println("ERROR: Música não encontrada ou cadastrada!");
                    } // fim if
                } // fim for
            } // fim if
        } catch (

        NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Pesquisa retornou NULL.");
        }
    }

    /* Gerar playlist de musicas juntamente com as favoritas */
    public static String Gerar_Playlist() {

        // Musica minhasMusicas; // musicas da playlist
        // double duracao = 0; // tempo de cada musica da playlist
        // double duracao_total = 0; // tempo total da playlist
        // String playlist;

        // Iterator it =

        // // enquanto as listas nao forem vazia
        // while (minhasMusicas != null && favoritas != null) {

        // // verificar a proxima posicao de cada lista de música
        // minhasMusicas = (Musica);

        // // conveter a playlist e a duracao para String
        // duracao = minhasMusicas.duracao();
        // playlist += minhasMusicas.toString() + "\n\n";

        // // apontar para a proxima posicao da lista
        // }
        // duracao_total = duracao;
        // playlist += "Playlist:" + playlist + " Duração:" + duracao_total + "\n";
        // return playlist;
        return null;
    }

    /* Menu de opçoes */
    public static void Menu() {

        Scanner ler = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n---- Menu de opções ----");
            System.out.print("1 - Cadastrar Album");
            System.out.print("\n2 - Cadastrar Músicas do album");
            System.out.print("\n3 - Pesquisar Album pelo titulo");
            System.out.print("\n4 - Pesquisar Album pelo nome da banda");
            System.out.print("\n5 - Pesquisar Música");
            System.out.print("\n6 - Gerar Playlist");
            System.out.println("\n7 - Sair");
            System.out.print("\nDigite sua opção: ");
            op = Integer.parseInt(ler.nextLine());

            switch ((op)) {
                case 1:
                    Cadastro_Album();
                    break;
                case 2:
                    Cadastro_Musica();
                    break;
                case 3:
                    Pesquisar_Album_Titulo();
                    break;
                case 4:
                    Pesquisar_Album_NomeBanda();
                    break;
                case 5:
                    Pesquisar_Musica();
                    break;
                case 6:
                    Gerar_Playlist();
                    break;
                case 7:
                    System.out.println("Sair do menu.");
                    break;
                default:
                    System.out.println("Número inválido.");
                    break;
            }// fim switch
        } while ((op) != 7);
        ler.close();
    }

    public static void main(String[] args) throws Exception {
        Menu();
    }
}
