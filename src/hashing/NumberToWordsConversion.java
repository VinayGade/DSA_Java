package hashing;

import java.util.HashMap;

/*

Convert the amount in number to words:  (Directi, Paypal)

Our company wants to create a data entry verification system.
Given an amount in words and an amount indicated by data entry person in numbers,
you have to detect whether the amounts are the same or not.

Note:
There are a lot of corner cases to be considered. The interviewer expects you to take care of them.
Every word needs to be separated using "-" rather than a space character https://en.wikipedia.org/wiki/Indian_numbering_system
"Use Expected Output option" to clear further doubts.

Problem Constraints
1 <= |A| <= 9
1 <= |B| <= 100

Example Input
String num = "1234"
String words = "one-thousand-two-hundred-and-thirty-four"

Example Output
1
* */

public class NumberToWordsConversion {

    public static int convertNumberToWords(String A, String B) {

        HashMap<String, Integer> mp = findNumberStrings();

        int ch = 0;
        int n = B.length();
        StringBuilder s = new StringBuilder();
        int p = 0;
        int x = 0;

        for (int i = 0; i < n; i++) {
            if (B.charAt(i) != '-') {
                s.append(B.charAt(i));
            }

            if (B.charAt(i) == '-' && i != n - 1) {
                if (s.toString().equals("and")) {
                    s.setLength(0);  // Clear the string builder
                    ch = 1;
                    continue;
                }

                if (!mp.containsKey(s.toString())) return 0;

                int value = mp.get(s.toString());
                if (value < 20) {
                    x += value;
                } else if (value >= 20 && value < 100) {
                    x += value;
                } else if (value >= 100) {
                    x *= value;
                    p += x;
                    x = 0;
                }
                s.setLength(0);  // Clear the string builder
            }
            if (i == n - 1 && B.charAt(i) != '-') {
                if (s.toString().equals("and")) {
                    s.setLength(0);  // Clear the string builder
                    continue;
                }
                if (!mp.containsKey(s.toString())) return 0;

                int value = mp.get(s.toString());
                if (value < 100) {
                    x += value;
                    if (A.length() > 3 && ch == 0) return 0;
                } else {
                    x *= value;
                }
                p += x;
            }
        }
        int p1 = Integer.parseInt(A);
        return (p == p1) ? 1 : 0;
    }

    private static HashMap<String, Integer> findNumberStrings(){
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("one", 1);
        mp.put("two", 2);
        mp.put("three", 3);
        mp.put("four", 4);
        mp.put("five", 5);
        mp.put("six", 6);
        mp.put("seven", 7);
        mp.put("eight", 8);
        mp.put("nine", 9);
        mp.put("ten", 10);
        mp.put("eleven", 11);
        mp.put("twelve", 12);
        mp.put("thirteen", 13);
        mp.put("fourteen", 14);
        mp.put("fifteen", 15);
        mp.put("sixteen", 16);
        mp.put("seventeen", 17);
        mp.put("eighteen", 18);
        mp.put("nineteen", 19);
        mp.put("twenty", 20);
        mp.put("thirty", 30);
        mp.put("forty", 40);
        mp.put("fifty", 50);
        mp.put("sixty", 60);
        mp.put("seventy", 70);
        mp.put("eighty", 80);
        mp.put("ninety", 90);
        mp.put("hundred", 100);
        mp.put("thousand", 1000);
        mp.put("lakh", 100000);
        mp.put("crore", 10000000);
        return mp;
    }

    public static void main(String[] args) {
        String num = "1234";
        String words = "one-thousand-two-hundred-and-thirty-four";
        int result = convertNumberToWords(num, words);
        String correct = (result == 1) ? "YES" : "NO";
        System.out.println(num + " = " +words+ " ? " +correct);
    }
}
