package torneio;

public class Competidor {
    private String nome;
    private String treinador;
    private String pais;
    
    public Competidor(String nome, String treinador, String pais) {
        this.nome = nome;
        this.treinador = treinador;
        this.pais = pais;
    }

    /* metodos de acesso */
    public String getNome() {
        return this.nome;
    }

    public String getTreinador() {
        return this.treinador;
    }
    
    public String getPais() {
        return this.pais;
    }
}
