package array.math;

public class SplitArray {

    /*
    Given an array of integers arr, return true if it is possible to split it in
    two subarrays (without reordering the elements), such that the sum of the two
    subarrays are equal. If it is not possible then return false.
    * */

    static boolean canSplit(int arr[]) {
        // code here
        int sum=0;
        for(int num : arr)
            sum += num;

        int arrSum = 0;
        for(int i=0; i<arr.length; i++){
            arrSum += arr[i];
            if(arrSum*2 == sum) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5};
        System.out.println(canSplit(arr));
    }
}
