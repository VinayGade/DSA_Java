package hashing;

/*
CodeChef: heap: Distinct Characters Subsequence

You have initially a string of N characters, denoted by A1,A2...AN.
You have to print the size of the largest subsequence of string A such that
all the characters in that subsequence are distinct ie.
no two characters in that subsequence should be same.

A subsequence of string A is a sequence that can be derived from A by deleting
some elements and without changing the order of the remaining elements.

Input:
2
abc
aba

Output:
3
2
* */

import java.util.HashSet;
import java.util.Scanner;

public class DistinctCharactersSubsequence {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input
        while(T-- > 0){
            //int N = scanner.nextInt();
            String s = scanner.nextLine();
            int count = countDistinctCharacters(s);
            System.out.println(count);
        }
    }

    /*
    static int countDistinctSubStrings(String s){
        //backtracking
        //int n = s.length();
        Map<Character, Integer> charFrequency = frequency(s);
        int mapSize = charFrequency.entrySet().size();
        return Math.min(n, mapSize);
    }
    */

    static int countDistinctCharacters(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }

    /*
    static Map<Character, Integer> frequency(String s){
        Map<Character, Integer> charFrequency = new HashMap<>();
        for(char c: s.toCharArray()){
            charFrequency.put(c, charFrequency.getOrDefault(c, 1)+1);
        }
        return charFrequency;
    }
    */
}
