package dp.tabulation;

/*

LIS = A sequence of numbers is called "strictly increasing" when each term in the sequence
 is smaller than the term that comes after it.

find ( | LIS | )

Input: n = 16, a[ ] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 6
Explanation: There are more than one LIS in this array.
One such Longest increasing subsequence is {0,2,6,9,13,15}.

Input: n = 6, a[ ] = {5,8,3,7,9,1}
Output: 3
Explanation: There are more than one LIS in this array.
One such Longest increasing subsequence is {5,7,9}.

* */

import java.util.*;

public class LIS {

    static int lengthLIS(int n, int a[]) {

        int[] LIS = new int[n];

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(a[i] > a[j])
                    if((LIS[j] + 1) > LIS[i])
                        LIS[i] = LIS[j] + 1;
            }
        }

        // find Max value
        int maxIndex = 0;

        for(int i=0; i<n; i++){ // LIS.length == n
            if(LIS[i] > LIS[maxIndex])
                maxIndex = i;
        }
        return LIS[maxIndex] + 1;
    }

    // Tabulation
    static int lengthLIS_Optimized(int n, int[] a){
        int largestMax = 0;

        int LIS[] = new int[n];
        LIS[0] = 1;             // LIS = 1  for n == 1

        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(a[j] < a[i]){
                    if(LIS[j] > max)
                        max = LIS[j];
                }
            }
            LIS[i] = max + 1;
            if(LIS[i] > largestMax)
                largestMax = LIS[i];
        }
        return largestMax;
    }

    // 2-D dynamic programming
    public int lengthLIS_dp(int n, int[] nums) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }

    // Binary Search
    public static int lengthOfLIS(int[] nums) {

        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public static int lengthOfLIS(int[] nums, int n) {
        int[] dp = new int[n];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0)
                i = -(i + 1);
            dp[i] = x;
            if(i == len)
                len++;
        }
        return len;
    }

    public int lengthOfLIS_binarySearch(int n, int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -idx - 1;

            if (idx == lis.size()) {
                lis.add(num);
            } else {
                lis.set(idx, num);
            }
        }
        return lis.size();
    }


    // using TreeSet
    public int lengthOfLIS(int n,int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int i : nums) {
            Integer ceil = set.ceiling(i);
            if(null != ceil) {
                set.remove(ceil);
            }
            set.add(i);
        }
        return set.size();
    }

    public static void main(String[] args) {

        int a[ ] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};

        int n = a.length;

        int sizeOfLIS = lengthLIS(n, a);

        System.out.println(sizeOfLIS);

        int sizeLIS = lengthLIS_Optimized(n, a);

        System.out.println(sizeLIS);

        System.out.println("Using Binary Search and Tabulation:");

        int size = lengthOfLIS(a, n);

        System.out.println(size);
    }
}
