package edu.eci.masivianTest.exceptions;
public class RouletteNotFoundException extends Exception{
    public static final String NOT_FOUND="La ruleta no se encuentra registrada";
    public RouletteNotFoundException() {
        super();
    }
    public RouletteNotFoundException(String message) {
        super(message);
    }
}
