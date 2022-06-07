package com.roman.solutions.task3;

import java.math.BigInteger;

public class Solution {

    public static long getSumDigitsFactorial(int number){
        if(number <= 0) throw new IllegalArgumentException("Number should be greater than zero");

        BigInteger factorial = BigInteger.ONE;
        long sum = 0;

        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i)); // calculate the factorial of a number
        }

        while (factorial.compareTo(BigInteger.ZERO) > 0){ // while factorial number greater than zero
            sum += factorial.mod(BigInteger.TEN).longValue(); // add to the sum the remainder after division factorial number by 10
            factorial = factorial.divide(BigInteger.valueOf(10));// divide factorial number by 10
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSumDigitsFactorial(100));
    }
}
