package sistemapagamento;

public class Produto {
    private static int nextId = 0;

    private final Integer codigo;
    private final double preco;
    private final String nome;

    public Produto(Integer codigo, double preco, String nome) {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }

        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
