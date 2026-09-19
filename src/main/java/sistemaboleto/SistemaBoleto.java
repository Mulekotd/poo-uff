package sistemaboleto;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SistemaBoleto {
    private final List<Boleto> boletos;

    private final BoletoReader    br;
    private final BoletoWriter    bw;
    private final SistemaBoletoIO io;
    
    public SistemaBoleto(String fileName) throws Exception {
        this(fileName, new Scanner(System.in));
    }

    public SistemaBoleto(String fileName, Scanner scanner) throws Exception {
        File tmpFile = new File(fileName);

        if (!tmpFile.isFile()) {
            throw new BoletoException("Por favor, insira um arquivo válido.");
        }

        this.boletos = new ArrayList<>();

        this.br = new BoletoReader(tmpFile);
        this.bw = new BoletoWriter(tmpFile);
        this.io = new SistemaBoletoIO(br, bw, scanner);
    }

    public void close()  {
        try {
            br.closeStream();
            bw.closeStream();
        } catch (IOException exception) {}
    }

    public void listen() throws Exception {
        io.listen();
    }

    public void add(Boleto boleto) {
        if (boleto != null) {
            boletos.add(boleto);
        }
    }

    public void loadBoletos() throws Exception {
        boletos.clear();

        boletos.addAll(br.readLines());
    }

    // Getters
    public List<Boleto> getBoletos() {
        return Collections.unmodifiableList(this.boletos);
    }

    public SistemaBoletoIO getIO() {
        return this.io;
    }
}
