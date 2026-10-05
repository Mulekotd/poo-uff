import caixadeferramentas.CaixaDeFerramentas;
import caixadeferramentas.FerramentaEletrica;
import caixadeferramentas.FerramentaManual;
import caixadeferramentas.Funcao;
import caixadeferramentas.ItemEstoque;

public class ProgramaGenericos {
    public static void main(String[] args) {
        FerramentaEletrica furadeira = new FerramentaEletrica("Furadeira Elétrica", "Bosch", 237.21f, 4.5f);
        FerramentaManual martelo = new FerramentaManual("Martelo de Unha", "Tramontina", 54.05f, Funcao.FIXACAO);
        FerramentaManual alicate = new FerramentaManual("Alicate de Bico", "Gedore", 109.70f, Funcao.AJUSTE);

        CaixaDeFerramentas caixa = new CaixaDeFerramentas();
        caixa.adicionar(new ItemEstoque<>(furadeira, 1));
        caixa.adicionar(new ItemEstoque<>(martelo, 2));
        caixa.adicionar(new ItemEstoque<>(alicate, 1));

        System.out.println("================== Ferramentas na Caixa ==================");
        caixa.imprimir();
        System.out.println("==========================================================");
        System.out.println("Subtotal: R$ " + caixa.calcularSubtotal());
    }
}
