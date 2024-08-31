package array.math.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxKSumPairs {

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        // count the number of operations
        int answer = 0;

        while (left < right) {
            // Calculate the sum of the two-pointer elements
            int sum = nums[left] + nums[right];

            if (sum == k) {
                // If sum == key, pair found.
                ++answer;

                ++left;
                --right;
            } else if (sum > k) {
                // If the sum is greater than k, we need to decrease the sum
                // We do this by moving the right pointer to the left
                --right;
            } else {
                // If the sum is less than k, we need to increase the sum
                // We do this by moving the left pointer to the right
                ++left;
            }
        }
        return answer;
    }

    public int maxOperations(int k, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<nums.length; i++){

            //check if map contains k - nums[i]
            int key = k - nums[i];
            if(map.containsKey(key) && map.get(key) > 0){
                count++;
                map.put(key, map.get(key)-1);
            }else
                map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }
        return count;
    }

    public int maxOperations(int[] nums, int n, int k) {
        int ans = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (final int num : nums)
            count.merge(num, 1, Integer::sum);

        for (final int num : count.keySet()) {
            final int complement = k - num;
            if (count.containsKey(complement))
                ans += Math.min(count.get(num), count.get(complement));
        }
        return ans / 2;
    }


}
