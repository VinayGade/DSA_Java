package sort;

import java.util.ArrayList;
import java.util.List;

public class ReverseLettersOfString {

    public String reverseOnlyLetters(String s) {

        int start = 0;
        int end = s.length()-1;

        char[] chars = s.toCharArray();

        while(start < end) {
            while(start < end && !Character.isLetter(chars[start]))
                start++;

            while(start < end && !Character.isLetter(chars[end]))
                end--;

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseLettersOfString reverse = new ReverseLettersOfString();

        String test1 = "ab-cd";
        String test2 = "a-bC-dEf-ghIj";
        String test3 = "Test1ng-Leet=code-Q!";

        List<String> testCases = new ArrayList<>();

        testCases.add(test1);
        testCases.add(test2);
        testCases.add(test3);

        for(String test: testCases){
            System.out.println("\nString = "+test+", Reverse = "+reverse.reverseOnlyLetters(test));
        }
    }
}
