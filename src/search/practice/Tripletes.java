package search.practice;

/*
Count all triplets with given sum in sorted array
Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k)
of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
* */
public class Tripletes {

    static int countTriplets(int[] a, int target) {
        int n=a.length;
        int count=0;
        for(int i=0;i<n;i++){
            int l=i+1;
            int r=n-1;
            int f=target-a[i];
            while(l<r){
                if((a[l]+a[r])==f){
                    int right=r;
                    while(l<right && a[right]==a[r]){
                        count++;
                        right--;
                    }
                    l++;
                }
                else if((a[l]+a[r])<f){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {-3, -1, -1, 0, 1, 2};
        int target = -2;
        int count = countTriplets(arr, target);
        System.out.println(count);
    }
}
