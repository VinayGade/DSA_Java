package backtracking;

import javax.xml.bind.annotation.XmlAnyAttribute;
import java.util.ArrayList;
import java.util.List;

//LC 131. Palindrome Partitioning
/*
Given a string s, partition s such that every
substring of the partition is a
palindrome. Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]
* */
public class PalindromePartition {

    // approach - 2
    static List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    // backtracking
    static void helper(String s, List<String> step, List<List<String>> result) {
        // Base case
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp))
                continue; // only do backtracking when current string is palindrome

            step.add(temp);  // choose
            helper(s.substring(i, s.length()), step, result); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }

    static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // approach - 1
    public static List<List<String>> partitions(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<String>(), result);
        return result;
    }

    static void dfs(String s, int start, List<String> list, List<List<String>> result){
        if(s.length()==start){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                list.add(s.substring(start, i+1));
                dfs(s, i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start)!=s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }

    // final approach
    public ArrayList<ArrayList<String>> palindromicParts(String s) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(String s, int start, ArrayList<String> current, ArrayList<ArrayList<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int end = start + 1; end <= s.length(); end++){
            String substr = s.substring(start, end);
            if(isPalindrome(substr)){
                current.add(substr);
                backtrack(s, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        // approach-1
        String s = "aab";

        List<List<String>> partitions = partitions(s);
        partitions.forEach(System.out::println);

        // approach-2
        String str="abaabcaba";
        List<List<String>> solution = partition(str);
        solution.forEach(System.out::println);
    }
}
