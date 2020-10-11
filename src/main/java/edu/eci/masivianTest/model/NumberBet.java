package edu.eci.masivianTest.model;

import edu.eci.masivianTest.exceptions.BetAttributesException;

public class NumberBet extends Bet{
    private Integer number;
    public NumberBet(Integer number,Long amount) throws BetAttributesException {
        super(amount);
        setNumber(number);
    }
    public Integer getNumber() {

        return number;
    }
    public void setNumber(Integer number) throws BetAttributesException {
        if(number==null){
            throw new BetAttributesException(BetAttributesException.NULL_NUMBER);
        }
        else if(number<0 || number>36){
            throw new BetAttributesException(BetAttributesException.INVALID_NUMBER);
        }
        this.number = number;
    }
    @Override
    public void calculateResult(int winnerNumber) {
    }
}
