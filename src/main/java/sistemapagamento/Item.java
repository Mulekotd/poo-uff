package sistemapagamento;

public class Item {
    private Produto produto;
    private Integer quantidade;

    public Item(Produto produto, Integer quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        validarQuantidade(quantidade);
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        if (quantidade == null || quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    private void validarQuantidade(Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }
    }
}
