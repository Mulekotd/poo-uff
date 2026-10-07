package canvas;

public class Rectangle extends Shape {
    private final float height;
    private final float width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw() {
        float area = this.height * this.width;
        System.out.printf("Área do Retângulo: %.2f m²\n", area);
    }

    public float getHeight() {
        return this.height;
    }

    public float getWidth() {
        return this.width;
    }
}
