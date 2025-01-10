package array.math.sliding_window;

import java.util.ArrayList;
import java.util.HashSet;

/*
Count Distinct elements in each window of size k

Given an integer array arr[] and a number k. Find the count of distinct elements in
every window of size k in the array.

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1.
* */

public class CountDistinctWindow {

    static ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<=n-k;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(arr[j]);
            }
            int len=set.size();
            res.add(len);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        ArrayList<Integer> counts = countDistinct(arr, k);
        for(int count :  counts){
            System.out.print(count+" ");
        }
    }
}
