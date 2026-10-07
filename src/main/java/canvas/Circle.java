package canvas;

public class Circle extends Shape {
    private final float radius;
    
    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        double area = Math.PI * radius * radius;
        System.out.printf("Área do Círculo: %.2f m²\n", area);
    }

    public float getRadius() {
        return this.radius;
    }
}
