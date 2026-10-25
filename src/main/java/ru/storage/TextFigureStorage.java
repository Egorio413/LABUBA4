package ru.storage;

import ru.geometry2d.Circle;
import ru.geometry2d.Figure;
import ru.geometry2d.Rectangle;
import ru.exceptions.FigureFileFormatException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextFigureStorage implements FigureStorage {

    @Override
    public List<Figure> read(Path path) throws IOException, FigureFileFormatException {
        List<Figure> figures = new ArrayList<>();
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        int lineNumber = 1;
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) {
                lineNumber++;
                continue;
            }

            String[] parts = line.split(";");
            try {
                String type = parts[0].trim();
                if (type.equalsIgnoreCase("Circle")) {
                    if (parts.length != 2) throw new IllegalArgumentException("Ожидалось 2 параметра");
                    double r = Double.parseDouble(parts[1].trim());
                    figures.add(new Circle(r));
                } else if (type.equalsIgnoreCase("Rectangle")) {
                    if (parts.length != 3) throw new IllegalArgumentException("Ожидалось 3 параметра");
                    double w = Double.parseDouble(parts[1].trim());
                    double h = Double.parseDouble(parts[2].trim());
                    figures.add(new Rectangle(w, h));
                } else {
                    throw new IllegalArgumentException("Неизвестный тип фигуры: " + type);
                }
            } catch (Exception e) {
                // По условию: отбрасываем некорректную строку, но сообщаем
                throw new FigureFileFormatException("Ошибка в строке " + lineNumber + ": " + e.getMessage(), e);
            }
            lineNumber++;
        }
        return figures;
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Figure f : figures) {
                if (f instanceof Circle c) {
                    writer.write("Circle;" + c.getRadius());
                } else if (f instanceof Rectangle r) {
                    writer.write("Rectangle;" + r.getWidth() + ";" + r.getHeight());
                }
                writer.newLine();
            }
        }
    }
}