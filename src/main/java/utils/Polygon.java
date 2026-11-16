package utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Polygon {
    private final List<Point> points;

    public Polygon() {
        this.points = new LinkedList<>();
    }

    // Methods

    @Override
    public String toString() {
        if (this.points.isEmpty()) {
            return "POLYGON EMPTY";
        }

        StringJoiner coordinates = new StringJoiner(", ");

        for (Point point : this.points) {
            coordinates.add(point.toCoordinateString());
        }

        Point first = this.points.getFirst();
        Point last = this.points.getLast();

        boolean isClosed =
            first.getX() == last.getX() &&
            first.getY() == last.getY();

        if (!isClosed) {
            coordinates.add(first.toCoordinateString());
        }

        return "POLYGON ((" + coordinates + "))";
    }

    public Point get(int index) {
        return this.points.get(index);
    }

    public void add(Point point) {
        this.points.add(point);
    }

    public void add(List<Point> points) {
        this.points.addAll(points);
    }

    // Getters

    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
    }
}
