package edu.eci.masivianTest.services;

import edu.eci.masivianTest.exceptions.RouletteException;

public interface RouletteServices {
     Long createRoulette();
     void openRoulette(Long rouletteId)throws RouletteException;
}
