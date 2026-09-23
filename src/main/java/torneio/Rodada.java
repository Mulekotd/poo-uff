package torneio;

import java.util.Calendar;

public class Rodada {
    public static String[] nomesRodadas = { "FINAIS", "SEMI-FINAIS", "QUARTAS", "OITAVAS", "16", "32", "64" };

    private String nome;
    private ColecaoConfrontos confrontos;
    private ColecaoCompetidores competidores;
    private ColecaoLocais locais;
    private Calendar data;

    public Rodada(ColecaoCompetidores competidores, ColecaoLocais locais, Calendar data) {
        int ord = (int)(Math.log(competidores.tam()) / Math.log(2)) - 1;

        this.nome = nomesRodadas[ord];
        this.data = data;
        this.competidores = competidores;
        this.confrontos = new ColecaoConfrontos();
        this.locais = locais;

        this.geraConfrontos();
    }

    public void geraConfrontos() {
        for (int i = 0; i < competidores.tam(); i += 2) {
            Competidor c1 = competidores.get(i);
            Competidor c2 = competidores.get(i + 1);
            String local = locais.get((i / 2) % locais.tam());

            confrontos.add(new Confronto(c1, c2, data, local));
        }
    }

    public void simularConfrontos() {
        for (int i = 0; i < confrontos.tam(); i++) {
            confrontos.get(i).simular();
        }
    }

    public ColecaoCompetidores getVencedores() {
        ColecaoCompetidores vencedores = new ColecaoCompetidores();

        for (int i = 0; i < this.confrontos.tam(); i++) {
            Competidor vencedor = confrontos.get(i).getVencedor();
            vencedores.add(vencedor);
        }

        return vencedores;
    }

    public String getNome() {
        return nome;
    }

    public ColecaoConfrontos getConfrontos() {
        return confrontos;
    }

    public Calendar getData() {
        return (Calendar) data.clone();
    }
}
