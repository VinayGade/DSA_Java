package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Sorted Insert Position

Given a sorted array A and a target value B, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Input 1:

 A = [1, 3, 5, 6]
B = 5

Input 2:

 A = [1, 3, 5, 6]
B = 2

Input 2:

 A = [1, 3, 5, 6]
B = 7

Output 1: 2
Output 2: 1
Output 3: 4
* */

public class InsertPosition {

    public static int searchInsert(List<Integer> a, int b) {
        int start=0;
        int end=a.size()-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if(a.get(mid)==b)
                return mid;
            else if(a.get(mid)<b)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 3, 5, 6);
        int b = 5;
        int position = searchInsert(a, b);
        System.out.println("position of "+b+"="+position);

        b = 2;
        position = searchInsert(a, b);
        System.out.println("position of "+b+"="+position);

        b = 7;
        position = searchInsert(a, b);
        System.out.println("position of "+b+"="+position);
    }
}
