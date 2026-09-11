package sistemapagamento;

import java.util.HashMap;

public class Carrinho {
    private HashMap<Integer, Item> itensCarrinho;
    private Double subtotal;

    public Carrinho() {
        this.itensCarrinho = new HashMap<>();
        this.subtotal = 0.0;
    }

    public void exibir() {
        System.out.println("RECIBO");
                           
        for (Item item : this.itensCarrinho.values()) {
            Produto produto = item.getProduto();
            System.out.println("Item: " + produto.getNome() + " | Qntd: " + item.getQuantidade());
        }

        System.out.println("Subtotal: R$ " + this.getSubtotal() + "\n");
    }

    public void adicionar(Produto produto, Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }

        Item itemExistente = itensCarrinho.get(produto.getCodigo());

        if (itemExistente == null) {
            itensCarrinho.put(produto.getCodigo(), new Item(produto, quantidade));
        } else {
            Integer novaQuantidade = itemExistente.getQuantidade() + quantidade;
            itemExistente.setQuantidade(novaQuantidade);
        }
    }

    public boolean finalizarCompra(Estoque estoque) {
        if (this.itensCarrinho.isEmpty() || !estoque.temDisponibilidade(this.itensCarrinho.values())) {
            return false;
        }

        estoque.retirarProdutos(this.itensCarrinho.values());

        this.itensCarrinho.clear();
        this.subtotal = 0.0;

        return true;
    }

    public Double getSubtotal() {
        Double total = 0.0;

        for (Item item : itensCarrinho.values()) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        return total;
    }
}
