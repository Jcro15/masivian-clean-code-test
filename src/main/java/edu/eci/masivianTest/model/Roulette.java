package edu.eci.masivianTest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("roulette")
public class Roulette {
    @Id
    private Long id;
    public Roulette() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
