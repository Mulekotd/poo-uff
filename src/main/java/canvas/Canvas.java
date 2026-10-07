package canvas;

import java.util.List;

public class Canvas {    
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }
}
