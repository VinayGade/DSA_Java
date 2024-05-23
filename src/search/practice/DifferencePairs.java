package search.practice;

import java.util.Arrays;
import java.util.Scanner;

/*
Given array A of N integers and B
indices (i, j)
1<i<=j<=N
|(A[i]- A[j])| == B
* */

/*
* input
*
3
6 78
5 10 3 2 50 80
2 30
-10 20
4 5
1 2 3 4

output:
1
1
0
* */
public class DifferencePairs {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int B = sc.nextInt();
            B = Math.max(B, -B);
            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            Arrays.sort(A);

            int i = 0, j = 0, match = 0;
            while (i < N && j < N) {
                int D = A[j] - A[i];
                if (D == B) {
                    match = 1;
                    break;
                }else if (D > B)
                    i++;
                else
                    j++;
            }
            System.out.println(match);
        }
        sc.close();
    }
}
