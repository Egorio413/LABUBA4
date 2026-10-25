package ru.exceptions;

// Непроверяемое (RuntimeException) по условию
public class InvalidFigureParametersException extends RuntimeException {
    public InvalidFigureParametersException(String message) {
        super(message);
    }
}
