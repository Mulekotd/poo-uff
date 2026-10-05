package caixadeferramentas;

public class FerramentaEletrica extends Produto {
    private final Float voltagem;

    public FerramentaEletrica(String nome, String marca, Float preco, Float voltagem) {
        super(nome, marca, preco);
        this.voltagem = voltagem;
    }

    public Float getVoltagem() {
        return this.voltagem;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Voltagem: " + this.getVoltagem() + "V";
    }
}
