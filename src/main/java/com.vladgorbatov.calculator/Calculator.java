package main.java.com.vladgorbatov.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    Map<String, Double> history = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Привет, это простейший калькулятор!\n" +
                "— Для решения примера нажмите 1;\n" +
                "— Для запроса истории решений нажмите 2;\n" +
                "— Для закрытия калькулятора нажмите 0.\n\n");

        while (true) {
            System.out.print("Введите команду: ");
            char choice = sc.next().charAt(0);

            switch (choice) {
                case '1':
                    startCalculations();
                    break;
                case '2':
                    showHistory();
                    break;
                case '0':
                    stop();
                    return;
                default:
                    System.out.println("Неизвестная команда!\n" +
                            "— Для решения примера нажмите 1;\n" +
                            "— Для запроса истории решений нажмите 2;\n" +
                            "— Для закрытия калькулятора нажмите 0.\n");
                    break;
            }
        }
    }

    public void startCalculations() {
        System.out.print("Введите первое значение: ");
        Double a = sc.nextDouble();

        System.out.print("Введите арифметическую операцию (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        System.out.print("Введите второе значение: ");
        Double b = sc.nextDouble();

        double result;

        switch (operator) {
            case '+':
                result = a + b;
                break;

            case '-':
                result = a - b;
                break;

            case '*':
                result = a * b;
                break;

            case '/':
                if (b == 0) {
                    System.out.println("Ошибка операции: деление на ноль!");
                    return;
                } else {
                    result = a / b;
                }
                break;

            default:
                System.out.println("Ошибка операции! Введите +, -, *, /");

                return;
        }

        String expression = String.format("%.2f %c %.2f", a, operator, b);
        history.put(expression, result);

        System.out.println("Результат операции: " + result + "\n");
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("История вычислений пуста.\n");
        } else {
            System.out.println("История вычислений: ");
            for (String expression : history.keySet()) {
                System.out.println(expression + " = " + history.get(expression));
            }
            System.out.println();
        }
    }

    public void stop() {
        sc.close();
        System.out.println("Калькулятор завершил работу.");
    }
}
