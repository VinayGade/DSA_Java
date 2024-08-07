package sort.codecademy;

import sort.common.CommonUtility;

import java.util.Scanner;

public class QuickSort extends CommonUtility {

    //Iterative partition
    public int partition(int[] arr, int leftPointer, int rightPointer) {
        int pivot = arr[Math.floorDiv((leftPointer + rightPointer), 2)];

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot) {
                leftPointer++;
            }
            while (arr[rightPointer] > pivot) {
                rightPointer--;
            }
            if (leftPointer < rightPointer) {
                swap(arr, leftPointer, rightPointer);
            }
        }
        return leftPointer;
    }

    //Recursive QuickSort
    public int[] quickSort(int[] arr, int start, int end) {
        if (end > start) {
            // Call partition
            int partition = partition(arr, start, end);

            // Recursive code on two sides of partition
            if(start < partition)
                quickSort(arr, start, partition);

            // recurse on right partition
            if((partition + 1) < end)
                quickSort(arr, partition + 1, end);
        }
        return arr; // Base case code
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int t = scanner.nextInt();

        QuickSort quick = new QuickSort();

        //while (t-- > 0) {

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++)
                a[i] = scanner.nextInt();

            System.out.println("Before Sort :");

            for (int i = 0; i < N; i++)
                System.out.print(a[i]+" ");

            int start = 0;
            int end = a.length-1;
            a = quick.quickSort(a, start, end);

            System.out.println("after Sort :");
            for (int i = 0; i < N; i++)
                System.out.println(a[i]);
        //}
    }
    /*
    public static void main(String[] args) {

        QuickSort quick = new QuickSort();

        int[] numbers ={100, 10, 90, 80, 30, 50 ,70, 40, 1};
        System.out.println("Before Sort :");
        quick.display(numbers);
        int end = numbers.length-1;

        numbers = quick.quickSort(numbers, 0, end);

        System.out.println("Quick Sort :");
        quick.display(numbers);
    }
     */
}
