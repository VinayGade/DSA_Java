package recursion;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 problem : First Unique Character in a String

 Given a string s, find the first non-repeating character in it and return its index.
 If it does not exist, return -1.

 Input: s = "leetcode"
 Output: 0

 Input: s = "loveleetcode"
 Output: 2

 Input: s = "aabb"
 Output: -1

 1 <= s.length <= 10 ^5

 s consists of only lowercase English letters.

*/
public class FirstUniqueChar {

    public static void main(String[] args) {

        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();

        String s = "loveleetcode";  // aabb   leetcode   loveleetcode
        int index = firstUniqueChar.firstUniqCh(s);
        System.out.println("find the first non-repeating character in "+s+" and return its index : "+index);

        char unique = firstUniqueChar.firstNonRepeat(s);

        System.out.println("First non-repeating character in "+s+" is "+unique);
        System.out.println("index = "+s.indexOf(unique));
    }

    public int firstUniqChar(String s) {

        int index = -1;
        int n = s.length();
        char firstUnique = ' ';
        if(n == 1)
            index++;
        else {
            Map<Character, Integer> frequencyMap = frequency(s);
            for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
                if(entry.getValue() == 1){
                    firstUnique = entry.getKey();
                    index = s.indexOf(firstUnique);
                    break;
                }
            }
        }
        /*
        if(firstUnique != ' '){
            for(int i = 0; i <s.length(); i++){
                if(s.charAt(i) == firstUnique){
                    index = i;
                    break;
                }
            }
        }
        */
        return index;
    }

    public Map<Character, Integer> frequency(String s){
        Map<Character, Integer> characterFrequency = new LinkedHashMap<>(); // maintains insertion order
        for(int i = 0; i <s.length(); i++){
            char c = s.charAt(i);
            if(!characterFrequency.containsKey(c))
                characterFrequency.put(c, 1);
            else
                characterFrequency.put(c, characterFrequency.get(c)+1);
        }
        return characterFrequency;
    }

    public char firstNonRepeat(String s) {

        char firstUnique = ' ';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch, s.indexOf(ch) + 1) == -1) {
                firstUnique = ch;
                break;
            }
        }
        return firstUnique;
    }

    public int firstUniqueCharacter(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    // without using any extra space
    public int firstUniqCharacter(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public int firstUniqCh(String s) {

        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] fre = new int[26];

        for(char c : arr)
            fre[c-'a']++;

        for(int i=0; i<len; i++)
            if(fre[arr[i]-'a'] == 1)
                return i;

        return -1;
    }
}
