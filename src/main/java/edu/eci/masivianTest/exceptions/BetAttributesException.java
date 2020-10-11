package edu.eci.masivianTest.exceptions;

public class BetAttributesException extends Exception {
    public static final String INVALID_AMOUNT="El valor de la apuesta debe ser positivo y menor que 10000 dolares";
    public static final String INVALID_NUMBER="El numero de la apuesta debe estar entre 0 y 36";
    public static final String NULL_NUMBER="El numero de la apuesta no puede ser nulo";
    public static final String NULL_COLOUR="El color apostado no puede ser nulo";
    public static final String NULL_AMOUNT="El valor apostado no puede ser nulo";
    public BetAttributesException() {
        super();
    }
    public BetAttributesException(String message) {
        super(message);
    }
}
