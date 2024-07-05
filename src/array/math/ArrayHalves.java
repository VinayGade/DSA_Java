package array.math;

import java.util.Scanner;

//CodeChef: Array Halves

public class ArrayHalves {

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            n *= 2;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            long count = countShifts(a, n);
            System.out.println(count);
        }
    }

    static long countShifts(int[] a, int n) {
        long res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > (n / 2))
                count++;
            else
                res += count;
        }
        return res;
    }
}
