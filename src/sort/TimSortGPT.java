package sort;
import java.util.Arrays;

public class TimSortGPT {

    private static final int MIN_MERGE = 32;

    public static void timSort(int[] arr) {
        int n = arr.length;
        int minRun = minRunLength(MIN_MERGE, n);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min(i + minRun - 1, n - 1));
        }

        for (int size = minRun; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                merge(arr, left, mid, right);
            }
        }
    }

    private static int minRunLength(int minMerge, int n) {
        int r = 0;
        while (n >= minMerge) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        for (int i = 0; i < len1; i++)
            leftArr[i] = arr[left + i];
        for (int i = 0; i < len2; i++)
            rightArr[i] = arr[mid + i + 1];

        int i = 0, j = 0;
        int k = left;

        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10, 4, 75, 1, 6, 50, 100, 20, 11, 7, 40, 150, -70,
        105, 60, 70, 800, 5, 12, 13, 0, -10, -98, 420, 500, 1200, 450, -1000, 19, 39, 99, 2, -8};
        System.out.println("Original array: " + Arrays.toString(arr));
        timSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

