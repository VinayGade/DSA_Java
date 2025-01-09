package array.math.sliding_window;

import java.util.ArrayList;
import java.util.List;

/*
Indexes of Subarray Sum

Given an array arr[] containing only non-negative integers,
your task is to find a continuous subarray (a contiguous sequence of elements)
whose sum equals a specified value target. You need to return the 1-based indices of
the leftmost and rightmost elements of this subarray.
You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].
* */

public class SubarraySum {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int prev=0,sum=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            while( prev<i && sum>target){
                sum-=arr[prev];
                prev++;
            }
            if(sum==target){
                ans.add(prev+1);
                ans.add(i+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int target, int n) {
        int prev=0,sum=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            while( prev<i && sum>target){
                sum-=arr[prev];
                prev++;
            }
            if(sum==target){
                ans.add(prev+1);
                ans.add(i+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 15;

        //arr[] = [1, 2, 3, 7, 5], target = 12

        List<Integer> subArray = subarraySum(arr, target, arr.length);
        for(int x: subArray)
            System.out.print(" "+x);
    }
}
