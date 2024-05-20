package org.example;

import java.util.logging.*;

public class InventoryItem {
    private static final Logger LOGGER = Log.setupLogger(InventoryItem.class.getName(), "logs/InventoryItem.log");
    private String name;
    private int count;

    public InventoryItem(String name, int count) {
        this.name = name;
        this.count = count;
        LOGGER.info("Создан новый предмет инвентаря: " + name + " с количеством: " + count);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}