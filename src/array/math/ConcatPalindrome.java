package array.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//CodeChef: Concat Palindrome
public class ConcatPalindrome {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            String a = scanner.next();
            String b = scanner.next();

            String result = isPalindromeCombined(a, b, n, m) ? "YES" : "NO";
            System.out.println(result);
        }
    }

    static boolean isPalindromeCombined(String a, String b, int n, int m) {

        boolean flag = true;
        int[] fa = charFrequency(a, n);
        int[] fb = charFrequency(b, m);
        List< Integer > lista = new ArrayList< >(), listb = new ArrayList < > ();
        for (int i = 0; i < 26; i++) {
            if (fa[i] >= fb[i]) {
                fa[i] -= fb[i];
                if (fa[i] > 0) {
                    lista.add(fa[i]);
                }
                fb[i] = 0;
            } else {
                fb[i] -= fa[i];
                if (fb[i] > 0) {
                    listb.add(fb[i]);
                }
                fa[i] = 0;
            }
        }
        if (!lista.isEmpty() && !listb.isEmpty())
            flag = false;
        else
        if ((lista.isEmpty() && listb.isEmpty()) || (isPalindrome(lista) && isPalindrome(listb)))
            flag = true;
        else
            flag = false;
        return flag;
    }

    static int[] charFrequency(String str, int size) {
        int[] frequencies = new int[26];
        for (char c: str.toCharArray()) {
            frequencies[c - 'a']++;
        }
        return frequencies;
    }

    private static boolean isPalindrome(List < Integer > list) {
        int odd = 0;
        for (int i: list) {
            if ((i & 1) != 0) {
                odd++;
            }
        }
        return odd <= 1;
    }
}

/*
4
5 2
abcdd
ac
3 3
abc
xyz
2 4
aa
aaaa
1 3
a
aax

YES
NO
YES
NO
* */
