import dao.DAOProduto;
import sistemapagamento.Produto;

import java.util.ArrayList;

public class ProgramaArquivoBinario {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java LabArquivoBinario <filepath>");
            return;
        }

        String filepath = args[0];

        DAOProduto daoProduto = new DAOProduto(filepath);

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(0, 12.50, "Caneta"));
        produtos.add(new Produto(1, 8.90, "Caderno"));
        produtos.add(new Produto(2, 25.00, "Mochila"));

        daoProduto.salvar(produtos);

        System.out.println("Produtos lidos do arquivo:");
        for (Produto produto : daoProduto.ler()) {
            System.out.printf(
                    "Código: %d | Nome: %s | Preço: R$ %.2f%n",
                    produto.getCodigo(),
                    produto.getNome(),
                    produto.getPreco());
        }
    }
}
