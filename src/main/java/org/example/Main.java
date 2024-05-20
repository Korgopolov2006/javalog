package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger LOGGER = Log.setupLogger(Main.class.getName(), "logs/Main.log");

    public static void main(String[] args) {
        LOGGER.info("Приложение запущено");

        Graveyard graveyard = new Graveyard();
        List<Employee> employees = new ArrayList<>();
        List<RitualService> ritualServices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        employees.add(new Employee("Даня Филимонов"));
        employees.add(new Employee("Игорь Ковыков"));

        ritualServices.add(new RitualService("Кремация", 2500));
        ritualServices.add(new RitualService("Надгробные памятники", 2000));
        ritualServices.add(new RitualService("Оформление места захоронения", 5000));

        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Просмотр количества мест на кладбище");
            System.out.println("2. Просмотр списка сотрудников");
            System.out.println("3. Редактирование списка сотрудников");
            System.out.println("4. Просмотр списка ритуальных услуг");
            System.out.println("5. Редактирование списка ритуальных услуг");
            System.out.println("6. Просмотр инвентаря");
            System.out.println("7. Добавление мест на кладбище");
            System.out.println("8. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    LOGGER.info("Просмотр количества мест на кладбище");
                    System.out.println("Общее количество мест на кладбище: " + graveyard.getTotalGraves());
                    break;
                case 2:
                    LOGGER.info("Просмотр списка сотрудников");
                    System.out.println("Список сотрудников:");
                    for (Employee employee : employees) {
                        System.out.println(employee.getName());
                    }
                    break;
                case 3:
                    LOGGER.info("Редактирование списка сотрудников");
                    System.out.println("Редактирование списка сотрудников:");
                    System.out.println("1. Добавить сотрудника");
                    System.out.println("2. Удалить сотрудника");
                    int editChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (editChoice) {
                        case 1:
                            System.out.print("Введите имя нового сотрудника: ");
                            String newEmployeeName = scanner.nextLine();
                            employees.add(new Employee(newEmployeeName));
                            LOGGER.info("Добавлен новый сотрудник: " + newEmployeeName);
                            System.out.println("Сотрудник успешно добавлен.");
                            break;
                        case 2:
                            System.out.print("Введите имя сотрудника для удаления: ");
                            String removeEmployeeName = scanner.nextLine();
                            employees.removeIf(emp -> emp.getName().equals(removeEmployeeName));
                            LOGGER.info("Удален сотрудник: " + removeEmployeeName);
                            System.out.println("Сотрудник успешно удален.");
                            break;
                        default:
                            LOGGER.warning("Неверный выбор в редактировании сотрудников");
                            System.out.println("Неверный выбор.");
                    }
                    break;
                case 4:
                    LOGGER.info("Просмотр списка ритуальных услуг");
                    System.out.println("Список ритуальных услуг:");
                    for (RitualService service : ritualServices) {
                        System.out.println(service.getName() + " - " + service.getPrice());
                    }
                    break;
                case 5:
                    LOGGER.info("Редактирование списка ритуальных услуг");
                    System.out.println("Редактирование списка ритуальных услуг:");
                    System.out.println("1. Добавить ритуальную услугу");
                    System.out.println("2. Удалить ритуальную услугу");
                    int editServiceChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (editServiceChoice) {
                        case 1:
                            System.out.print("Введите название новой ритуальной услуги: ");
                            String newServiceName = scanner.nextLine();
                            System.out.print("Введите стоимость новой ритуальной услуги: ");
                            int newServicePrice = scanner.nextInt();
                            ritualServices.add(new RitualService(newServiceName, newServicePrice));
                            LOGGER.info("Добавлена новая ритуальная услуга: " + newServiceName + " за " + newServicePrice);
                            System.out.println("Ритуальная услуга успешно добавлена.");
                            break;
                        case 2:
                            System.out.print("Введите название ритуальной услуги для удаления: ");
                            String removeServiceName = scanner.nextLine();
                            ritualServices.removeIf(service -> service.getName().equals(removeServiceName));
                            LOGGER.info("Удалена ритуальная услуга: " + removeServiceName);
                            System.out.println("Ритуальная услуга успешно удалена.");
                            break;
                        default:
                            LOGGER.warning("Неверный выбор в редактировании ритуальных услуг");
                            System.out.println("Неверный выбор.");
                    }
                    break;
                case 7:
                    LOGGER.info("Добавление мест на кладбище");
                    System.out.print("Введите количество добавляемых мест на кладбище: ");
                    int newGravesCount = scanner.nextInt();
                    graveyard.addGrave(newGravesCount, "Новый жилец");
                    LOGGER.info("Добавлено " + newGravesCount + " новых мест на кладбище");
                    System.out.println("Количество мест на кладбище успешно обновлено.");
                    break;
                case 8:
                    LOGGER.info("Выход из приложения");
                    exit = true;
                    break;
                default:
                    LOGGER.warning("Неверный выбор в главном меню");
                    System.out.println("Неверный выбор.");
            }
        }
        scanner.close();
        LOGGER.info("Приложение завершено");
    }
}
