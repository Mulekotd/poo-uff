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

        for (Item item : itensEstoque) {
            Produto produto = item.getProduto();
            System.out.println(item.getQuantidade() + " | " + produto.getNome() + " | " + produto.getPreco());
        }

        System.out.print("\n");
    }

    public Produto pegaProduto(String nomeProduto, Integer qntdSolicitada) {
        Produto escolhido = null;

        for (Item item : itensEstoque) {
            Produto produto = item.getProduto();

            if (produto.getNome().equals(nomeProduto)) {
                escolhido = produto;
                item.setQuantidade(item.getQuantidade() - qntdSolicitada);
            }
        }

        return escolhido;
    }
}
