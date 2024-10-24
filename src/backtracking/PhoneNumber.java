package backtracking;

// LeetCode 17. Letter Combinations of a Phone Number
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    private static final Map<Character, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder combination,
                           String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        char d = digits.charAt(index);
        String letters = phoneMap.get(d);

        for (char l : letters.toCharArray()) {
            combination.append(l);
            backtrack(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {

        String digits = "23";
        List<String> combinations = letterCombinations(digits);

        combinations.forEach(System.out::println);
    }
}
