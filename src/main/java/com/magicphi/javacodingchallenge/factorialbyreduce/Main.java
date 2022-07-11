package com.magicphi.javacodingchallenge.factorialbyreduce;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {

    private static long doFactorialNumLessThen21ByReduce(int num) {
        return LongStream.rangeClosed(1, num)
                .reduce(1, (long x, long y) -> x * y);
    }

    private static long doFactorialNumLessThen21ByLoop(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

    private static long doFactorialNumLessThen21ByRecursion(int num) {
        if (1 == num) {
            return 1;
        }
        return num * doFactorialNumLessThen21ByRecursion(num - 1);
    }

    private static BigInteger doFactorialNumGreaterThan20(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int num = scanner.nextInt();
        System.out.println(doFactorialNumLessThen21ByReduce(num));
        System.out.println(doFactorialNumLessThen21ByLoop(num));
        System.out.println(doFactorialNumLessThen21ByRecursion(num));
        System.out.println(doFactorialNumGreaterThan20(num));
        
    }
}
