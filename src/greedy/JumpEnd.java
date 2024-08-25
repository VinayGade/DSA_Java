package greedy;

import java.util.Scanner;

public class JumpEnd {

    /*
    Jump to the End

    You are given a sequence of nonnegative integers. You are given a sequence of nonnegative integers A1, A2, ..., An.
    There is a pawn placed on the first element of the sequence, i.e. at position 1.
    When the pawn is on the position numbered with x, it can jump at most Ax places to the right.
    If Ax > 0, pawn can jump to any position from x + 1 to x + Ax. If Ax == 0, pawn cannot move.

    Find the maximum possible number of jumps using which it is possible to place the pawn on the last position.
    the position numbered with N or determine that it is impossible to reach it.

input 1:
4
2
1 0
3
0 1 0
5
2 0 1 1 0
6
2 2 2 2 1 0

output 1:
1
-1
3
5

input 2:
3
7
4 0 1 0 2 0 0
4
3 1 0 0
6
3 0 0 1 0 0

Output 2:
2
1
-1
    * */

    static int jumpToEnd(int[] a, int n) {

        // initially goal = last index
        int goal = n - 1;
        int jumpCount = 0;

        // start with 2nd last index
        // update the goal flag.
        for (int i = n - 2; i >= 0; i--) {
            if (i + a[i] >= goal) {
                jumpCount++;
                goal = i;
            }
        }

        //if we reach the first index jump count is correct
        // else return -1
        return (goal == 0) ? jumpCount : -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++)
                a[i] = scanner.nextInt();

            int jumpCount = jumpToEnd(a, N);
            System.out.println(jumpCount);
        }
    }
}
