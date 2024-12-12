package array.math;

import java.util.Scanner;
import java.util.Stack;

public class PairwiseDifferentInteger {

    /*
    CodeChef: Find Integer

    You are given an integer X
    ind the smallest number Y such that
    Y > X
    All digits of Y are pairwise different.

    input:
3
5
9
990

Output:
6
10
1023
    * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++)
        {
            int x = sc.nextInt();
            x++;
            while (numb(x) == false)
            {
                x++;
            }
            System.out.println(x);
        }
    }

    static boolean numb(int n){
        Stack<Integer> st = new Stack<>();

        while(n>0)
        {
            int digit = n%10;
            if(st.contains(digit))
            {
                return false;
            }
            st.push(digit);
            n = n/10;
        }
        return true;
    }
}
