package ru.university.lab4.storage;

import ru.university.lab4.geometry2d.Figure;
import ru.university.lab4.exceptions.FigureFileFormatException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BinaryFigureStorage implements FigureStorage {

    @Override
    public List<Figure> read(Path path) throws IOException, FigureFileFormatException {
        // try-with-resources для ObjectInputStream
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Object obj = ois.readObject();
            if (!(obj instanceof List<?>)) {
                throw new FigureFileFormatException("Файл не содержит список фигур");
            }
            // Приведение типов
            return (List<Figure>) obj;
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new FigureFileFormatException("Не удалось прочитать фигуры из бинарного файла", e);
        }
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        // try-with-resources для ObjectOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(figures);
        }
    }
}