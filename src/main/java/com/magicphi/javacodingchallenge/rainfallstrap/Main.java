package com.magicphi.javacodingchallenge.rainfallstrap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {
    
    private static long calculateRainfalls(int[] arr) {
        long rainfalls = 0;
        int maxHeightOfBuilding = Arrays.stream(arr).max().getAsInt();
        int numOfBuildings = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxHeightOfBuilding; i++) {
            for (int j = 0; j < numOfBuildings; j++) {
                String stuffChar = arr[i] > i ? "1" : " ";
                sb.append(stuffChar);
            }
            sb.append(",");
        }
        List<String> strs = Arrays.asList(sb.toString().split(","));
        rainfalls = strs.stream().map(str -> str.trim()).map(str -> str.chars().filter(c -> c==32).count()).reduce(rainfalls, Long::sum);
        return rainfalls;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {4,0,1,3,7,4,7};
        System.out.print(calculateRainfalls(arr));
    }
    
}
