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
        Item itemExistente = itensCarrinho.get(produto.getId());

        if (itemExistente == null) {
            itensCarrinho.put(produto.getId(), new Item(produto, quantidade));
        } else {
            Integer novaQuantidade = itemExistente.getQuantidade() + quantidade;
            itemExistente.setQuantidade(novaQuantidade);
        }
    }

    public void finalizarCompra() {
        if (this.itensCarrinho.size() == 0) {
            System.out.println("Adicione pelo menos um item ao carrinho.\n");
            return;
        }

        System.out.println("Compra finalizada com sucesso!\n");

        this.itensCarrinho.clear();
        this.subtotal = 0.0;
    }

    public Double getSubtotal() {
        for (Item item: itensCarrinho.values()) {
            Produto produto = item.getProduto();
            Integer quantidade = item.getQuantidade();

            this.subtotal += produto.getPreco() * quantidade;
        }

        return this.subtotal;
    }
}
