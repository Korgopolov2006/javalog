package org.example;

import java.io.IOException;
import java.util.logging.*;

public class Log {
    public static Logger setupLogger(String className, String fileName) {
        Logger logger = Logger.getLogger(className);
        try {
            FileHandler fileHandler = new FileHandler(fileName, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.severe("Ошибка при настройке логгера: " + e.getMessage());
        }
        return logger;
    }
}
