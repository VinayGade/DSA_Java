package heap.priorityQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// LeetCode 373. Find K Pairs with Smallest Sums

/*
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and
one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Constraints:

1 <= nums1.length, nums2.length <= 105
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in non-decreasing order.
1 <= k <= 104
k <= nums1.length * nums2.length

* */

public class KPairsSmallestSums {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //In the minHeap array, 0th element refers to the curr element in nums1 and 1st element refers to curr element in nums2
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // The 2nd element in the minHeap is the index of nums2, the corresponding element of nums2 is in index1 of minHeap
        for(int i=0; i < nums1.length && i < k; i++)
            minHeap.add(new int[]{nums1[i], nums2[0], 0});

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i < k && !minHeap.isEmpty(); i++){
            int[] curr = minHeap.poll();
            result.add(Arrays.asList(curr[0], curr[1]));
            int nums2Idx = curr[2];
            if(nums2Idx < nums2.length - 1)
                minHeap.add(new int[]{curr[0], nums2[nums2Idx + 1], nums2Idx + 1});
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        List<List<Integer>> smallestPairs = kSmallestPairs(nums1, nums2, k);
        smallestPairs.forEach(System.out::println);
    }
}
