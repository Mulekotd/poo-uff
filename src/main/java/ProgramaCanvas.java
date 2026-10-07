import canvas.Canvas;
import canvas.Circle;
import canvas.Rectangle;
import canvas.Shape;
import canvas.Triangle;
import java.util.ArrayList;
import java.util.List;

public class ProgramaCanvas {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle c0 = new Circle(2.5f);
        Triangle t0 = new Triangle(4.f, 3.9f);
        Rectangle r0 = new Rectangle(6.f, 7.5f);

        shapes.add(c0);
        shapes.add(t0);
        shapes.add(r0);

        Canvas canva = new Canvas();
        canva.drawAll(shapes);
    }
}
