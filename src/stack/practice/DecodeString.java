package stack.practice;

import java.util.Stack;

/*
Decode the string:

Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated
exactly k times. Note that k is guaranteed to be a positive integer, and encodedString
contains only lowercase english alphabets.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
1. Inner substring “2[ca]” breakdown into “caca”.
2. Now, new string becomes “3[bcaca]”
3. Similarly “3[bcaca]” becomes “bcacabcacabcaca ” which is final result.
* */
public class DecodeString {

    static String decodeString(String s) {
        Stack<Integer> val=new Stack<>();
        Stack<Character>stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(int i=0; i<s.length(); ){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9'){
                StringBuilder str=new StringBuilder();
                while(ch>='0' && ch<='9'){
                    str.append(ch);
                    i++;
                    ch=s.charAt(i);
                }
                int cnt=Integer.parseInt(str.toString());
                val.push(cnt);
            }else if(ch==']'){
                StringBuilder str=new StringBuilder();
                while(!stack.isEmpty() && stack.peek()!='['){
                    char ch1=stack.pop();
                    str.append(ch1);
                }
                stack.pop();
                int times=val.pop();
                str.reverse();
                for(int j=0; j<times; j++){
                    for(int k=0; k<str.length(); k++){
                        stack.push(str.charAt(k));
                    }
                }
                i++;
            }else{
                stack.push(ch);
                i++;
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    //Optimised
    public String decodeStringOptimised(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        String decoded = decodeString(s);
        System.out.println(decoded);
    }

    // most optimised approach: Recursion

    class Solution {
        private int index = 0;  // Global index for tracking the position

        public String decodeString(String s) {
            return decodeHelper(s);
        }

        private String decodeHelper(String s) {
            StringBuilder result = new StringBuilder();
            int k = 0;

            while (index < s.length()) {
                char ch = s.charAt(index);
                index++;

                if (Character.isDigit(ch)) {
                    k = k * 10 + (ch - '0');  // Build multi-digit numbers
                } else if (ch == '[') {
                    String decodedPart = decodeHelper(s);  // Recursive call
                    while (k > 0) {
                        result.append(decodedPart);
                        k--;
                    }
                } else if (ch == ']') {
                    return result.toString();  // Return the substring for current recursion
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        }
    }
}
