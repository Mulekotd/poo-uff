package sistemaboleto;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBoletoIO {
    private final BoletoUI     ui;
    private final BoletoReader br;
    private final BoletoWriter bw;
    private final Scanner scanner;

    private boolean isActive;

    public SistemaBoletoIO(BoletoReader br, BoletoWriter bw, Scanner scanner) {
        this.ui = new BoletoUI();

        this.br = br;
        this.bw = bw;
        this.scanner = scanner;

        this.isActive = true;
    }

    public void listen() throws Exception {
        ui.showTitle();
        ui.showOptions();

        while (this.isActive && scanner.hasNextLine()) {
            this.process();
        }
    }

    public void process() throws Exception {
        String mode = scanner.nextLine().trim().toLowerCase();

        if (mode.isEmpty()) {
            return;
        }

        switch (mode) {
            case "q":
                this.setActive(false);
                break;
            case "w":
                ui.showWritePrompt(false);
                bw.write(readContent(), false);
                ui.showMessage("Arquivo sobrescrito com sucesso.");
                break;
            case "w+":
                ui.showWritePrompt(true);
                bw.write(readContent(), true);
                ui.showMessage("Conteúdo concatenado com sucesso.");
                break;
            case "r":
                ArrayList<Boleto> boletos = br.readLines();

                if (boletos.isEmpty()) {
                    ui.showMessage("Nenhum boleto encontrado.");
                } else {
                    for (Boleto boleto : boletos) {
                        ui.showBoleto(boleto);
                    }
                }

                break;
            default:
                ui.showMessage("Ação inválida. Use r, w, w+ ou q.");
                break;
        }
    }

    private String readContent() throws BoletoException {
        if (!scanner.hasNextLine()) {
            throw new BoletoException("Não foi informado conteúdo para escrita.");
        }

        return scanner.nextLine();
    }

    // Getters
    public boolean isActive() {
        return this.isActive;
    }

    // Settters
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
