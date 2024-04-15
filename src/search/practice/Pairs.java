package search.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// HackerRank > Algorithms > Search > Pairs
public class Pairs {

    /*
    Given an array of integers and a target value, determine the number of pairs
    of array elements that have a difference equal to the target
    * */

    private boolean binarySearch(List<Integer> arr, int key) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == key)
                return true;
            if (arr.get(mid) < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public int pairs(int k, List<Integer> arr) {

        Collections.sort(arr);
        int min = Collections.min(arr);

        int result = 0;
        for (int i : arr) {
            int key = i - k;
            if (binarySearch(arr, key)) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 5, 3, 4, 2);
        int key = 2;

        Pairs p = new Pairs();
        int pairsCount = p.pairs(key, arr);
        System.out.println(pairsCount);
    }
}
