package edu.eci.masivianTest.services.impl;

import edu.eci.masivianTest.model.Roulette;
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
        Roulette roulette=new Roulette();
        rouletteRepository.save(roulette);
        return roulette.getId();
    }
}
