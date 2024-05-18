package search.practice;

import java.util.ArrayList;
import java.util.Collections;

//Leaders in array

/*
Given an array A of positive integers. Your task is to find the leaders in the array.
An element of array is a leader if it is greater than or equal to all the elements
to its right side. The rightmost element is always a leader.

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17
as it is greater than all the elements
to its right.  Similarly, the next
leader is 5. The right most element
is always a leader so it is also
included.

n = 5
A[] = {1,2,3,4,0}
Output: 4 0
* */

public class Leaders {

    static ArrayList<Integer> leaders(int arr[], int n){
        int max = arr[n-1];
        ArrayList<Integer> leadersList = new ArrayList<>();
        leadersList.add(max); //since last element will be always there in leaders.
        for(int i=n-1; i>=0; i--){
            if(max <= arr[i] && arr[i]!=arr[n-1]){  //max = Math.max(max, arr[i]);
                leadersList.add(arr[i]);
                max=arr[i];
            }
        }
        Collections.reverse(leadersList);
        return leadersList;
    }

    public static void main(String[] args) {
        int A[] = {16,17,4,3,5,2};
        ArrayList<Integer> leaders = leaders(A, A.length);
        leaders.forEach(System.out::println);
    }
}
