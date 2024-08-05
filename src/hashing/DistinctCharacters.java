package hashing;

import java.util.LinkedHashSet;
import java.util.Set;

public class DistinctCharacters {

    static String removeDups(String str) {

        String distinctChars = "";
        Set<Character> distincts = new LinkedHashSet<>();

        for(int i=0; i<str.length(); i++){
            distincts.add(str.charAt(i));
        }

        for(char c: distincts){
            distinctChars += String.valueOf(c);
        }

        return distinctChars;
    }

    static String removeDuplicates(String str) {
        // code here
        boolean [] set = new boolean[26];
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(!set[str.charAt(i)-'a']){
                ans.append(str.charAt(i));
                set[str.charAt(i)-'a']=true;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";

        String distinctChars = removeDups(s);

        String distinctCharacters = removeDuplicates(s);

        System.out.println(s);

        System.out.println(distinctChars);

        System.out.println(distinctCharacters);
    }
}