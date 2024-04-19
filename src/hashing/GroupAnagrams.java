package hashing;

import java.util.*;

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

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagramsGroup = groupAnagrams(strs);
        anagramsGroup.forEach(list->{
            System.out.print("\n[");
            list.forEach(anagram -> System.out.print(anagram+", "));
            System.out.print("]");
        }
        );
    }
}
