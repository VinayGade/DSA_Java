package search.practice;

//LeetCode 1752. Check if Array Is Sorted and Rotated
public class RotatedSortedArrayValidity {

    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n -1; i++){
            if(nums[i] > nums[i+1])
                count++;
        }

        if(count == 0)
            return true;
        else if(count > 1)
            return false;
        else{
            if(nums[0] >= nums[n-1])
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        boolean isRotatedSorted = check(nums);
        System.out.println(isRotatedSorted);
    }
}
