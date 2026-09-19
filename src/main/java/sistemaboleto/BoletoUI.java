package sistemaboleto;

import java.util.Locale;

public class BoletoUI {
    private static final String HORIZONTAL_BAR = "===================================================================";
    private static final String TITLE = "SISTEMA DE BOLETOS";

    public void showTitle() {
        showTitle(TITLE);
    }

    public void showTitle(String title) {
        System.out.println(HORIZONTAL_BAR);
        System.out.printf("%36s%n", title);
        System.out.println(HORIZONTAL_BAR);
    }

    public void showOptions() {
        System.out.println("Ações: ler (r), escrever (w), escrever e concatenar (w+), sair (q).");
        System.out.println(HORIZONTAL_BAR);
    }

    public void showWritePrompt(boolean append) {
        System.out.println(HORIZONTAL_BAR);

        if (append) {
            System.out.println("Digite o conteúdo que será concatenado ao arquivo:");
        } else {
            System.out.println("Digite o conteúdo que substituirá o arquivo:");
        }
    }

    public void showBoleto(Boleto boleto) {
        System.out.println(HORIZONTAL_BAR);
        System.out.printf("%36s%n", "BOLETO");
        System.out.println(HORIZONTAL_BAR);

        System.out.printf("%-10s: %s%n", "Id", boleto.getId());
        System.out.printf("%-10s: %s%n", "Tipo", boleto.getTipo());
        System.out.printf("%-10s: %s%n", "Cliente", boleto.getCliente());
        System.out.printf(
            Locale.forLanguageTag("pt-BR"),
            "%-10s: R$ %,.2f%n",
            "Subtotal", boleto.getSubtotal()
        );

        System.out.println(HORIZONTAL_BAR);
    }

    public void showMessage(String message) {
        System.out.println(HORIZONTAL_BAR);
        System.out.println(message);
        System.out.println(HORIZONTAL_BAR);
    }
}
