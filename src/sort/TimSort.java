package sort;

import sort.common.CommonUtility;

public class TimSort extends CommonUtility {

    static final int MIN_MERGE = 32;

    public void timSort(int arr[], int n)
    {
        for (int i = 0; i < n; i += MIN_MERGE)
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));

        for (int size = MIN_MERGE; size < n; size = 2 * size) {

            for (int left = 0; left < n; left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    public void insertionSort(int[] a, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= left && temp < a[j]) {
                a[j + 1] = a[j]; // right shift array
                j--;
            }
            a[j + 1] = temp;
            //i++;
            //right part is sorted hence don't move i'th pointer.
        }
    }

    public void merge(int[] a, int l, int mid, int r) {

        int leftLength = mid - l + 1;
        int rightLength = r - mid;

        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for (int i = 0; i < leftLength; i++)
            left[i] = a[l + i];

        for (int i = 0; i < rightLength; i++)
            right[i] = a[(mid + 1) + i];

        int i = 0;
        int j = 0;
        int k = l;

        while (i < leftLength && j < rightLength) {

            if (left[i] < right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] arr = { -2, 7,  100,  -12, 0, 50, 6, 1, 9, -80, -200, -89, 512, 1024, 10, 1630, 1857, 1307,
                -7, -4, -13, 5, 8, -14, 12, 200, 240, 420, 360};
        int n = arr.length;
        System.out.println("Given Array is");

        TimSort sort = new TimSort();

        sort.display(arr);

        sort.timSort(arr, n);

        System.out.println("After Sorting Array is");
        sort.display(arr);
    }
}