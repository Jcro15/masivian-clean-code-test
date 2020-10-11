package edu.eci.masivianTest.exceptions;

public class RouletteRestrictionsException extends Exception{
        public static final String CLOSED_ROULETTE="No se pueden añadir apuestas a ruletas cerradas";
        public RouletteRestrictionsException() {
            super();
        }
        public RouletteRestrictionsException(String message) {
            super(message);
        }
}
