package org.example;

import java.util.logging.*;

public class RitualService {
    private static final Logger LOGGER = Log.setupLogger(RitualService.class.getName(), "logs/RitualService.log");
    private String name;
    private int price;

    public RitualService(String name, int price) {
        this.name = name;
        this.price = price;
        LOGGER.info("Создана новая ритуальная услуга: " + name + " за " + price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
