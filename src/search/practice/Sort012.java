package search.practice;

/*
Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.

Input: arr[]= [0, 2, 1, 2, 0]
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated into ascending order.

Input: arr[] = [0, 1, 0]
Output: 0 0 1
Explanation: 0s 1s and 2s are segregated into ascending order.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort012 {

    // Function to sort an array of 0s, 1s, and 2s
    static void sort012(List<Integer> arr) {

        int low=0;
        int mid=0;
        int high=arr.size()-1;
        while(mid<= high){
            if(arr.get(mid)==0) {
                Collections.swap(arr,low,mid);
                mid++;low++;
            }
            else if(arr.get(mid)==1)
                mid++;
            else if(arr.get(mid)==2) {
                Collections.swap(arr,mid,high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 2, 1, 2, 0);
        sort012(list);
        list.forEach(System.out::println);
    }
}
