package torneio;

import java.util.ArrayList;
import java.util.List;

public class ColecaoRodadas {
    private List<Rodada> rodadas;

    public ColecaoRodadas() {
        this.rodadas = new ArrayList<>();
    }

    public int tam() { return this.rodadas.size(); }

    public Rodada get(int i) { return this.rodadas.get(i); }

    public void add(Rodada rodada) { this.rodadas.add(rodada); }
}
