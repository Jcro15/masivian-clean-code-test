package edu.eci.masivianTest.services.impl;

import edu.eci.masivianTest.exceptions.RouletteException;
import edu.eci.masivianTest.model.Roulette;
import edu.eci.masivianTest.model.State;
import edu.eci.masivianTest.persistence.RouletteRepository;
import edu.eci.masivianTest.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteServicesImpl implements RouletteServices {
    @Autowired
    private RouletteRepository rouletteRepository;
    @Override
    public Long createRoulette() {
        Roulette roulette = new Roulette();
        rouletteRepository.save(roulette);

        return roulette.getId();
    }
    @Override
    public void openRoulette(Long rouletteId)throws RouletteException {
        Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(()->new RouletteException(RouletteException.NOT_FOUND));
        roulette.setState(State.OPEN);
        rouletteRepository.save(roulette);
    }
}
