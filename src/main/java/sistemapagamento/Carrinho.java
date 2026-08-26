package sistemapagamento;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Item> itensCarrinho;

    public Carrinho() {
        itensCarrinho = new ArrayList<>();
    }

    public void exibir() {
        System.out.println("Itens no carrinho:");

        for (Item i : this.itensCarrinho) {
            Produto p = i.getProduto();
            System.out.println("Nome: " + p.getNome() + ", Quantidade: " + i.getQuantidade());
        }

        System.out.println("Subtotal: " + this.subtotal());
    }

    public void adicionar(Item item) {
        itensCarrinho.add(item);
    }

    public double subtotal() {
        double total = 0;
        
        for (Item i: itensCarrinho) {
            Produto p = i.getProduto();
            Integer q = i.getQuantidade();
            total += p.getPreco() * q;
        }

        return total;
    }
}
