package recursion;

// Leetcode 1979. Find Greatest Common Divisor of Array
/*
Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
Example 2:

Input: nums = [7,5,6,8,3]
Output: 1
Explanation:
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.
Example 3:

Input: nums = [3,3]
Output: 3
Explanation:
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.
* */
public class GCDArray {

    public static int findGCD(int[] nums) {
        int min;
        int max = min = nums[0];
        for (int i=1; i<nums.length; i++){
            if(nums[i]> max)
                max =nums[i];
            else if(nums[i]< min)
                min =nums[i];
        }
        return gcd(min, max);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int GCD(int N , int arr[])
    {
        for(int i=1; i<N; i++)
            arr[i] = hcf(arr[i-1], arr[i]);
        return arr[N-1];
    }

    int hcf(int a , int b){
        return (b==0) ? a : hcf(b, a%b);
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};
        int[] nums2 = {7,5,6,8,3};

        int gcd1 = findGCD(nums);
        int gcd2 = findGCD(nums2);

        System.out.println("gcd of nums = "+gcd1);
        System.out.println("gcd of nums2 = "+gcd2);
    }
}