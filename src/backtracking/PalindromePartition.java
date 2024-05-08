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

    public static List<List<String>> partition(String s) {
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

    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> partitions = partition(s);
        partitions.forEach(System.out::println);

    }
}
