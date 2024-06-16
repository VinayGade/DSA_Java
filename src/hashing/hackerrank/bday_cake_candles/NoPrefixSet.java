package hashing.hackerrank.bday_cake_candles;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NoPrefixSet {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    // test cases fail ... doesn't give desired output for 'badStr'
    public static void noPrefixSet(List<String> words) {

        String badStr = "";
        boolean isPrefix = false;
        //Collections.sort(words);

        words = words.stream().sorted().collect(Collectors.toList());

        for(int i=1; i<words.size(); i++){
            String curr = words.get(i);
            String prev = words.get(i-1);
            if(curr.length() > prev.length()){
                if(curr.startsWith(prev)){
                    isPrefix = true;
                    badStr = curr;
                    break;
                }
            }
        }
        String result = isPrefix ? "BAD SET" : "GOOD SET";
        System.out.println(result);
        if(isPrefix)
            System.out.println(badStr);
    }

    public static void noPrefix(List<String> words) {
        TreeMap<String, Integer> sorted = new TreeMap<>();
        int min = Integer.MAX_VALUE; // index of first observable prefix
        int index = 0;
        for (String word : words) {
            if (sorted.containsKey(word)) // check for identical
                min = Math.min(min, index);
            sorted.putIfAbsent(word, index++); // sort the strings
        }
        for (String word : words.stream().distinct().collect(Collectors.toList())) {
            String next = sorted.higherKey(word);
            while (isPrefix(word, next)) {
                min = Math.min(min, Math.max(sorted.get(word), sorted.get(next)));
                next = sorted.higherKey(next);
            }
        }
        if(min != Integer.MAX_VALUE)
            System.out.println("BAD SET\n" + words.get(min));
        else
            System.out.println("GOOD SET");
    }
    static boolean isPrefix(String pre, String full) {
        return pre != null && full != null && full.startsWith(pre);
    }

    public static void main(String[] args) {
        int n = 7;
        List<String> words = Arrays.asList("aab", "defgab", "abcde", "aabcde",
                "bbbbbbbbbb", "jabjjjad");

        noPrefix(words);
    }

}
