package com.magicphi.javacodingchallenge.findintersection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {

    private static final String[] strArr = new String[]{"1, 3, 25, 62, 67, 85, 87, 91, 98", "1, 3, 4, 25, 62, 71, 85"};
    
    private static void findIntersection(String[] strArr) {
        //Convert two elements into two lists of numbers.
        String[] testStrArr = Arrays.stream(strArr[0].split(","))
                .map(String::trim).toArray(String[]::new);
        String[] targetStrArr = Arrays.stream(strArr[1].split(","))
                .map(String::trim).toArray(String[]::new);
        Set<String> targetStrSet = Set.of(targetStrArr);
        
        //Evaluate Set.contains(obj) statement
        List<String> intersection = Arrays.stream(testStrArr)
                .filter((e) -> targetStrSet.contains(e))
                .collect(Collectors.toList());
        
        //Output
        StringBuilder sb = new StringBuilder();
        intersection.forEach(str -> sb.append(",").append(str));
        if (sb.length() > 0) {
            System.out.print(sb.deleteCharAt(0).toString());
        } else {
            System.out.print("false");
        }
    }
    
    public static void main(String[] args) {
        findIntersection(strArr);
    }
}
