package recursion;

public class GCDSubArray {

    // LeetCode 2447. Number of Subarrays With GCD Equal to K
    /*
    *
Input: nums = [9,3,1,2,6,3], k = 3
Output: 4
*
Explanation:
The subarrays of nums where 3 is the greatest common divisor
of all the subarray's elements are:
- [9,3,1,2,6,3]
- [9,3,1,2,6,3]
- [9,3,1,2,6,3]
- [9,3,1,2,6,3]

Example 2:

Input: nums = [4], k = 7
Output: 0
Explanation:
There are no subarrays of nums
where 7 is the greatest common divisor of all the subarray's elements.
    * */
    public int subarrayGCD(int[] nums, int k) {
        int subArrCount = 0;
        for(int i=0; i<nums.length; i++) {

            int multiple=nums[i];
            if(multiple==k)
                subArrCount++;

            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<k)
                    break;

                multiple=gcd(multiple, nums[j]);

                if(multiple==k)
                    subArrCount++;
            }
        }
        return subArrCount;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
