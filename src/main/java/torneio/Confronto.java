package torneio;

import java.util.Calendar;

public class Confronto {
    private final static int MAX_PONTOS = 10;

    private Competidor[] competidores;
    private Calendar date;
    private String local;
    private Competidor vencedor;
    private Competidor eliminado;
    private int[] placar;

    public Confronto(Competidor c1, Competidor c2, Calendar date, String local) {
        this.competidores = new Competidor[2];
        this.placar = new int[2];
        
        this.competidores[0] = c1;
        this.competidores[1] = c2;

        this.date = (Calendar) date.clone();
        this.local = local;
    }
    
    int simularPontos() {
        return (int)(Math.random() * (double)MAX_PONTOS);
    }

    public void simular() {
        placar[0] = simularPontos();
        placar[1] = simularPontos();

        if (placar[0] > placar[1]) {
            vencedor = competidores[0];
            eliminado = competidores[1];
        } else {
            vencedor = competidores[1];
            eliminado = competidores[0];
        }
    }

    public Competidor getCompetidor(int indice) {
        return competidores[indice];
    }

    public Calendar getData() {
        return (Calendar) date.clone();
    }

    public String getLocal() {
        return local;
    }

    public Competidor getVencedor() {
        return vencedor;
    }

    public Competidor getEliminado() {
        return eliminado;
    }

    public int getPlacar(int indice) {
        return placar[indice];
    }
}
