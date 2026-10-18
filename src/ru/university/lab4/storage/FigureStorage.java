package ru.university.lab4.storage;

import ru.university.lab4.geometry2d.Figure;
import ru.university.lab4.exceptions.FigureFileFormatException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FigureStorage {
    // Читает список фигур. Пустой файл = пустой список.
    List<Figure> read(Path path) throws IOException, FigureFileFormatException;

    // Записывает список, заменяя старый файл.
    void write(Path path, List<Figure> figures) throws IOException;
}
