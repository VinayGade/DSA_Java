package search.practice;

import java.util.Scanner;

public class SubString {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            String s1 = scanner.next();
            String s2 = scanner.next();

            String result = isSubstring(s1, s2) ? "YES" : "NO";

            // String result = s1.contains(s2) ? "YES" : "NO";
            // in built String API function: public boolean contains(CharSequence s)

            System.out.println(result);
        }
    }

    static boolean isSubstring(String S1, String S2){
        int n = S1.length();
        int m = S2.length();

        for (int i = 0; i <= n - m; i++) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (S1.charAt(i + j) != S2.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if(found)
                return true;
        }
        return false;
    }
}

/*
input:
4
hello
ell
codechef
chef
programming
debug
abcd
efgh

output:
YES
YES
NO
NO
* */
