package caixadeferramentas;

public class Produto {
    private final String nome;
    private final String marca;
    private final float preco;

    public Produto(String nome, String marca, Float preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public Float getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" +
               "Marca: " + this.getMarca() + "\n" +
               "Preço: R$ " + this.getPreco();
    }
}
