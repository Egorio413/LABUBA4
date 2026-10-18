package ru.university.lab4.geometry2d;

import java.io.Serializable;

// Интерфейс наследует Serializable для задания 5
public interface Figure extends Serializable {
    double area();
    double perimeter();
}