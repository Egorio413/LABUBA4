package ru.geometry3d;
import org.junit.jupiter.api.Test;
import ru.geometry2d.Circle;
import ru.exceptions.InvalidFigureParametersException;
import static org.junit.jupiter.api.Assertions.*;

public class CylinderTest {
    @Test
    void testVolume() {
        Circle circle = new Circle(2.0);
        Cylinder cyl = new Cylinder(circle, 5.0);
        assertEquals(circle.area() * 5.0, cyl.volume(), 1e-9);
    }

    @Test
    void testNullBase() {
        assertThrows(InvalidFigureParametersException.class, () -> new Cylinder(null, 5.0));
    }
}