package array.math;

/*
Given an array arr[] where no two adjacent elements are same, find the index of a peak element.
An element is considered to be a peak if it is greater than its adjacent elements (if they exist).
If there are multiple peak elements, return index of any one of them.
The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".
Note: Consider the element before the first element and the element after the last element to be negative infinity.

Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

Input: arr = [10, 20, 15, 2, 23, 90, 80]
Output: true
Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6].

Input: arr = [1, 2, 3]
Output: true
Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.
* */

// if you find 1 such element return true
public class PeakElement {

    static boolean peak(int[] arr){
        int n = arr.length;
        int j = 0;
        int i = 1;
        int k = 2;
        while(i < n-1){
            if(arr[j] < arr[i] && arr[i] > arr[k]){
                return true;
            }
            j++;
            i++;
            k++;
        }
        return false;
    }

    //return index of the peak element
    static int peakElement(int[] arr){
        int n = arr.length;
        int j = 0;
        int i = 1;
        int k = 2;
        while(i < n-1){
            if(arr[j] < arr[i] && arr[i] > arr[k]){
                return j;
            }
            j++;
            i++;
            k++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 2, 23, 90, 80};
        boolean peak = peak(arr);
        System.out.println("contains peak?" +peak);
    }
}
