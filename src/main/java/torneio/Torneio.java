package torneio;

import java.util.Calendar;

public class Torneio {
    private ColecaoCompetidores competidores;
    private ColecaoLocais locais;
    private ColecaoRodadas rodadas;
    private Calendar dataInicio;
    private Calendar dataFinal;

    public Torneio(ColecaoCompetidores competidores, ColecaoLocais locais, Calendar data){
        this.competidores = competidores;
        this.locais = locais;
        this.rodadas = new ColecaoRodadas();
        this.dataInicio = (Calendar) data.clone();
        this.dataFinal = calcularDataFinal(this.dataInicio);
    }

    Calendar calcularDataFinal(Calendar dataInicio) {
        int numDias = (int)(Math.log(competidores.tam()) / Math.log(2));
        Calendar dataFinal = (Calendar) dataInicio.clone();
        dataFinal.add(Calendar.DAY_OF_MONTH, (numDias - 1) * 2);

        return dataFinal;
    }

    public void simular() {
        ColecaoCompetidores participantes = competidores;
        Calendar dataRodada = (Calendar) dataInicio.clone();

        while (participantes.tam() > 1) {
            Rodada rodada = new Rodada(participantes, locais, dataRodada);
            rodada.simularConfrontos();
            rodadas.add(rodada);
            participantes = rodada.getVencedores();
            dataRodada.add(Calendar.DAY_OF_MONTH, 2);
        }

        dataFinal = calcularDataFinal(dataInicio);
    }

    public ColecaoRodadas getRodadas() {
        return rodadas;
    }

    public Calendar getDataInicio() {
        return (Calendar) dataInicio.clone();
    }

    public Calendar getDataFinal() {
        return (Calendar) dataFinal.clone();
    }

    private static boolean quantidadeValida(int quantidade) {
        return quantidade >= 2 && quantidade <= 128
            && (quantidade & (quantidade - 1)) == 0;
    }
}
