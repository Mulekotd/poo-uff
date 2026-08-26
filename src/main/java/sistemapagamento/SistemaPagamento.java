package sistemapagamento;

import java.util.Scanner;

public class SistemaPagamento {
    private Sessao sessao;
    private Estoque estoque;
    private Carrinho carrinho;
    private Scanner leitor;

    private boolean rodando;

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
            String op = this.leitor.nextLine();
            this.processarOpcao(op);
        }
    }

    public void processarOpcao(String opcao) {
        switch (opcao) {
            case "a":
                this.estoque.exibir();
                break;

            case "b":
                this.carrinho.exibir();
                break;

            case "c":
                this.setRodando(false);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public void exibirOpcoes() {
        System.out.println("a) Escolher Produto");
        System.out.println("b) Finalizar a Compra");
        System.out.println("c) Encerrar Sessão");
    }

    public void setRodando(Boolean rodando) {
        this.rodando = rodando;
    }
}
