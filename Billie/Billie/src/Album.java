import java.util.ArrayList;

public class Album {

    private String titulo;
    private String nomeBanda;
    private int anoLancamento;

    /* Lista de música de cada Album */
    private ArrayList<Musica> minhasMusicas;

    public Album() {
        minhasMusicas = new ArrayList();
    }

    /* Construtor */
    public Album(String titulo, String nomeBanda, int anoLancamento) {
        this.titulo = titulo;
        this.nomeBanda = nomeBanda;
        this.anoLancamento = anoLancamento;
        minhasMusicas = new ArrayList();
    }

    public ArrayList<Musica> minhasMusicas() {
        return minhasMusicas;
    }

    public void setMinhasMusicas(ArrayList<Musica> minhasMusicas) {
        this.minhasMusicas = minhasMusicas;
    }

    public String titulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() < 2) {
            throw new IllegalArgumentException("Título inválido.");
        } else {
            this.titulo = titulo;
        }
    }

    /* Acessores e Modificadores */
    public String nomeBanda() {
        return nomeBanda;
    }

    public void setNomeBanda(String nomeBanda) {
        if (nomeBanda.length() < 2) {
            throw new IllegalArgumentException("Nome da banda inválido.");
        } else {
            this.nomeBanda = nomeBanda;
        }
    }

    public int anoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        if (anoLancamento < 1900) {
            throw new IllegalArgumentException("Ano inválido inválido.");
        } else {
            this.anoLancamento = anoLancamento;
        }
    }

    // verificar se o obejto album possui titulos identicos
    @Override
    public boolean equals(Object obj) {
        Album aux = (Album) obj;
        return (aux.titulo == this.titulo);
    }

    // converter para String
    @Override
    public String toString() {
        return ("Título: " + titulo + " Nome da banda :" + nomeBanda + " Ano: " + anoLancamento);
    }
}