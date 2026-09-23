package torneio;

import java.util.ArrayList;
import java.util.List;

public class ColecaoLocais {
    private List<String> locais;

    public ColecaoLocais() {
        this.locais = new ArrayList<>();
    }

    public int tam() { return this.locais.size(); }

    public String get(int i) { return this.locais.get(i); }

    public void add(String local) { this.locais.add(local); }
}
