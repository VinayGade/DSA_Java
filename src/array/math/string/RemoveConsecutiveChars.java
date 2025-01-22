package array.math.string;

import java.util.HashMap;
import java.util.Map;

/*

Given a string A and integer B, remove all consecutive same characters that have length exactly B.

NOTE : All the consecutive same characters that have length exactly B will be removed simultaneously.

Input 1:

A = "aabcd"
B = 2

Input 2:

A = "aabbccd"
B = 2

Output 1:

 "bcd"

Output 2:

 "d"
* */

public class RemoveConsecutiveChars {

    public static String removeConsecutiveCharacters(String A, int B) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < A.length()) {
            int count = 1;

            // Count consecutive characters
            while (i + 1 < A.length() && A.charAt(i) == A.charAt(i + 1)) {
                count++;
                i++;
            }

            // If count does not equal B, append the characters
            if (count != B) {
                for (int j = 0; j < count; j++) {
                    sb.append(A.charAt(i));
                }
            }

            i++;  // Move to the next character
        }

        return sb.toString();
    }


    public static String solve(String A, int B) {
        int n = A.length();
        String res = "", temp = "";
        int i=1, count=1;
        temp+=A.charAt(0);

        while(i < n){
            while(i<n && A.charAt(i)==A.charAt(i-1)){
                temp += Character.toString(A.charAt(i));
                i++;
                count++;
            }
            if(count == B){
                temp = i<n ? Character.toString(A.charAt(i)) : "";
            }else{
                res += temp;
                temp = i<n ? Character.toString(A.charAt(i)): "";
            }
            i++;
            count=1;
            if(i == n){
                if(count != B)
                    res+=temp;
            }
        }

        return res;
    }

    public String removeConsecutiveChars(String A, int B) {
        String solution = "";
        Map<Character, Integer> frequencyMap = charFrequency(A);
        for(Map.Entry<Character, Integer> entry: frequencyMap.entrySet()){
            char key = entry.getKey();
            int freq = entry.getValue();
            if(freq < B){
                for(int i=0; i<freq; i++){
                    solution += key;
                }
            }
        }
        return solution;
    }

    Map<Character, Integer> charFrequency(String A){
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char x: A.toCharArray())
            frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
        return frequencyMap;
    }

    public static void main(String[] args) {
        String A = "aabbccd";
        int b = 2;
        String result = removeConsecutiveCharacters(A, b);
        System.out.println(result);
    }
}
