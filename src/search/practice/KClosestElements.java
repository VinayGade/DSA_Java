package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

    static int[] printKClosest(int[] arr, int k, int x) {

        int[] kClosest = new int[k];

        int xIndex = binarySearch(arr, x);
        int larger = arr[xIndex + 1];
        int diff = larger - x;

        int count = 0;
        int t = 2;
        int j = 0;
        int i = xIndex - 1;
        while(i >= 0 && count <= k){

            if((x - arr[i]) < diff){
                kClosest[j] = arr[i];
                j++;
            }else{
                kClosest[j] = larger;
                larger = arr[xIndex + t];
                diff = larger - x;
                t++;
            }
            count++;
        }
        return kClosest;
    }

    static int binarySearch(int[] arr, int x){

        int low = 0;
        int high = arr.length - 1;

        while(low < high){

            int mid = (low + high) / 2;
            if(x < mid){
                high = mid - 1;
            }else if(x > mid){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int[] printKClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // Binary search to find the closest element or insertion point
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) left = mid + 1;
            else right = mid;
        }

        // Initialize two pointers
        int l = left - 1;
        int r = left;

        List<Integer> result = new ArrayList<>();

        while (k > 0) {
            int leftDiff = l >= 0 ? Math.abs(arr[l] - x) : Integer.MAX_VALUE;
            int rightDiff = r < n ? Math.abs(arr[r] - x) : Integer.MAX_VALUE;

            if (l >= 0 && arr[l] == x) l--;  // Skip x if found
            else if (r < n && arr[r] == x) r++;  // Skip x if found
            else if (leftDiff < rightDiff) {
                result.add(arr[l--]);
                k--;
            } else if (rightDiff < leftDiff) {
                result.add(arr[r++]);
                k--;
            } else {
                // Same distance, prefer larger element
                if (l >= 0 && r < n) {
                    if (arr[l] > arr[r]) {
                        result.add(arr[l--]);
                    } else {
                        result.add(arr[r++]);
                    }
                } else if (l >= 0) {
                    result.add(arr[l--]);
                } else if (r < n) {
                    result.add(arr[r++]);
                }
                k--;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        /*
        int[] arr1 = {1, 3, 4, 10, 12};
        int[] result1 = printKClosest(arr1, 2, 4);
        System.out.println(Arrays.toString(result1)); // Output: [3, 1]
         */

        int[] arr2 = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int[] result2 = printKClosestElements(arr2, 4, 35);
        System.out.println(Arrays.toString(result2)); // Output: [39, 30, 42, 45]
    }

    int[] printKClosestElementsQueue(int[] arr, int k, int x) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr[i] - x);
            if (diff == 0)
                continue;
            pq.offer(new int[] {diff, arr[i]});
        }

        int[] ans = new int[k];
        int idx = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int val = pq.peek()[1];
            pq.poll();
            ans[idx++] = val;
        }
        return ans;
    }
}
