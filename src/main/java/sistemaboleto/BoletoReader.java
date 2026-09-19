package sistemaboleto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BoletoReader implements IBoletoFileStream {
    private final File file;

    // Readers
    private FileReader fr;
    private BufferedReader br;

    public BoletoReader(File file) {
        this.file = file;
    }

    public Boleto read() throws Exception {
        this.validateReadableFile();

        this.openStream();

        try {
            br.readLine();

            return this.readNextBoleto();
        } finally {
            this.closeStream();
        }
    }

    public ArrayList<Boleto> readLines() throws Exception {
        this.validateReadableFile();

        ArrayList<Boleto> boletos = new ArrayList<>();

        this.openStream();

        try {
            br.readLine();

            Boleto boleto;

            while ((boleto = readNextBoleto()) != null) {
                boletos.add(boleto);
            }
        } finally {
            this.closeStream();
        }

        return boletos;
    }

    private Boleto readNextBoleto() throws Exception {
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                return this.parseBoleto(line);
            }
        }

        return null;
    }

    private Boleto parseBoleto(String line) throws BoletoException {
        String[] fields = line.split(";", -1);

        if (fields.length != 4) {
            throw new BoletoException("Linha inválida: " + line);
        }

        String id = fields[0].trim();
        String tipo = fields[1].trim();
        String cliente = fields[2].trim();
        Float preco = Float.parseFloat(fields[3].trim());

        return new Boleto(id, tipo, cliente, preco);
    }

    private void validateReadableFile() throws BoletoException {
        if (!this.file.isFile() || !this.file.canRead()) {
            throw new BoletoException("Não é possível ler o arquivo.");
        }
    }

    @Override
    public void openStream() throws IOException {
        this.closeStream();
        this.fr = new FileReader(this.file);
        this.br = new BufferedReader(this.fr);
    }

    @Override
    public void closeStream() throws IOException {
        if (this.br != null) {
            br.close();
            br = null;
            fr = null;
        } else if (this.fr != null) {
            fr.close();
            fr = null;
        }
    }
}
