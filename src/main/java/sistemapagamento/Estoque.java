package sistemapagamento;

import java.util.ArrayList;
import java.util.Collection;

public class Estoque {
    private ArrayList<Item> itensEstoque;

    public Estoque() {
        itensEstoque = new ArrayList<>();
        itensEstoque.add(new Item(new Produto(0, 20.0, "Hamburguer"), 25));
        itensEstoque.add(new Item(new Produto(1, 8.0, "Fritas"), 25));
        itensEstoque.add(new Item(new Produto(2, 5.0, "Refrigerante"), 25));
        itensEstoque.add(new Item(new Produto(3, 20.0, "Cheeseburguer"), 25));
    }

    public void exibir() {
        System.out.println("Quantidade | Produto | Valor");

        for (Item item : itensEstoque) {
            Produto produto = item.getProduto();
            System.out.println(item.getQuantidade() + " | " + produto.getNome() + " | R$ " + produto.getPreco());
        }

        System.out.print("\n");
    }

    public Produto buscarProduto(String nomeProduto) {
        if (nomeProduto == null) {
            return null;
        }

        String nomeNormalizado = nomeProduto.trim();

        for (Item item : itensEstoque) {
            Produto produto = item.getProduto();

            if (produto.getNome().trim().equalsIgnoreCase(nomeNormalizado)) {
                return produto;
            }
        }

        return null;
    }

    public boolean temDisponibilidade(Collection<Item> itens) {
        for (Item item : itens) {
            Item itemEstoque = encontrarItem(item.getProduto());

            if (itemEstoque == null || item.getQuantidade() > itemEstoque.getQuantidade()) {
                return false;
            }
        }

        return true;
    }

    public void retirarProdutos(Collection<Item> itens) {
        if (!temDisponibilidade(itens)) {
            throw new IllegalStateException("Estoque insuficiente para finalizar a compra.");
        }

        for (Item item : itens) {
            Item itemEstoque = encontrarItem(item.getProduto());
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - item.getQuantidade());
        }
    }

    private Item encontrarItem(Produto produto) {
        for (Item item : itensEstoque) {
            if (item.getProduto().getCodigo().equals(produto.getCodigo())) {
                return item;
            }
        }

        return null;
    }
}
