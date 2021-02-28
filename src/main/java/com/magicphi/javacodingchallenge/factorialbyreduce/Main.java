package com.magicphi.javacodingchallenge.factorialbyreduce;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {

    private static long doFactorialNotGreaterThan20(int operand) {
        return LongStream.rangeClosed(1, operand).reduce(1, (long x, long y) -> x * y);
    }

    //TODO: To be implemented.
    private static long doFactorialGreaterThan20(int operand) {

        return 1l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int num = scanner.nextInt();
        System.out.print("The result of factorial(" + num + ")=" + doFactorialNotGreaterThan20(num));
        System.out.print("The result of factorial(" + num + ")=" + doFactorialNotGreaterThan20(num));
    }
}
