package search.practice;

public class TwoSumII {

    // Leetcode 167. Two Sum II - Input Array Is Sorted
    public static int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int[] ans = new int[2];

        //binary search
        while(low < high){
            int sum = nums[low]+nums[high];
            if(sum == target){
                ans[0] = low+1;
                ans[1] = high+1;
                break;
            }
            else if(sum > target){
                high--;
            }
            else{
                low++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15}; // numbers = [2,3,4], target = 6
        int target = 9;
        int[] output = twoSum(numbers, 9);
        System.out.println("target ="+target+", num1="+output[0]+
                ", num2="+output[1]);
    }
}
