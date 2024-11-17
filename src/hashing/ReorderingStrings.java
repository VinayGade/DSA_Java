package hashing;

//CodeChef: Reordering Strings

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
input:

2
abcdefghijklmnopqrstuvwxyz
3
aaa
aa
abc
cdefghijklabmnopqrstuvwxyz
3
cdef
cjkl
abm

output:

aa
aaa
abc
cdef
cjkl
abm
* */

public class ReorderingStrings {

    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t--> 0) {
            String s = scanner.next();
            int n = scanner.nextInt();
            String arr[] = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
            }
            sort(arr, s);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }
    public static void sort(String[] arr, String s) {
        HashMap< Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < 26; i++) {
            map.put(s.charAt(i), i);
        }
        Arrays.sort(arr, (x, y) -> {
            for (int i = 0; i < Math.min(x.length(), y.length()); i++) {
                if (x.charAt(i) != y.charAt(i))
                    return map.get(x.charAt(i)) - map.get(y.charAt(i));
            }
            return x.length() - y.length();
        });
    }
}
