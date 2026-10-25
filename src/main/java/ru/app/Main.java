package ru.app;

import ru.geometry2d.Figure;
import ru.geometry3d.Cylinder;
import ru.storage.BinaryFigureStorage;
import ru.storage.FigureStorage;
import ru.storage.TextFigureStorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path textPath = Path.of("data/figures.txt");
        Path binPath = Path.of("data/figures.bin");

        FigureStorage textStorage = new TextFigureStorage();
        FigureStorage binaryStorage = new BinaryFigureStorage();

        try {
            // 2. Чтение через текстовую реализацию
            System.out.println("Чтение из текстового файла: " + textPath.toAbsolutePath());
            List<Figure> figures = textStorage.read(textPath);

            if (figures.isEmpty()) {
                System.out.println("Список фигур пуст.");
                return;
            }

            // 3. Вывод параметров
            System.out.println("\n--- Прочитанные фигуры ---");
            for (Figure f : figures) {
                System.out.println(f.toString());
            }

            // 4. Случайный объект как основание цилиндра
            Random random = new Random();
            Figure base = figures.get(random.nextInt(figures.size()));

            System.out.print("\nВведите высоту цилиндра: ");
            double height = scanner.nextDouble();

            Cylinder cylinder = new Cylinder(base, height);
            System.out.println("\n--- Цилиндр ---");
            System.out.println(cylinder.toString());

            // 5. Сохранение через бинарную реализацию
            binaryStorage.write(binPath, figures);
            System.out.println("\nУспешно сохранено в бинарный файл: " + binPath.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}