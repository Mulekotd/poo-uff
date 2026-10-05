package caixadeferramentas;

public class ItemEstoque<T extends Produto> {
    private final T produto;
    private final int quantidade;

    public ItemEstoque(T produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public T getProduto() {
        return this.produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    @Override
    public String toString() {
        return this.getProduto().toString() + "\n" +
               "Quantidade: " + this.getQuantidade() + "\n";
    }
}
