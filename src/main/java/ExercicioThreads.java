
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.Fibonacci;
import utils.LineAccumulator;
import utils.Matrix;

public class ExercicioThreads {
    public static void questaoFibonacci(Scanner scanner) {
        System.out.println("=== Questão de Fibonacci com duas Threads ===");

        Integer n = scanner.nextInt();
        long[] resultados = new long[n + 1];

        Thread worker0 = new Thread(new Fibonacci(0, n, resultados)); // Termos pares
        Thread worker1 = new Thread(new Fibonacci(1, n, resultados)); // Termos ímpares
        
        worker0.start();
        worker1.start();

        try {
            worker0.join();
            worker1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("A execução foi interrompida.");
        }

        for (int i = 0; i <= n; i++) {
            System.out.printf("F(%d) = %d%n", i, resultados[i]);
        }
    }

    public static void questaoMatriz(Scanner scanner) {
        System.out.println("\n=== Questão de Matriz mxn ===");

        Integer m = scanner.nextInt();
        Integer n = scanner.nextInt();
        Matrix matrix = new Matrix(m, n);

        // Preenche a matriz
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Double value = scanner.nextDouble();
                matrix.preencher(value, i, j);
            }
        }

        List<Thread> threads = new ArrayList<>(m);
        double[] sums = new double[m];

        for (int i = 0; i < m; i++) {
            LineAccumulator accumulator = new LineAccumulator(i, sums, matrix);
            Thread worker = new Thread(accumulator);
            worker.start(); // inicia a thread
            threads.add(worker);
        }

        try {
            for (Thread worker : threads) { worker.join(); }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("A execução foi interrompida.");
        }

        // Imprime soma das linhas
        for (int i = 0; i < m; i++) {
            System.out.printf("Soma da Linha (%d): %f\n", i, sums[i]);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            questaoFibonacci(scanner);
            questaoMatriz(scanner);
        }
    }
}
