package edu.eci.masivianTest.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.eci.masivianTest.exceptions.BetAttributesException;
import org.springframework.data.redis.core.index.Indexed;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ColourBet.class, name = "colour"),
        @JsonSubTypes.Type(value = NumberBet.class, name = "number")
})
public abstract class Bet {
    @Indexed
    private Long id;
    private Long amount;
    private Long result;
    private Long userId;
    public Bet(Long amount) throws BetAttributesException {
        setAmount(amount);
    }
    public abstract void calculateResult(int winnerNumber);
    public Long getUserId() {

        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAmount() {

        return amount;
    }
    public void setAmount(Long amount) throws BetAttributesException {
        if(amount==null){
            throw new BetAttributesException(BetAttributesException.NULL_AMOUNT);
        }
        else if(amount >10000|| amount <0){
            throw new BetAttributesException(BetAttributesException.INVALID_AMOUNT);
        }
        this.amount = amount;
    }
    public Long getResult() {

        return result;
    }
    public void setResult(Long result) {
        this.result = result;
    }
}
