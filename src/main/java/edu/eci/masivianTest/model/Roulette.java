package edu.eci.masivianTest.model;
import edu.eci.masivianTest.exceptions.RouletteRestrictionsException;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RedisHash("roulette")
public class Roulette {
    @Id
    private Long id;
    private State state;
    private List<Bet> bets;
    public Roulette() {
        this.setState(State.CLOSE);
        this.setBets(new ArrayList<>());
    }
    public List<Bet> getBets() {

        return bets;
    }
    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public State getState() {

        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void addBet(Bet bet) throws RouletteRestrictionsException {
        if(this.state.equals(State.CLOSE)){
            throw new RouletteRestrictionsException(RouletteRestrictionsException.CLOSED_ROULETTE);
        }
        bet.setId((long) this.bets.size());
        this.bets.add(bet);
    }
    public void openRoulette(){
        setState(State.OPEN);
        setBets(new ArrayList<>());
    }
    public void closeRoulette(){
        setState(State.CLOSE);
        int upperBound=37;
        Random random = new Random();
        int winnerNumber=random.nextInt(upperBound);
        for (Bet bet:getBets()) {
            bet.calculateResult(winnerNumber);
        }
    }
}