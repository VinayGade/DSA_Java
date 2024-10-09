package array.math.two_pointers;

import java.util.Arrays;
import java.util.Scanner;

// Largest Common Element in Two Arrays
/*
You are given two arrays of positive integers arr1, arr2. |arr1| = n, |arr2| = m
Your task is to find the largest common element that appears in both arrays.
If no common element exists, return -1

input:
5 6
1 3 4 6 7
2 3 5 6 7 8

Output:
7

Input:
4 3
1 2 3 4
5 6 7

Output:
-1
* */
public class LargestCommonElement {

    public static int largestCommonElement(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1[n - 1] < arr2[0] || arr2[m - 1] < arr1[0])
            return -1;
        else if (arr1[n - 1] == arr2[0])
            return arr2[0];
        else if (arr2[m - 1] == arr1[0])
            return arr1[0];
        else {
            int i = n - 1;
            int j = m - 1;

            while (i >= 0 && j >= 0) {
                if (arr1[i] == arr2[j]){
                    return arr1[i];
                }else if(arr1[i] > arr2[j])
                    i--;
                else // if(arr1[i] < arr2[j])
                    j--;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        System.out.println(largestCommonElement(arr1, arr2));
    }
}
