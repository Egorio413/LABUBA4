package ru.university.lab4.geometry2d;

import ru.university.lab4.exceptions.InvalidFigureParametersException;

public final class Rectangle implements Figure {
    private static final long serialVersionUID = 1L;
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        checkSide(width, "Ширина");
        checkSide(height, "Высота");
        this.width = width;
        this.height = height;
    }

    private void checkSide(double side, String name) {
        if (Double.isNaN(side) || Double.isInfinite(side) || side <= 0) {
            throw new InvalidFigureParametersException(name + " должна быть положительным конечным числом. Получено: " + side);
        }
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    @Override
    public double area() { return width * height; }

    @Override
    public double perimeter() { return 2 * (width + height); }

    @Override
    public String toString() {
        return String.format("Rectangle{w=%.2f, h=%.2f, area=%.2f, perimeter=%.2f}", width, height, area(), perimeter());
    }
}
