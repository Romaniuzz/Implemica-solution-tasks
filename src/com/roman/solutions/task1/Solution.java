package com.roman.solutions.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private int countBrackets;
    private List<Integer> integerList;

    public Solution() {
        integerList = new ArrayList<>();
        readPositiveNumber();
    }


       // Calculate a count of valid brackets expressions.
       // Use the Catalan's recurrence relation.

    public int calculateCountOfCorrectBracketsExpressions() {

        // if countBrackets == 0 correct brackets sequence only one
        if (countBrackets == 0) {
            return 1;
        } else integerList.add(1);

        int countSequences;

        // if countBrackets >= 1 use Catalan's recurrence relation
        for (int i = 1; i <= countBrackets; ++i){
            countSequences = 0;
            for(int j = 0; j < i; ++j) {
                countSequences += integerList.get(j) * integerList.get(i-1-j);
            }
            integerList.add(countSequences);
        }
        return integerList.get(countBrackets); // return count of valid brackets expressions
    }


    private void readPositiveNumber(){

        int typedNumber;
        Scanner scanner = new Scanner(System.in);  // Reading data from keyboard, must be typed a positive integer number

        System.out.print("Type the count of brackets: ");
        while (true) {
            try {
                typedNumber = Integer.parseInt(scanner.nextLine());
                if (typedNumber < 0) throw new IllegalArgumentException("Number must be positive");  // If number is negative, get a warning massage
                break;
            } catch (IllegalArgumentException ex){
                System.out.print("Typed data isn't integer number, please type number again: ");  // If isn't integer number, get a warning massage
                continue;
            }
        }
        countBrackets = typedNumber;  // When typed the correct data, saved positive number for further use
    }


    public static void main(String[] args) {
         Solution solution = new Solution();
         System.out.println("Number of correct brackets expressions = " + solution.calculateCountOfCorrectBracketsExpressions());
    }
}
