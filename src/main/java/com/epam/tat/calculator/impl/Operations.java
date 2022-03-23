package com.epam.tat.calculator.impl;

import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Double a;
        String operator;
        Double b;
        Integer precision;
        try (Scanner in = new Scanner(System.in)) {

            System.out.println("Please, enter argument");
            a = in.nextDouble();
            in.nextLine();
            System.out.println("Please, enter math operator (+ - * /)");
            operator = in.nextLine();
            System.out.println("Please, enter argument");
            b = in.nextDouble();
            System.out.println("Please, enter precision");
            precision = in.nextInt();
        }

        Calculator calculator = new Calculator(precision);
        switch (operator) {
            case "+":
                calculator.printResult(a, b, "+", calculator.add(a, b));
                break;
            case "-":
                calculator.printResult(a, b, "-", calculator.subtract(a, b));
                break;
            case "*":
                calculator.printResult(a, b, "*", calculator.multiply(a, b));
                break;
            case "/":
                calculator.printResult(a, b, "/", calculator.divide(a, b));
                break;
            default:
                throw new IllegalArgumentException("Invalid math operator");
        }
    }
}
