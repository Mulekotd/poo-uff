package sistemapagamento;

public class Sessao {
    private static int nextId = 0;

    private final Integer id;
    private final String cpf;

    public Sessao(String cpf) {
        this.id = nextId++;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }
}
