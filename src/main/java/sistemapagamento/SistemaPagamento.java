package sistemapagamento;

import java.util.Scanner;

public class SistemaPagamento {
    private Sessao sessao;
    private Estoque estoque;
    private Carrinho carrinho;
    private Scanner leitor;

    private Boolean rodando;

    public SistemaPagamento(String cpfCliente, Scanner leitor) {
        this.sessao = new Sessao(cpfCliente);        
        this.estoque = new Estoque();
        this.carrinho = new Carrinho();
        this.leitor = leitor;

        this.rodando = true;
    }

    public void rodar() {
        while (this.rodando) {
            this.exibirOpcoes();
            System.out.print("Escolha uma opção: ");
            String opcao = this.leitor.nextLine();
            System.out.print("\n");
            this.processarOpcao(opcao);
        }
    }

    public void processarOpcao(String opcao) {
        switch (opcao.toLowerCase()) {
            case "a":
                this.estoque.exibir();

                System.out.print("Digite o nome do produto: ");
                String nomeProduto = this.leitor.nextLine();
                System.out.print("Digite a quantidade de itens: ");
                Integer quantidadeSolicitada = Integer.parseInt(this.leitor.nextLine().trim());
                System.out.print("\n");

                Produto produto = this.estoque.retiraProduto(nomeProduto, quantidadeSolicitada);

                if (produto == null) {
                    System.out.println("Produto não encontrado.\n");
                } else {
                    this.carrinho.adicionar(produto, quantidadeSolicitada);
                }

                break;

            case "b":
                this.carrinho.exibir();
                this.carrinho.finalizarCompra();
                break;

            case "c":
                this.setRodando(false);
                break;

            default:
                System.out.println("Opção inválida.\n");
                break;
        }
    }

    public void exibirOpcoes() {
        System.out.println("a) Escolher Produto");
        System.out.println("b) Finalizar a Compra");
        System.out.println("c) Encerrar Sessão\n");
    }

    public void setRodando(Boolean rodando) {
        this.rodando = rodando;
    }
}
