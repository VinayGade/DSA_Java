package array.math.two_pointers;

import java.util.Scanner;

// CodeChef: 2 pointers and sliding window

/*
You are given an array of integers. Your task is to sort the array such that all
odd numbers come before all even numbers while maintaining the original relative
order of the odd and even numbers.

Input:
5
3 1 2 4 5

Output:
3 1 5 2 4

Input:
6
2 4 6 1 3 5

Output:
1 3 5 2 4 6

Step-by-step process:

1. Count Odd Numbers:
Traverse the array to count how many odd numbers there are. This helps determine where to place the even numbers.

2. Initialize Two Pointers:
Use two pointers: left to place odd numbers starting from the beginning, and right (starting after the odd count) to place even numbers.

3. Traverse the Array Again:
For each number:
i. Place odd numbers at the left pointer.
ii.Place even numbers at the right pointer. Move the pointers accordingly.

4. Update the Original Array:
Once all numbers are placed, update the original array with the sorted result.

* */
public class SortByParity {

    public static void sortArrayByParity(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int left = 0;
        int right = n-1;

        for(int x: nums){
            if(x%2 != 0){
                result[left] = x;
                left++;
            }else{
                result[right] = x;
                right--;
            }
        }

        // reverse the second part of the array to maintain relative order

        for (int i = left, j = n - 1; i < j; i++, j--) {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        System.arraycopy(result, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        sortArrayByParity(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
