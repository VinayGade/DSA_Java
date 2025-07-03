package hashing;

import java.util.*;
import java.util.stream.Collectors;

//Leetcode 49. Group Anagrams
/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

eg.
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

* */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    static List<List<String>> groupAnagrams(String[] strs, int n){
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (map.containsKey(sortedStr)) {
                ans.get(map.get(sortedStr)).add(str);
            } else {
                map.put(sortedStr, ans.size());
                ans.add(new ArrayList<>(Arrays.asList(str)));
            }
        }

        return ans;
    }

    public static void sort(String[] array){

        HashMapList<String, String> mapList = new HashMapList<>();

        //Group words by anagram
        for(String s: array){
            String key = sortChars(s);
            mapList.put(key, s);
        }

        //convert Hashtable to array
        int index = 0;
        for(String key: mapList.keySet()){
            ArrayList<String> list = mapList.get(key);
            for (String t: list){
                array[index] = t;
                index++;
            }
        }
    }

    static String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static List<List<String>> groupAnagrams(List<String> strs, int n) {

        return new ArrayList<>(
                //Arrays.stream(strs)
                strs.stream()
                .collect(Collectors.groupingBy(str -> {
                    char[] charArray = str.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }))
                .values());
    }

    public static List<List<String>> groupAnagrams(int n, String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        str -> {
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagramsGroup = groupAnagrams(strs);

        System.out.println("\nGroup anagrams using HashMap");
        anagramsGroup.forEach(list->{
            System.out.print("\n[");
            list.forEach(anagram -> System.out.print(anagram+", "));
            System.out.print("]");
        });

        System.out.println("\nGroup anagrams using Comparator sorting");
        Arrays.sort(strs, new AnagramComparator());
        for(String s: strs){
            System.out.print(s+" ");
        }

        System.out.println("\nGroup anagrams using HashMapList");
        sort(strs);
        for(String s: strs){
            System.out.print(s+" ");
        }

        System.out.println("\nGroup anagrams using Stream API");
        List<List<String>> anagramList = groupAnagrams(Arrays.asList(strs), strs.length);
        for(List<String> anagrams: anagramList){
            anagrams.forEach(anagram -> System.out.print(anagram+" "));
            System.out.println();
        }
    }
}

class AnagramComparator implements Comparator<String>{

    public String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    @Override
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
