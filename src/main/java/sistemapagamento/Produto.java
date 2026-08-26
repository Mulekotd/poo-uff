package sistemapagamento;

public class Produto {
    private static int nextId = 0;

    private final Integer id;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.id = nextId++;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
