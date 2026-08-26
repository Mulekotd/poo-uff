package sistemapagamento;

public class Sessao {
    private static int nextId = 0;

    private final Integer id;
    private String cpf;

    public Sessao(String cpf) {
        this.id = nextId++;
        this.cpf = cpf;
    }
}
