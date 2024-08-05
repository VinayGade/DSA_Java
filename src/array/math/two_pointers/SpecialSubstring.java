package array.math.two_pointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpecialSubstring {

    /*
    String |S| = N
    longest substring of string which satisfy following conditions:
    Frequency (character B) = f(B)

    f(B) = index of character B in alphabet series
    f('a') = 1
    f('b') = 2

    ...
    ...
    ...

    f('x') = 24
    f('y') = 25
    f('z') = 26

    input:
    2
6
jyjerm

4
abbb

6
3
    * */

    static int longestValidSubstring(String s, int n){
        Map<Character, Integer> charFrequency = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while(right < n){

            char c = s.charAt(right);
            charFrequency.put(c, charFrequency.getOrDefault(c, 0)+ 1);

            // Shrink the window from the left if the maximum count exceeds.
            while(charFrequency.get(c) > (c-'a'+1)){
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar)-1);
                left++;
            }

            //update maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0) {
            int N = scan.nextInt();
            scan.nextLine();
            String S = scan.nextLine();
            int result = longestValidSubstring(S, N);
            System.out.println(result);
        }
        scan.close();
    }
}
