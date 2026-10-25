package ru.geometry3d;

import ru.geometry2d.Figure;
import ru.exceptions.InvalidFigureParametersException;
import java.io.Serializable;

public final class Cylinder implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) {
        if (base == null) {
            throw new InvalidFigureParametersException("Основание цилиндра не может быть null.");
        }
        if (Double.isNaN(height) || Double.isInfinite(height) || height <= 0) {
            throw new InvalidFigureParametersException("Высота цилиндра должна быть положительным конечным числом. Получено: " + height);
        }
        this.base = base;
        this.height = height;
    }

    public Figure getBase() { return base; }
    public double getHeight() { return height; }

    public double volume() {
        return base.area() * height; // Использование интерфейса Figure
    }

    @Override
    public String toString() {
        return String.format("Cylinder{base=%s, height=%.2f, volume=%.2f}", base.toString(), height, volume());
    }
}