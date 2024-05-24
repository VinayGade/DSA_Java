package greedy;

// maximum sum subarray

public class MaxSumSubarr {
    
    static int maxSumSubArray(int[] a, int n){
    	int sum = 0;
    	int ans = a[1];
    	for(int i=1; i<n; i++){
    		sum += a[i];
    		if(sum > ans)
    			ans = sum;
    		if(sum < 0)
    			sum = 0;
    	}
    	return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int subArrSum = maxSumSubArray(arr, arr.length);
        System.out.println("max Sum Sub-Array = "+subArrSum);
    }
}
