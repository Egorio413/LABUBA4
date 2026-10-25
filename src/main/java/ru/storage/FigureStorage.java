package ru.storage;

import ru.geometry2d.Figure;
import ru.exceptions.FigureFileFormatException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FigureStorage {
    // Читает список фигур. Пустой файл = пустой список.
    List<Figure> read(Path path) throws IOException, FigureFileFormatException;

    // Записывает список, заменяя старый файл.
    void write(Path path, List<Figure> figures) throws IOException;
}
