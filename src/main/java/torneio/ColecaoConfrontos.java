package torneio;

import java.util.ArrayList;
import java.util.List;

public class ColecaoConfrontos {
    private List<Confronto> confrontos;

    public ColecaoConfrontos() {
        this.confrontos = new ArrayList<>();
    }

    public int tam() { return this.confrontos.size(); }

    public Confronto get(int i) { return this.confrontos.get(i); }

    public void add(Confronto confronto) { this.confrontos.add(confronto); }
}
