package org.example.app;

import org.example.app.config.AppConfig;
import org.example.app.controller.EmployeeController;
import org.example.app.entity.Message;
import org.example.app.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Активація Spring IOC контейнера,
        // завантаження конфігураційного класу
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        onEmployeeUtil(context);
        onMessageUtil(context);
        context.close();
    }

    public static void onEmployeeUtil(AnnotationConfigApplicationContext context) {
        // Отримання bean зі Spring IOC контейнеру
        EmployeeController employeeController =
                context.getBean("EmployeeController", EmployeeController.class);

        // Створення даних
        String employeeCreated1 =
                employeeController.create(new Employee("Alice", "Terra", "Frontend Programmer", "+380671111111"));
        getOutput("\n>> Employee 1 created: " + employeeCreated1);
        String employeeCreated2 =
                employeeController.create(new Employee("Tom", "Forest", "Backend Programmer", "+380502222222"));
        getOutput(">> Employee 2 created: " + employeeCreated2);
        String employeeCreated3 =
                employeeController.create(new Employee("Lucy", "Moon", "Qi Tester", "+3806333333333"));
        getOutput(">> Employee 3 created: " + employeeCreated3);

        // Отримання всіх даних
        String employeeDataList = employeeController.getAll();
        getOutput("\n>> Employee data list:\n" + employeeDataList);

        // Отримання даних за id
        System.out.print("\n>> Input Employee id to find Employee by id: ");
        Long employeeId = scanner.nextLong();
        String employeeById = employeeController.getById(employeeId);
        getOutput("\n>> Employee by id: " + employeeById);

        // Оновлення даних за id
        System.out.print("\n>> Input Employee id to update Employee by id: ");
        Long employeeToUpdateId = scanner.nextLong();
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setId(employeeToUpdateId);
        employeeToUpdate.setFirstName("Lucy");
        employeeToUpdate.setLastName("Venuslight");
        employeeToUpdate.setPosition("Website Designer");
        employeeToUpdate.setPhone("+380934567798");
        String employeeUpdated = employeeController.update(employeeToUpdate);
        getOutput("\n>> Employee updated: " + employeeUpdated);
        // Отримання всіх даних
        String employeeDataList2 = employeeController.getAll();
        getOutput("\n>> Employee data list 2:\n" + employeeDataList2);

        // Видалення даних за id
        System.out.print("\n>> Input Employee id to delete Employee by id: ");
        Long employeeToDeleteId = scanner.nextLong();
        String employeeDeleteResult = employeeController.deleteById(employeeToDeleteId);
        getOutput("\n>> Delete Employee by id result: " + employeeDeleteResult);
        // Отримання всіх даних
        String employeeDataList3 = employeeController.getAll();
        getOutput("\n>> Employee data list 3:\n" + employeeDataList3);
    }

    public static void onMessageUtil(AnnotationConfigApplicationContext context) {
        // Отримання bean з Spring IOC контейнеру
        Message message = (Message) context.getBean("doMessage");
        // Виклик bean метода
        String messageResult = message.getMessage();
        // Виведення результату
        getOutput("\n>> Message: " + messageResult);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
