package utils;

public class Fibonacci implements Runnable {
    private final int inicio;
    private final int fim;
    private final long[] resultados;

    public Fibonacci(int inicio, int fim, long[] resultados) {
        this.inicio = inicio;
        this.fim = fim;
        this.resultados = resultados;
    }

    private long calcular(int n) {
        if (n <= 1) {
            return n;
        }

        long anterior = 0;
        long atual = 1;

        for (int i = 2; i <= n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }

    @Override
    public void run() {
        for (int i = this.inicio; i <= this.fim; i += 2) {
            this.resultados[i] = this.calcular(i);
        }
    }
}
