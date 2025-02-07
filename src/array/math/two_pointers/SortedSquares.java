package array.math.two_pointers;

public class SortedSquares {

    static int[] sortedSquares(int[] nums){

        int n = nums.length;
        int l = 0;
        int r = n-1;
        int [] res = new int[n];
        for(int i=n-1; i>=0; i--){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[i] = nums[l] * nums[l];
                l++;
            }else{
                res[i] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-100, -4, -1, 0, 3, 10};
        int[] squares = sortedSquares(a);
        for(int x: squares){
            System.out.print(x+" ");
        }
    }
}
