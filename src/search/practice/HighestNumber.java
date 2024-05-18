package search.practice;

import java.util.Arrays;
import java.util.List;

/*
Given an integer array a[] of size n, find the highest element of the array.
The array will either be strictly increasing or strictly increasing and then
strictly decreasing.

a[i] != a[i+1]

Input:
11
1 2 3 4 5 6 5 4 3 2 1
Output:
6
Explanation:
Highest element of array a[] is 6.

Input:
5
1 2 3 4 5
Output:
5
Explanation:
Highest element of array a[] is 5.
* */
public class HighestNumber {

    static int findPeakElement(List<Integer> a) {
        // binary search
        int n = a.size();
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid == (n-1)){
                high = mid-1;
                continue;
            } if(a.get(mid) < a.get(mid + 1))
                low = mid+1;
            else if(a.get(mid) >= a.get(mid+1))
                high = mid -1;
        }
        return a.get(low);
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1);
        int peak = findPeakElement(a);
        System.out.println("peak = "+peak);
    }
}
