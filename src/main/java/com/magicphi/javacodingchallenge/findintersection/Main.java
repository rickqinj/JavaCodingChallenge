package com.magicphi.javacodingchallenge.findintersection;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {

    private static final String[] strArr = new String[]{"91, 67, 3, 25, 85, 87, 98, 62", "-62"};
    
    private static void findIntersection(String[] strArr) {
        //Convert two elements into two lists of numbers.
        Stream<Integer> intList1 = Arrays.stream(strArr[0].split(","))
                .mapToInt((e) -> {return Integer.parseInt(e.trim());})
                .distinct().sorted().boxed();
        List<Integer> intList2 = Arrays.stream(strArr[1].split(","))
                .mapToInt((e) -> {return Integer.parseInt(e.trim());})
                .distinct().sorted().boxed()
                .collect(Collectors.toList());

        //Evaluate contains() statement.
        StringBuilder sb = new StringBuilder();
        intList1.filter(intList2::contains).forEach((str) -> {
            sb.append(str);
            sb.append(",");
        });

        //Output
        if (sb.length() <= 0) {
            System.out.println("false");
        } else {
            System.out.print(sb.deleteCharAt(sb.length() - 1).toString());
        }
    }
    
    public static void main(String[] args) {
        findIntersection(strArr);
    }
}
