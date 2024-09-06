package sort.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int frequency = Collections.frequency(arr, i);
            myList.add(frequency);
        }
        return myList;
    }

    public static List<Integer> countingSortFunctional(List<Integer> arr) {
        // Write your code here
        Integer[] sortingArray = new Integer[100];
        Arrays.fill(sortingArray, 0);

        arr.forEach(i -> sortingArray[i]++);

        return Arrays.asList(sortingArray);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 3, 2, 1);
        List<Integer> sorted = countingSort(arr);

        List<Integer> sortedArr = countingSortFunctional(arr);
        System.out.println(sortedArr);
    }
}
