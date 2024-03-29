package edu.eci.masivianTest.services.impl;
import edu.eci.masivianTest.exceptions.RouletteNotFoundException;
import edu.eci.masivianTest.exceptions.RouletteRestrictionsException;
import edu.eci.masivianTest.model.Bet;
import edu.eci.masivianTest.model.Roulette;
import edu.eci.masivianTest.persistence.RouletteRepository;
import edu.eci.masivianTest.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
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
    public void openRoulette(Long rouletteId)throws RouletteNotFoundException {
        Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(()->new RouletteNotFoundException(RouletteNotFoundException.NOT_FOUND));
        roulette.openRoulette();
        rouletteRepository.save(roulette);
    }
    @Override
    public void addBetToRoulette(Bet bet,Long rouletteId) throws RouletteNotFoundException, RouletteRestrictionsException {
        Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(()->new RouletteNotFoundException(RouletteNotFoundException.NOT_FOUND));
        roulette.addBet(bet);
        rouletteRepository.save(roulette);
    }
    @Override
    public List<Bet> closeRoulette(Long rouletteId) throws RouletteNotFoundException {
        Roulette roulette = rouletteRepository.findById(rouletteId).orElseThrow(()->new RouletteNotFoundException(RouletteNotFoundException.NOT_FOUND));
        roulette.closeRoulette();
        rouletteRepository.save(roulette);

        return roulette.getBets();
    }
    @Override
    public List<Roulette> getAllRoulettes() {
        ArrayList<Roulette> roulettes=new ArrayList<>();
        rouletteRepository.findAll().forEach(roulettes::add);

        return roulettes;
    }
}