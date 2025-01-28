package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Permutations of a String:

Given a string s, which may contain duplicate characters, your task is to generate and
return an array of all unique permutations of the string.
You can return your answer in any order.

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.

Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.

Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.

* */
public class PermutationsString {

    ArrayList<String> ans = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    public ArrayList<String> findPermutation(String s) {
        // Code here
        boolean arr[] = new boolean[s.length()];
        fun("",s,arr);
        return ans;

    }
    public void fun(String sub , String s , boolean[] visited){
        if(sub.length() == s.length()){
            if(!set.contains(sub)){
                set.add(sub);
                ans.add(new String(sub));

            }
            return;
        }


        for(int i = 0; i < s.length(); i++){
            if(!visited[i])
            {
                sub += s.charAt(i);
                visited[i] = true;
                fun(sub,s,visited);
                visited[i] = false;
                sub = sub.substring(0,sub.length()-1);
            }
        }
    }

    public static void main(String[] args) {

        PermutationsString ps = new PermutationsString();

        String str = "ABC";
        String s = "ABSG";
        List<String> permutations = ps.findPermutation(s);

        System.out.println("String: "+s);
        System.out.println("Permutations: \n");
        for(String x : permutations){
            System.out.println(x);
        }

        List<String> allPermutations = findAllPermutations(str);
        System.out.println("String: "+str);
        System.out.println("Permutations: \n");
        for(String p : allPermutations){
            System.out.println(p);
        }
    }

    public static ArrayList<String> findAllPermutations(String s) {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> uniqueSet = findPermutations(s);
        ans.addAll(uniqueSet);
        return ans;
    }

    public static HashSet<String> findPermutations(String str) {
        HashSet<String> ans = new HashSet<>();
        if (str.length() == 1) {
            ans.add(str);
            return ans;
        }
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            String subString = str.substring(0, i) + str.substring(i + 1);
            HashSet<String> subStrings = findPermutations(subString);
            for (String s : subStrings) {
                ans.add(current + s);
            }
        }
        return ans;
    }
}
