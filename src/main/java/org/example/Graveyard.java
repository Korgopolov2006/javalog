package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class Graveyard {
    private static final Logger LOGGER = Log.setupLogger(Graveyard.class.getName(), "logs/Graveyard.log");
    private Map<Integer, String> graves;
    private int totalGraves;

    public Graveyard() {
        this.graves = new HashMap<>();
        this.totalGraves = 300;
        LOGGER.info("Создано новое кладбище с 300 местами");
    }

    public void addGrave(int graveNumber, String occupant) {
        graves.put(graveNumber, occupant);
        totalGraves++;
        LOGGER.info("Добавлено новое место: " + graveNumber + ", жилец: " + occupant);
    }

    public int getTotalGraves() {
        return totalGraves;
    }
}
