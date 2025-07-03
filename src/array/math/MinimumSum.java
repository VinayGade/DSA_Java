package array.math;

import java.util.Arrays;

/*
Minimum sum:

Given an array arr[ ] consisting of digits,
your task is to form two numbers using all the digits such that their sum is minimized.
Return the minimum possible sum as a string with no leading zeroes.

Input: arr[] = [6, 8, 4, 5, 2, 3]
Output: "604"
Explanation: The minimum sum is formed by numbers 358 and 246.

Input: arr[] = [5, 3, 0, 7, 4]
Output: "82"
Explanation: The minimum sum is formed by numbers 35 and 047.

Input: arr[] = [9, 4]
Output: "13"
Explanation: The minimum sum is formed by numbers 9 and 4.
* */

public class MinimumSum {

    static String minSum(int[] arr) {

        int n = arr.length;
        int sum = 0;

        if(n == 2){
            sum = arr[0] + arr[1];
            return Integer.toString(sum);
        }
        Arrays.sort(arr);

        // incorrect
        /*
        String n1 = "";
        String n2 = "";

        int i = 0;
        int j = 1;
        while(j < n){

            n1 += arr[i];
            n2 += arr[j];
            i+=2;
            j+=2;
        }

        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);

        sum = num1 + num2;

        return Integer.toString(sum);*/

        int start = 0;
        // To avoid multiple zeroes in arr
        while(start < n && arr[start] == 0) {
            start++;
        }
        StringBuilder res = new StringBuilder();

        int i=n-1;
        int carry = 0;
        while(i > start) {
            sum = arr[i] + arr[i-1] + carry;
            res.append(sum % 10);

            carry = sum/10;

            i-=2;
        }
        if(i == start) {
            sum = arr[start] + carry;
            res.append(sum%10);
            carry = sum/10;
        }
        if(carry > 0) {
            res.append(carry);
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {

        int[] arr = {6, 8, 4, 5, 2, 3};

        String sum = minSum(arr);

        System.out.println(sum);
    }
}
