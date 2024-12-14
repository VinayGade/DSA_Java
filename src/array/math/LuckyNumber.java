package array.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//CodeChef: Lucky Number
/*
Chef calls a number lucky if it contains the digit 7 at least once.

Input:
4
6
478
2090
77777

Output:
NO
YES
NO
YES
* */
public class LuckyNumber {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            String result = luckyNumber(x) ? "YES" : "NO";
            System.out.println(result);
        }
    }

    public static boolean luckyNumber(int n) {

        List< Integer > digits = new ArrayList< >();
        // reversed number
        //int rev = 0;
        // remainder
        int rem;

        while (n > 0) {
            rem = n % 10;
            digits.add(rem);
            //rev = (rev * 10) + rem;
            n = n / 10;
        }

        return digits.contains(7);
    }
}
