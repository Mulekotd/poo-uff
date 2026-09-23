package torneio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class ColecaoCompetidores {
    private List<Competidor> competidores;

    public ColecaoCompetidores() {
        this.competidores = new ArrayList<>();
    }

    public int tam() { return this.competidores.size(); }

    public Competidor get(int i) { return this.competidores.get(i); }

    public void add(Competidor competidor) { this.competidores.add(competidor); }

    public void carregar(String nomeArq) {
        File arquivo = new File(nomeArq);

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] content = line.split("\\s+");

                String nome = content[0].trim();
                String treinador = content[1].trim();
                String pais = content[2].trim();

                Competidor competidor = new Competidor(nome, treinador, pais);
                this.add(competidor);
            }

            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
