package ru.university.lab4.exceptions;

// Непроверяемое (RuntimeException) по условию
public class InvalidFigureParametersException extends RuntimeException {
    public InvalidFigureParametersException(String message) {
        super(message);
    }
}
