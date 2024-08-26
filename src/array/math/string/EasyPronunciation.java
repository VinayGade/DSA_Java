package array.math.string;

/*
Codechef: Easy Pronunciation

Words that contain many consecutive consonants, like "schtschurowskia", are generally
considered somewhat hard to pronounce.

We say that a word is hard to pronounce if it contains >= 4 consonants in a row,
otherwise it is easy to pronounce.

For example, "apple" and "polish" are easy to pronounce,
but "schtschurowskia" is hard to pronounce.

Determine whether it is easy to pronounce or not based on the rule above
 print YES if it is easy to pronounce and NO otherwise.

input:
5
5
apple
15
schtschurowskia
6
polish
5
tryst
3
cry

output:
YES
NO
YES
NO
YES
* */

import java.util.Scanner;

public class EasyPronunciation {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            String word = scanner.next();

            String easy = isEasy(word, N) ? "YES" : "NO";

            System.out.println(easy);
        }
    }

    static boolean isEasy(String s, int n) {
        boolean flag = true;
        for (int i = 0; i < n - 3; i++){
            boolean vowel = false;
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                vowel = true;

            if (!vowel && check(s, i)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static boolean check(String s, int j) {
        int k = 0;
        for (int i = j + 1; i <= j + 3; i++){
            if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u')
                k++;
        }
        return k >= 3;
    }

    // way 2
    static boolean checkEasy(String word, int n) {
        String vowels = "aeiou";
        int consonantCount = 0;

        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!vowels.contains(String.valueOf(currentChar))) {
                consonantCount++;
                if (consonantCount >= 4)
                    return false; // Hard to pronounce
            } else
                consonantCount = 0; // Reset count if vowel
        }
        return true; // Easy to pronounce
    }

}
