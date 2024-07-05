package array.math;

// CpdeChef: Remove Element

import java.util.Scanner;

public class RemoveElement {

    static boolean removeElement(int[] a, int n, int k) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            smallest = Math.min(a[i], smallest);
            largest = Math.max(a[i], largest);
        }
        return n == 1 || (smallest + largest <= k);
    }

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            String result = removeElement(a, n, k) ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
