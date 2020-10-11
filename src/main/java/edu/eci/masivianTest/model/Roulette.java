package edu.eci.masivianTest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("roulette")
public class Roulette {
    @Id
    private Long id;
    private State state;
    public Roulette() {
        this.setState(State.CLOSE);
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
}
