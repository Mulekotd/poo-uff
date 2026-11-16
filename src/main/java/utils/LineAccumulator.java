package utils;

public class LineAccumulator implements Runnable {
    private final int line;
    private final double[] sums;
    private final Matrix matrix;

    public LineAccumulator(int line, double[] sums, Matrix matrix) {
        this.line = line;
        this.sums = sums;
        this.matrix = matrix;
    }

    // Getters

    public int getLine() { return this.line; }
    public double[] getSums() { return this.sums; }
    public Matrix getMatrix() { return this.matrix; }

    @Override
    public void run() {
        double[][] M = this.matrix.getValue();
        double sum = 0;

        for (int j = 0; j < this.matrix.getN(); j++) {
            sum += M[this.line][j];
        }

        this.sums[this.line] = sum;
    }
}
