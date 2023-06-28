package sort;

public class MergeSortGPT {

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length - mid];

        System.arraycopy(arr, 0, leftHalf, 0, mid);
        System.arraycopy(arr, mid, rightHalf, 0, arr.length - mid);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < left.length) {
            arr[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < right.length) {
            arr[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 3, 7};

        mergeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
