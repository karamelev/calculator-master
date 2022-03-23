package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.util.logging.Logger;

import static jdk.nashorn.internal.objects.Global.Infinity;

 public class Calculator implements ICalculator {
     private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    private final int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        if (a > 0 && b > 0 && Double.MAX_VALUE - a < b) {return Infinity;}
             if (a < 0 && b < 0 && -Double.MAX_VALUE + a < b) {return -Infinity;}
        double precisionMultiplier = Math.pow(10, this.precision);
        return Math.round((a + b) * precisionMultiplier) / precisionMultiplier;
    }
    @Override
    public double subtract(double a, double b) {
        if (a > 0 && b < 0 && Double.MAX_VALUE - a < -b) {return Infinity;}
            if (a < 0 && b > 0 && -Double.MAX_VALUE - a < b) {return -Infinity;}
            double precisionMultiplier = Math.pow(10, this.precision);
            return Math.round((a - b) * precisionMultiplier) / precisionMultiplier;
        }
    @Override
    public double multiply(double a, double b) {
        if (a > 0 && b < 0 && Double.MAX_VALUE / a > b) {return -Infinity;}
            if ( a > 0 && b > 0 && Double.MAX_VALUE / a < b) { return Infinity;}
        double precisionMultiplier = Math.pow(10, this.precision);
        return Math.round((a * b) * precisionMultiplier)/ precisionMultiplier;
    }

    @Override
    public double divide(double a, double b) {
        if (a > 0 && b  == 0) {return Infinity;}
            if (a<0 && b == 0){return -Infinity;}
       double precisionMultiplier = Math.pow(10, this.precision);
        return Math.round((a / b) * precisionMultiplier)/ precisionMultiplier;
    }
     public void printResult (Double a, Double b, String operator, Double result) {
         System.out.println("if precision = " + precision + ",then " + a + " " + operator + " " + b + " = " + result);
     }

 }
