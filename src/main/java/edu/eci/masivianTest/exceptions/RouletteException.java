package edu.eci.masivianTest.exceptions;

public class RouletteException extends Exception{
    public static final String NOT_FOUND="La ruleta no se encuentra registrada";
    public RouletteException() {
        super();
    }
    public RouletteException(String message) {
        super(message);
    }
}
