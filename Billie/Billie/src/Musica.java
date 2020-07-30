public class Musica {

    private String nomeMusica;
    private double duracao;

    /* Construtor */
    public Musica(String nomeMusica, double duracao) {
        this.nomeMusica = nomeMusica;
        this.duracao = duracao;
    }

    /* Acessores e Modificadores */
    public String nomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {

        if (nomeMusica.length() < 2) {
            throw new IllegalArgumentException("Nome da música inválido.");
        } else {
            this.nomeMusica = nomeMusica;
        }
    }

    public double duracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {

        if (duracao < 1) {
            throw new IllegalArgumentException("Duração da música inválido.");
        } else {
            this.duracao = duracao;
        }
    }

    // verificar se o obejto musica possui nome identicos
    @Override
    public boolean equals(Object obj) {
        Musica aux = (Musica) obj;
        return (aux.nomeMusica == this.nomeMusica);
    }

    // converter para String
    @Override
    public String toString() {
        return ("Nome da música:" + nomeMusica + " Duração:" + duracao);
    }
}