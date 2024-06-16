package recursion;

import java.util.Scanner;

// Codechef ; Dazzling GCD Pair

/*
Given two positive integers A and B, find two positive integers 𝑖, j such that:

gcd(i, j) > 1
A <= i <= j <= B
(i+j) should be minimum possible value.

input:
2
2 3
2 10

output:
-1
2 4

Test case 1: There exists no pair satisfying all the conditions.
Test case 2: gcd(2, 4) > 1, (i+j) = (2+4) = 6
* */

public class GCDPair {

    static int[] gcdPair(int a, int b){
        int[] pair = new int[2];
        if(a%2==0){
            if ((b - a) < 2) {
                pair[0] = pair[1] = -1;
            }else{
                pair[0] = a;
                pair[1] = a+2;
            }
        }else {
            if ((b - a) < 3) {
                pair[0] = pair[1] = -1;
            } else if (a % 3 == 0) {
                pair[0] = a;
                pair[1] = a + 3;
            } else {
                pair[0] = a + 1;
                pair[1] = a + 3;
            }
        }
        return pair;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            //int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] pair = gcdPair(a, b);
            if(pair[0] == -1)
                System.out.println(-1);
            else
                System.out.println(pair[0]+" "+pair[1]);
        }
    }
}
