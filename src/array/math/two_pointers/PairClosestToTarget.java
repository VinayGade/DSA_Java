package array.math.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Sum Pair closest to target: 2 - pointers

Given an array arr[] and a number target, find a pair of elements (a, b) in arr[],
where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair
with maximum absolute difference. If no such pair exists return an empty array.

 arr[] = [10, 30, 20, 5], target = 25
 pair = [5, 20]

 arr[] = [5, 2, 7, 1, 4], target = 10
 pair = [2, 7]
* */
public class PairClosestToTarget {

    public static List<Integer> sumClosest(int[] arr, int target) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int d = Integer.MAX_VALUE;
        int i=0;
        int n = arr.length;
        int j = n-1;

        Arrays.sort(arr);

        ArrayList<Integer> solution = new ArrayList<>();

        while(i < j){
            int sum = arr[i] + arr[j];
            int key = Math.abs(sum-target);
            if(key < d){
                d = key;
                first = arr[i];
                second = arr[j];
            }
            if(sum < target)
                i++;
            else
                j--;
        }

        if(first >= 0 && second >= 0){
            solution.add(first);
            solution.add(second);
        }

        return solution;
    }

    public static void main(String[] args) {
        // arr[] = [10, 30, 20, 5], target = 25

        int arr[] = {10, 30, 20, 5};
        int target = 25;

        List<Integer> pair = sumClosest(arr, target);
        System.out.println("target = "+target);
        System.out.println("arr1 :");
        for(int x: arr)
            System.out.print(x+" ");
        System.out.println();
        System.out.println(pair.get(0) +" "+ pair.get(1));

        // arr[] = [5, 2, 7, 1, 4], target = 10

        int arr2[] = {5, 2, 7, 1, 4};
        target = 10;

        pair = sumClosest(arr2, target);

        System.out.println("\ntarget = "+target);
        System.out.println("arr2 :");
        for(int y: arr2)
            System.out.print(y+" ");
        System.out.println();
        System.out.println(pair.get(0) +" "+ pair.get(1));
    }
}
