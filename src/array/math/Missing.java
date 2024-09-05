package array.math;

import java.util.Arrays;

/*
Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive),
find the missing element.
The array is a permutation of size n with one element missing.
Return the missing element.

Input: n = 5, arr[] = [1,2,3,5]
Output: 4
Explanation : All the numbers from 1 to 5 are present except 4.
* */

public class Missing {

    // Note that the size of the array is n-1
    static int missingNumber(int n, int arr[]) {

        int missing = 0;
        Arrays.sort(arr);
        for(int i=0; i<(n-1); i++){
            if(arr[0] > 1)
                return 1;
            if(i == (n-2)){
                missing = arr[i] + 1;
                break;
            }
            if(arr[i+1] - arr[i] > 1){
                missing = arr[i] + 1;
                break;
            }
        }
        return missing;
    }

    static int missingNumber2(int array[], int n) {

        int sum1=0;
        for(int i=1;i<=n;i++)
            sum1=sum1+i;

        int sum2=0;
        for(int i=0;i<n-1;i++)
            sum2=sum2+array[i];

        return sum1-sum2;
    }

    /*
    Mathematical Induction:

    1 + 2 + 3 + … … … + n = [n(n+1)/2]
    * */

    static int missingNumber(int array[], int n) {
        int n_elements_sum = n * (n + 1) / 2;
        int sum = 0;

        for(int i = 0; i < n - 1; i++)
            sum += array[i];

        return n_elements_sum - sum;
    }

    public static void main(String[] args) {

        int n=15;
        int[] arr = {10, 15, 12, 1, 2, 5, 6, 7, 9, 3, 4, 14, 13, 8};
        int missing = missingNumber(n, arr);
        System.out.println(missing);

        System.out.println("\nFind missing number using Mathematical Induction: ");
        int missingNumber = missingNumber(arr, n);
        System.out.println(missingNumber);
    }
}