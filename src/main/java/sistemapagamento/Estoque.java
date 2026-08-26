package sistemapagamento;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Item> itensEstoque;

    public Estoque() {
        itensEstoque = new ArrayList<>();
        itensEstoque.add(new Item(new Produto("Hamburguer", 20.0), 25));
        itensEstoque.add(new Item(new Produto("Fritas", 8.0), 25));
        itensEstoque.add(new Item(new Produto("Refrigerante", 5.0), 25));
        itensEstoque.add(new Item(new Produto("Cheeseburguer", 20.0), 25));
    }

    public void exibir() {
        System.out.println("Quantidade | Produto | Valor");

        for (Item i : itensEstoque) {
            Produto p = i.getProduto();
            System.out.println(i.getQuantidade() + " | " + p.getNome() + " | " + p.getPreco());
        }
    }
}
