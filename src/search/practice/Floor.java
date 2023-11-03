package search.practice;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

//Floor in a Sorted Array

/*
Given a sorted array arr[] of size N without duplicates, and given a value x.
Floor of x is defined as the largest element K in arr[] such that K is smaller than
or equal to x. Find the index of K(0-based indexing).
* */
public class Floor {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        // binary search
        int low=0;
        int high=n-1;
        int floor=-1;
        int mid;

        if(n==0 || x < arr[0])
            return -1;

        while(low <= high){
            mid = (low+high)/2;
            if(arr[mid] == x)
                return mid;

            if(arr[mid] < x){
                floor = mid;
                low = mid+1;
                /*
                high = mid-1;
                if(high < x){
                   floor = high;
                   break;
                }
                */
            }else
                high = mid-1;

            /*else if(arr[mid] > x){
                low=mid+1;
            }*/
        }
        return floor;
    }
    public static void main (String[] args)throws IOException {

        int n=7, x=0;
        long arr[] = {1,2,8,10,11,12,19};
        int floor1 = findFloor(arr, n, x);

        long[] arr2 = {1,2,8,10,11,12,19};
        x=5;
        int floor2 = findFloor(arr2, n, x);

        System.out.println("floor1="+floor1+", floor2="+floor2);
    }

}
