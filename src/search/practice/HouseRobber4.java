package search.practice;

//LeetCode 2560. House Robber IV

/*
There are several consecutive houses along a street, each of which has some money inside.
There is also a robber, who wants to steal money from the homes, but he refuses to steal from
adjacent homes.

The capability of the robber is the maximum amount of money he steals from one house of all
the houses he robbed.

You are given an integer array nums representing how much money is stashed in each house.
More formally, the ith house from the left has nums[i] dollars.

You are also given an integer k, representing the minimum number of houses the robber will
steal from. It is always possible to steal at least k houses.

Return the minimum capability of the robber out of all the possible ways to steal at least
 k houses.

 Example 1:

Input: nums = [2,3,5,9], k = 2
Output: 5
Explanation:
There are three ways to rob at least 2 houses:
- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
Therefore, we return min(5, 9, 9) = 5.
Example 2:

Input: nums = [2,7,9,3,1], k = 2
Output: 2
Explanation: There are 7 ways to rob the houses. The way which leads to minimum capability is to rob the house at index 0 and 4. Return max(nums[0], nums[4]) = 2.

* */
public class HouseRobber4 {

    public static int minCapability(int[] nums, int k) {
        // find the range of the possible capabilities
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // binary search
        int start = min, end = max;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isPossible(nums, mid, k)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isPossible(int[] nums, int target, int k) {
        // greedy here
        int lastStolenIndex = -2;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= target && lastStolenIndex + 1 < i) {
                k -= 1;
                lastStolenIndex = i;
                if (k == 0) return true;
            }
        }
        return false;
    }

    public int minCapabilityOptimum(int[] nums, int k) {
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;

        for(int it : nums){
            lo = Math.min(lo, it);
            hi = Math.max(hi, it);
        }

        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(check(nums,k,mid)){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }

        return lo;
    }

    private boolean check(int[] nums, int k, int val){
        int ct = 0;

        for(int i = 0;i < nums.length;i++){
            if(nums[i] <= val){
                i++;
                ct++;
                if(ct == k) return true;
            }
        }

        return ct >= k;
    }

    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};
        int k = 2;
        int minCapacity = minCapability(nums, k);
        System.out.println("Minimum capacity of house robber ="+minCapacity);
    }
}
