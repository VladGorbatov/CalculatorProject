package main.java.com.vladgorbatov.calculator;

import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    HashMap<String, Double> history = new HashMap<String, Double>();
    Scanner sc = new Scanner(System.in);

    public void calculate() {

        System.out.print("Привет, это простейший калькулятор!\nВведите первое значение: ");
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

        String expression = String.format("%.2f %c %.2f",a, operator, b);
        history.put(expression, result);

        System.out.println("Результат операции: " + result + "\n");

    }

    public void showHistory() {

        System.out.println("История вычислений: ");
        for (String expression : history.keySet()) {
            System.out.println(expression + " = " + history.get(expression));
        }

    }

    public void close(){
        sc.close();
    }

}
