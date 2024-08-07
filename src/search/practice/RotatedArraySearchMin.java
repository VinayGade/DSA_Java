package search.practice;

// LeetCode 153. Find Minimum in Rotated Sorted Array

public class RotatedArraySearchMin {

    public static int findMin(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        if (num.length == 1)
            return num[0];

        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1])
                return num[mid];

            if (num[start] <= num[mid] && num[mid] > num[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return num[start];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,10,1,2};
        int min = findMin(nums);
        System.out.println("Minimum = "+min);
    }
}
