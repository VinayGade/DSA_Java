package array.math.two_pointers;

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

    // 2 - pointers
    public static void moveToEnd(int[] a, int n, int k) {
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            while (i < j && a[j] == k){
                // Decrement right pointer
                j--;
            }

            if (a[i] == k) {

                // Swap the two elements
                // in the array
                swap(a, i, j);
            }

            // Increment left pointer
            i++;
        }
    }

    static int[] swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {2,3,0,7,0,3,0,0,1};
        // int[] shifted = shift0InPlace(array);
        // int[] result = moveZeroesOptimized(array);

        int n = array.length;
        // 2-pointers
        moveToEnd(array, n, 0); // since key = 0
        for(int x: array){
            System.out.print(x+" ");
        }
    }
}
