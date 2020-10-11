package edu.eci.masivianTest.services;

import edu.eci.masivianTest.exceptions.RouletteNotFoundException;
import edu.eci.masivianTest.exceptions.RouletteRestrictionsException;
import edu.eci.masivianTest.model.Bet;

public interface RouletteServices {
     Long createRoulette();
     void openRoulette(Long rouletteId)throws RouletteNotFoundException;
     void addBetToRoulette(Bet bet,Long rouletteId) throws RouletteNotFoundException, RouletteRestrictionsException;
}
