package array.math;

/*
LeetCode 283. Move Zeroes

Moves Zeros to the End of an Array

input : [ 42, 2, 0, 3, 4, 0 ]
output: [ 42, 2, 3, 4, 0, 0 ]
* */
public class MoveAll0 {

    //using additional array
    public static int[] shiftZeros(int[] array){
        int[] result = new int[array.length];
        int i = 0;
        for(int x: array){
            if(x!=0)
                result[i++]=x;
        }
        return result;
    }

    //in place shuffle
    public static int[] shift0InPlace(int[] array){
        int i = 0;

        //Step 1: shift all non 0 elements to left
        for(int x: array){
            if(x!=0)
                array[i++]=x;
        }

        //Step 2: Set remaining elements to 0
        while(i<array.length)
            array[i++]=0;
        return array;
    }

    public static int[] moveZeroesOptimized(int[] nums) {
        int j=0;
        int n=nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i]!=0) {
                nums[j]=nums[i];
                j++;
            }
        }
        while(j<n) {
            nums[j]=0;
            j++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {2,3,0,7,0,3,0,0,1};
        int[] shifted = shift0InPlace(array);
        int[] result = moveZeroesOptimized(array);
        for(int x: shifted){
            System.out.print(x+" ");
        }
    }
}
