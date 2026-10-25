package ru.geometry2d;

import ru.exceptions.InvalidFigureParametersException;

public final class Circle implements Figure {
    private static final long serialVersionUID = 1L; // Для сериализации
    private final double radius;

    public Circle(double radius) {
        if (Double.isNaN(radius) || Double.isInfinite(radius) || radius <= 0) {
            throw new InvalidFigureParametersException("Радиус должен быть положительным конечным числом. Получено: " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }

    @Override
    public double perimeter() { return 2 * Math.PI * radius; }

    @Override
    public String toString() {
        return String.format("Circle{r=%.2f, area=%.2f, perimeter=%.2f}", radius, area(), perimeter());
    }
}