package org.example;

import java.util.logging.*;

public class Employee {
    private static final Logger LOGGER = Log.setupLogger(Employee.class.getName(), "logs/Employee.log");
    private String name;

    public Employee(String name) {
        this.name = name;
        LOGGER.info("Создан новый сотрудник: " + name);
    }

    public String getName() {
        return name;
    }
}
