package search.practice;

import java.util.Scanner;

/*
Chef has a string SS with him. Chef is happy if the string contains a contiguous substring of length
strictly greater than 22 in which all its characters are vowels.

Determine whether Chef is happy or not.

Note that, in english alphabet, vowels are a, e, i, o, and u.

Input:
4
aeiou
abxy
aebcdefghij
abcdeeafg


Output:
Happy
Sad
Sad
Happy
* */

public class HappyString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();

            String result = isHappy(s) ? "Happy": "Sad";
            System.out.println(result);
        }
    }

    static boolean isHappy(String s){
        String vowels = "aeiou";
        int count = 0;
        char prev = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(count > 2)
                return true;
            prev = s.charAt(i-1);
            char c = s.charAt(i);

            if(vowels.contains(String.valueOf(c))){
                count++;
                if(vowels.contains(String.valueOf(prev)))
                    count++;
                else
                    count=0;
            }
        }
        return false;
    }
}
