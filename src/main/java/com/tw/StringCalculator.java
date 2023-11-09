package com.tw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        String customDelimiter = ",|\n";
        String numbersPart = input;

        if(input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.matches()) {
                customDelimiter = matcher.group(1);
                numbersPart = matcher.group(2);
            }
        }

        String[] numbers = numbersPart.split(customDelimiter);

        if (numbersPart.isEmpty()) {
            return 0;
        } else if (numbers.length > 1) {
            return getSum(numbers);
        }
        return stringToInt(numbersPart);
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String currentNumber:numbers) {
            if(stringToInt(currentNumber) > 1000) {
                continue;
            }
            sum += stringToInt(currentNumber);
        }
        return sum;
    }

    private int stringToInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("Negative input!");
        } else {
            return num;
        }
    }
}