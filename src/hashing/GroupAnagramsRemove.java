package hashing;

/*
LeetCode 2273. Find Resultant Array After Removing Anagrams

Input: words = ["abba","baba","bbaa","cd","cd"]
Output: ["abba","cd"]
* */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagramsRemove {

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        int n = words.length;
        Map<TreeMap<Character, Integer>, String> frequencies = new LinkedHashMap< TreeMap<Character, Integer>, String>();
        frequencies.put(charFrequency(words[0], words[0].length()), words[0]);
        for(int i = 1; i<n; i++){
            if(words[i].length() == 1)
                result.add(words[i]);
            else {
                TreeMap<Character, Integer> frequencyMap = charFrequency(words[i], words[i].length());
                if (!frequencies.containsKey(frequencyMap)) {
                    frequencies.put(frequencyMap, words[i]);
                    result.add(words[i]);
                }
            }
        }
        return result;
    }

    public static TreeMap<Character, Integer> charFrequency(String word, int n){
        char[] chars = word.toCharArray();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
        for(int i=0; i<n; i++)
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0)+1);
        return frequencyMap;
    }

    public static LinkedHashMap<Character, Long> findCharFrequency(String word, int n){
        LinkedHashMap<Character, Long> frequencyMap = word.chars()
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(
                        c -> c, // Character as the key
                        LinkedHashMap::new, // Use TreeMap to maintain order
                        Collectors.counting() // Count frequency
                ));
        return frequencyMap;
    }

    public Map<String, Long> characterFrequency(String string){

        /*
         Map<String, Long> songByLanguage =
                playlist.stream()
                        .collect(groupingBy(
                                Song::getLanguage, Collectors.counting()));
        */
        String[] characters = string.split("");

        Map<String, Long> frequencyMap = Arrays.stream(characters)
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        return frequencyMap;
    }

    // optimized approach
    public static List<String> removeAnagrams(String[] words, int size) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        boolean foundAnagram = true;
        while (foundAnagram) {
            foundAnagram = false;
            for (int i = 1; i < size; i++) {
                if (isAnagram(result.get(i - 1), result.get(i))) {
                    result.remove(i);
                    foundAnagram = true;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    //2-pointer approach (Most optimized and efficient approach)
    public static List<String> removeAnagrams(int size, String[] words) {
        List<String> result = new ArrayList<>();
        //int n = words.length;
        int i = 0;
        int j = -1;
        while(i<size){
            j = i+1;
            while(j<size && isAnagram(words[i], words[j]))
                j++;
            result.add(words[i]);
            i=j;
        }
        return result;
    }

    public static List<String> removeAnagrams(List<String> words) {
        List<String> result = new ArrayList<>();
        int n = words.size();
        //if (words.length == 0) return result;

        result.add(words.get(0));
        int i = 0; // points to the last element in the result

        for (int j = 1; j < n; j++) {
            if (!isAnagram(result.get(i), words.get(j))) {
                result.add(words.get(j));
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        List<String> result = removeAnagrams(words);
        result.forEach(System.out::println);

        List<String> ans = removeAnagrams(words.length, words);
        ans.forEach(System.out::println);

        List<String> wordList = Arrays.asList("abba","baba","bbaa","cd","cd");
        List<String> withoutAnagrams = removeAnagrams(wordList);
        withoutAnagrams.forEach(System.out::println);
    }
}