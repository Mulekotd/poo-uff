package canvas;

public class Triangle extends Shape {
    private final float base;
    private final float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        float area = (base * height) / 2;
        System.out.printf("Área do Triangulo: %.2f m²\n", area);
    }

    public float getBase() {
        return this.base;
    }

    public float getHeight() {
        return this.height;
    }
}
