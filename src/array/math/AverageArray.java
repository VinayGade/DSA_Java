package array.math;

import java.util.Scanner;

/*
You are given two integers N, X.
Output: int A[] ...| A | = N
All A[i] are distinct ... no duplicates
X = mean(A)

eg. X = mean(A) = 4,   N = 4

A = [3, 1, 4, 8]   ...(( 3 + 1 + 4 + 8 )/4) = 4

Input
3
3 7
5 1
1 10

Output
5 10 6
1 2 3 4 -5
10
*/
public class AverageArray {

    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (--T >= 0) {
            int N = scan.nextInt();
            int X = scan.nextInt(); //mean
            int[] a = findElements(N, X);

            for(int i=0; i<N-1; i++){
                System.out.print(a[i]+" ");
            }
            System.out.print(a[N-1]);
            System.out.println();
        }
    }

    static int[] findElements(int n, int x) {
        int[] a = new int[n];
        if (n == 1) {
            a[0] = x;
        } else {
            int index = 0;
            for (int i = 1; i <= (n / 2); i++) {
                a[index++] = x - i;
                //index++;
            }
            if (n % 2 == 1) { // odd length
                a[index++] = x;
            }
            for (int i = 1; i <= (n / 2); i++) {
                a[index++] = x + i;
                //index++;
            }
        }
        return a;
    }

}
