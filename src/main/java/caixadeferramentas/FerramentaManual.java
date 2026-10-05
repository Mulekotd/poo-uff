package caixadeferramentas;

public class FerramentaManual extends Descritivo {
    private final Funcao funcao;

    public FerramentaManual(String nome, String marca, Float preco, Funcao funcao) {
        super(nome, marca, preco);
        this.funcao = funcao;
    }

    public Funcao getFuncao() {
        return this.funcao;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Função: " + this.getFuncao();
    }
}
