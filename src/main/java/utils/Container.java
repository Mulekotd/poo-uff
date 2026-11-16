package utils;

public class Container implements Model {
    private static int nextId = 0;
    private final int id;

    public Container() {
        this.id = nextId++;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
