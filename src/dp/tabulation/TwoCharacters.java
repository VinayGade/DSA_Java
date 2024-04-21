package dp.tabulation;

import java.util.Scanner;

/*
HackerRank : TwoCharacters ->

Given a string, remove characters until the string is made up of any two alternating characters.
When you choose a character to remove, all instances of that character must be removed.
Determine the longest string possible that contains just two alternating letters.

eg.
str = 'beabeefeab'
set = [b, a, e, f]
res = 'babab'
* */
public class TwoCharacters {

    public static final int NUM_LETTERS = 26;

    public static void main(String[] args) {

        /* Save input */
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        String str = scan.next();
        scan.close();

        /* Edge case */
        if (length <= 1) {
            System.out.println(0);
            return;
        }

        /* Create arrays representing the 26^2 subproblems */
        int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
        int[][] count = new int[NUM_LETTERS][NUM_LETTERS];

        for (int i = 0; i < length; i++) {
            char letter = str.charAt(i);
            int letterNum = letter - 'a';

            /* Update row */
            for (int col = 0; col < NUM_LETTERS; col++) {
                if (pair[letterNum][col] == letter) {
                    count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }

            /* Update column */
            for (int row = 0; row < NUM_LETTERS; row++) {
                if (pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }

        /* Find max in "count" array */
        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++) {
            for (int col = 0; col < NUM_LETTERS; col++) {
                max = Math.max(max, count[row][col]);
            }
        }
        System.out.println(max);
    }
}
