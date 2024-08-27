package main.java.com.vladgorbatov.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculater = new Calculator();

        calculater.calculate();
        calculater.calculate();
        calculater.showHistory();
        calculater.close();

    }
}
