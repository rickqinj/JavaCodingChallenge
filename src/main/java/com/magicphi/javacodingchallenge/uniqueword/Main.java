package com.magicphi.javacodingchallenge.uniqueword;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Rick Qin (rickqinj@gmail.com)
 */
public class Main {
    
    private static final List<String> DICT = Arrays.asList(new String[]{"elephant", "donkey", "moose", "swan",  "dog"});
    
    private static boolean isUnique(String word) {
        String wordUpperCase = word.toUpperCase();
        int lenOfWord = wordUpperCase.length();
        char firstLetter = wordUpperCase.charAt(0);
        char lastLetter = wordUpperCase.charAt(lenOfWord - 1);
        Stream<String> stream = DICT.stream().filter((entry) -> {
            String dWord = entry.toUpperCase();
            return dWord.length() == lenOfWord && dWord.charAt(0) == firstLetter && dWord.charAt(lenOfWord - 1) == lastLetter;
        });
        Optional<String> result = stream.findAny();
        return !result.isPresent();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a word:");
        String word = scanner.nextLine();
        System.out.print("Is the word unique? " + (isUnique(word) ? "Yes" : "No"));
    }
}
