package array.math;

/*
Chef wonders if it is possible to choose exactly two numbers out of the three numbers
such that their sum is odd.
* */

import java.util.Scanner;

public class OddSumPair {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            String result = oddSum(a, b, c) ? "YES":"NO";
            System.out.println(result);
        }
    }

    static boolean oddSum(int a, int b, int c){
        if((a+b)%2!=0)
            return true;
        else if((a+c)%2!=0)
            return true;
        else return (b + c) % 2 != 0;
    }
}