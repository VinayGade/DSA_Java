package dp.memoization;

/*
Partitions with Given Difference

Given an array arr, partition it into two subsets(possibly empty) such that each element must belong to only one subset.
Let the sum of the elements of these two subsets be S1 and S2.
Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference
between S1 and S2 is equal to d. Since the answer may be large return it modulo 109 + 7.

eg 1.
Input:
n = 4
d = 3
arr[] =  { 5, 2, 6, 4}
Output: 1
Explanation:
There is only one possible partition of this array. Partition : {6, 4}, {5, 2}.
The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.

Input:
n = 4
d = 0
arr[] = {1, 1, 1, 1}
Output: 6
Explanation:
we can choose two 1's from indices {0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3} put them in S1 and remaning two 1's in S2.
Thus there are total 6 ways for partition the array arr.
* */

public class PartitionsWithGivenDifference {

    public static int countPartitions(int n, int d, int[] arr) {

        int total = 0;
        for(int num: arr)
            total+=num;

        if((total+d) % 2 != 0 || total < d)
            return 0;

        int target = (total+d) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int num: arr){
            for(int i = target; i>= num; i--)
                dp[i] = (dp[i] + dp[i-num]) % 1000000007;
        }

        return dp[target];

    }

    public static void main(String[] args) {
        int n = 4;
        int d = 3;
        int a[] =  { 5, 2, 6, 4};

        int count = countPartitions(n, d, a);
        System.out.println(count);
    }
}
