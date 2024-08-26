package main.java.com.vladgorbatov.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Привет, это простейший калькулятор!\nВведите первое значение: ");
        int a = sc.nextInt();


        System.out.println("Введите арифметическую операцию (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        System.out.println("Введите второе значение: ");
        int b = sc.nextInt();

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
                    result = (double) a / b;
                }
                break;

            default:
                System.out.println("Ошибка: неизвестная операция!");
                return;
        }

        System.out.println("Результат операции: " + result);


        sc.close();
    }
}
