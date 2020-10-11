package edu.eci.masivianTest.model;

import edu.eci.masivianTest.exceptions.BetAttributesException;

public class ColourBet extends Bet {
    private Colour colour;
    public ColourBet(Long amount, Colour colour) throws BetAttributesException {
        super(amount);
        setColour(colour);
    }
    public Colour getColour() {
        return colour;
    }
    public void setColour(Colour colour) throws BetAttributesException {
        if(colour == null){
            throw new BetAttributesException(BetAttributesException.NULL_COLOUR);
        }
        this.colour = colour;
    }
    @Override
    public void calculateResult(int winnerNumber) {
        if((colour.equals(Colour.Black)&&winnerNumber%2==1)||(colour.equals(Colour.Red)&&winnerNumber%2==0)){
            super.setResult(super.getAmount()*1.8);
        }
    }
}
