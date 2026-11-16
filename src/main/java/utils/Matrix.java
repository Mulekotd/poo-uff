package utils;

public class Matrix {
    private final int m; // linhas
    private final int n; // colunas
    private final double[][] matrix;
    
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.matrix = new double[m][n];
    }

    public void preencher(double value, int i, int j) { matrix[i][j] = value; }

    // Getters

    public int getM() { return this.m; }
    public int getN() { return this.n; }
    public double[][] getValue() { return this.matrix; }
}
