package array.math.two_pointers;

import java.util.Arrays;
import java.util.Scanner;

/*
CodeChef: Greedy Algorithms : Evacuate to Moon
* */

public class Evacuate2Moon {

    static long calculateEnergy(int N, int M, long H, long[] C, long[] O) {

        long totalEnergy = 0;

        Arrays.sort(C);
        Arrays.sort(O);

        int endC = N - 1;
        int endO = M - 1;

        while (endC >= 0 && endO >= 0) {
            long capacity = C[endC];
            long outerCap = O[endO];
            totalEnergy += Math.min(capacity, H * outerCap);
            endC--;
            endO--;
        }

        /*
        long totalEnergy2 = 0;
        int lowC = 0;
        int lowO = 0;

        while (endC < N && endO < M) {
            long capacity = C[lowC];
            long outlerCap = O[lowO];
            totalEnergy2 += Math.min(capacity, H * outlerCap);
            lowC++;
            lowO++;
        }

        totalEnergy = Math.max(totalEnergy1, totalEnergy2);
        */

        return totalEnergy;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt(); // car count
            int M = scanner.nextInt(); // power outlet count
            long H = scanner.nextInt(); // number of hours

            long[] C = new long[N];
            long[] O = new long[M]; // power outlet

            for (int i = 0; i < N; i++)
                C[i] = scanner.nextLong();

            for (int j = 0; j < M; j++)
                O[j] = scanner.nextLong();

            long totalEnergy = calculateEnergy(N, M, H, C, O);
            System.out.println(totalEnergy);
        }
    }
}
