package backtracking;

import java.util.Arrays;
import java.util.Comparator;

// LeetCode 2948. Make Lexicographically Smallest Array by Swapping Elements

/*
You are given a 0-indexed array of positive integers nums and a positive integer limit.

In one operation, you can choose any two indices i and j and swap nums[i] and nums[j]
if |nums[i] - nums[j]| <= limit.

Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

An array a is lexicographically smaller than an array b if in the first position where
a and b differ, array a has an element that is less than the corresponding element in b.

For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3]
because they differ at index 0 and 2 < 10.

Example 1:

Input: nums = [1,5,3,9,8], limit = 2
Output: [1,3,5,8,9]
Explanation: Apply the operation 2 times:
- Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
- Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
We cannot obtain a lexicographically smaller array by applying any more operations.
Note that it may be possible to get the same result by doing different operations.
Example 2:

Input: nums = [1,7,6,18,2,1], limit = 3
Output: [1,6,7,18,1,2]
Explanation: Apply the operation 3 times:
- Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
- Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
- Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
We cannot obtain a lexicographically smaller array by applying any more operations.
Example 3:

Input: nums = [1,7,28,19,10], limit = 3
Output: [1,7,28,19,10]
Explanation: [1,7,28,19,10] is the lexicographically smallest array we can obtain
because we cannot apply the operation on any two indices.

* */

public class LexicographicallySmallestArr{

    /*
Algorithm:

1. Initialize variable n to hold the length of nums.
2. Create arr as a sorted array with elements paired with their original indices.
3. Create an empty array ans to store the final lexicographically smallest array.
4. Set up a loop to traverse through the elements of arr, using variable i as the iterator.
Inside the loop, initiate a nested loop (using j) to find the contiguous segment
where the adjacent value difference is within the limit.
5. Once the segment is identified, extract the original indices of these elements and
sort them.
This sorting is based on the original indices of the segment to maintain
a lexicographically correct order.
6. Map the values from arr segment to ans using the sorted indices.
7. Continue processing until all elements in nums are considered.

Data structures used include:

A tuple array to hold the value-index pairs.
A list to hold the answer, as it enables us to place values at specific indices.
    */

    public static int[] lexSmallestArray(int[] nums, int limit) {
        // Get the length of the original array.
        int n = nums.length;

        // Create an array of indices of the given array.
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; ++i) {
            indices[i] = i;
        }

        // Sort the indices based on the values in 'nums' they point to.
        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));

        // Prepare an array to store the answer.
        int[] answer = new int[n];

        // Loop over the indices array.
        for (int i = 0; i < n;) {
            // Find a contiguous subsequence of indices where each pair of consecutive
            // numbers has a difference less than or equal to 'limit'.
            int j = i + 1;
            while (j < n && nums[indices[j]] - nums[indices[j - 1]] <= limit) {
                ++j;
            }

            // Copy the subrange of indices [i, j) to a temporary array 'tempIndices'.
            Integer[] tempIndices = Arrays.copyOfRange(indices, i, j);

            // Sort the temporary indices array in natural order, effectively sorting by
            // their original positions in 'nums'.
            Arrays.sort(tempIndices);

            // Populate the 'answer' array with values from 'nums' using the sorted
            // temporary indices.
            for (int k = i; k < j; ++k) {
                answer[tempIndices[k - i]] = nums[indices[k]];
            }

            // Move to the next subsequence.
            i = j;
        }

        return answer;
    }
    public static void main(String[] args) {

        int[] nums = {1,7,6,18,2,1};
        int limit = 3;
        int[] solution = lexSmallestArray(nums, limit);
        for(int x: solution){
            System.out.print(x+" ");
        }
    }
}