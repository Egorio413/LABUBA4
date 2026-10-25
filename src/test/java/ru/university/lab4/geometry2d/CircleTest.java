package ru.geometry2d;

import org.junit.jupiter.api.Test;
import ru.exceptions.InvalidFigureParametersException; // <-- убрали university.lab4
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {
    @Test
    void testAreaAndPerimeter() {
        Circle circle = new Circle(5.0);
        assertEquals(Math.PI * 25, circle.area(), 1e-9);
        assertEquals(2 * Math.PI * 5, circle.perimeter(), 1e-9);
    }

    @Test
    void testInvalidParameters() {
        assertThrows(InvalidFigureParametersException.class, () -> new Circle(0));
        assertThrows(InvalidFigureParametersException.class, () -> new Circle(-5));
    }
}