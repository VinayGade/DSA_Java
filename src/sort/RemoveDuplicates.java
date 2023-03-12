package sort;

public class RemoveDuplicates {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 3, 4, 5, 5, 6 ,7, 8, 9, 9};
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedArr= new Solution().removeDuplicates(arr);

        System.out.println("\nafter removing duplicates");
        for(int x: expectedArr)
            System.out.print(" "+x);

        //System.out.println(" k ="+expectedArr.length);
    }
}

class Solution {
    public int[] removeDuplicatesOld(int[] nums) {
        int k = nums.length;
        int n = nums.length;

        /*

        arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.

         */
        
        for(int i=1; i<n; i++){

            if(nums[i] == nums[i-1]){
                System.arraycopy(nums, i, nums, (i-1), (n-i));
                k--;
            }
        }
        k=k+1; // since nums[0] isn't considered in loop
        System.out.println(" \nk ="+k);
        System.out.println("\nPrint after removing duplicates");
        for(int x: nums)
            System.out.print(" "+x);
        return nums;
    }

    public int[] removeDuplicates(int[] nums){

        int n = nums.length;
        int k = 1;
        int i = 0;

        while( i < (n-1)){
            if(nums[i] != nums[i+1]){
                nums[k] = nums[i+1];
                k++;
            }
            i++;
        }

        System.out.println("\nk ="+k);
        return nums;
    }
}
