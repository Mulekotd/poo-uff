package sistemapagamento;

public class Produto {
    private static int nextId = 0;

    private final Integer id;
    private final String nome;
    private final Double preco;

    public Produto(String nome, Double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (preco == null || preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
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

    public Double getPreco() {
        return preco;
    }
}
