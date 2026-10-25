package ru.geometry2d;

import org.junit.jupiter.api.Test;
import ru.exceptions.InvalidFigureParametersException;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    void testAreaAndPerimeter() {
        Rectangle rect = new Rectangle(3.0, 4.0);
        assertEquals(12.0, rect.area(), 1e-9);
        assertEquals(14.0, rect.perimeter(), 1e-9);
    }

    @Test
    void testInvalidParameters() {
        assertThrows(InvalidFigureParametersException.class, () -> new Rectangle(0, 5));
    }
}