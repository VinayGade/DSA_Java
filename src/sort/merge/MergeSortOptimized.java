package sort.merge;

import java.util.Scanner;

public class MergeSortOptimized {

    // Create auxiliary array (with same length of original array)
    // less time and memory efficient than merge sort with 2 sub-arrays (if array is too big).
    public static void mergeSort(int[] a, int[] aux, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, aux, left, mid);
            mergeSort(a, aux, mid + 1, right);
            merge(a, aux, left, mid, right);
        }
    }

    private static void merge(int[] a, int[] aux, int left, int mid, int right) {

        // Copy both halves into auxiliary array
        for (int i = left; i <= right; i++) {
            aux[i] = a[i];
        }

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid) { // Left half is exhausted
                a[k] = aux[j++];
            } else if (j > right) { // Right half is exhausted
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) { // Left element is smaller
                a[k] = aux[i++];
            } else { // Right element is smaller
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] a = new int[N];

        int[] aux = new int[N]; // Create auxiliary array once

        for (int i = 0; i < N; i++)
            a[i] = scanner.nextInt();

        mergeSort(a, aux, 0, N - 1);

        for (int i = 0; i < N; i++)
            System.out.println(a[i]);
    }
}
