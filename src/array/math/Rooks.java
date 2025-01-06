package array.math;

import java.util.Scanner;

//CodeChef: Heaps: Rooks
public class Rooks {

    static final int MAXN = (int)1e6 + 10;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while(--T >= 0){
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            boolean[][] mark = new boolean[2][MAXN];

            for (int i = 0; i < K; i++){
                int r = scanner.nextInt() - 1;
                int c = scanner.nextInt() - 1;
                mark[0][r] = true;
                mark[1][c] = true;
            }

            System.out.print((N - K) + " ");
            int p1 = 0, p2 = 0;

            for (int i = 0; i < (N - K); i++) {
                while (mark[0][p1]) p1++;
                while (mark[1][p2]) p2++;
                System.out.print((p1 + 1) + " " + (p2 + 1) + " ");
                p1++;
                p2++;
            }
            System.out.println();
        }
        scanner.close();
    }
}
