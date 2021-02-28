package com.magicphi.javacodingchallenge.findintersection;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {

    private static final String[] strArr = new String[]{"1, 3, 25, 62, 67, 85, 87, 91, 98", "-1, -25"};//"1, 3, 4, 25, 62, 71, 85"
    
    private static void findIntersection(String[] strArr) {
        //Convert two elements into two lists of numbers.
        String[] testStrArr = Arrays.stream(strArr[0].split(","))
                .map(String::trim).toArray(String[]::new);
        String[] targetStrArr = Arrays.stream(strArr[1].split(","))
                .map(String::trim).toArray(String[]::new);
        Set<String> targetStrSet = Set.of(targetStrArr);
        
        //Evaluate Set.contains(obj) statement
        String str = Arrays.stream(testStrArr)
                .filter(targetStrSet::contains)
                .collect(Collectors.joining(",", "", ""));

        //Output
        Optional<String> result =
                Optional.ofNullable(str)
                        //Filter out string which is not Null but the length is 0).
                        .filter((e) -> (!e.isEmpty()));
        System.out.println(result.orElse("false"));
    }
    
    public static void main(String[] args) {
        findIntersection(strArr);
    }
}
