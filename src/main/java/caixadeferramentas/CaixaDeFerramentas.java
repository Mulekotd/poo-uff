package caixadeferramentas;

import java.util.ArrayList;
import java.util.List;

public class CaixaDeFerramentas {
    private final List<ItemEstoque<?>> ferramentas;

    public CaixaDeFerramentas() {
        this.ferramentas = new ArrayList<>();
    }

    public void adicionar(ItemEstoque<?> ferramenta) {
        this.ferramentas.add(ferramenta);
    }

    public float calcularSubtotal() {
        float total = 0.0f;

        for (ItemEstoque<?> ferramenta : this.ferramentas) {
            total += ferramenta.getProduto().getPreco() * ferramenta.getQuantidade();
        }

        return total;
    }

    public void imprimir() {
        for (ItemEstoque<?> ferramenta : this.ferramentas) {
            System.out.println(ferramenta.toString());
        }
    }
}
