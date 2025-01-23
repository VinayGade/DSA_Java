package search.practice;

/*
LeetCode 441. Arranging Coins

You have n coins and you want to build a staircase with these coins.
The staircase consists of k rows where the ith row has exactly i coins.
The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

* */

public class ArrangingCoins {

    static int arrangeCoins(int n) {
        long low = 1, high = n;

        while(low <= high){
            long mid = low + (high-low)/2;
            long sum  = mid * (mid+1)/2;

            if(sum == n){
                return (int)mid;
            } else if(sum < n){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (int)high;
    }

    public static void main(String[] args) {
        int n = 8;
        int completeRows = arrangeCoins(n);
        System.out.println("number of complete rows of staircase: "+completeRows);
    }
}
