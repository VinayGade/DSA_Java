package array.math.two_pointers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/*
Max sum path in two arrays :
 Given two sorted arrays of distinct integers arr1 and arr2.
 Each array may have some elements in common with the other array.
  Find the maximum sum of a path from the beginning of any array to the end of any array.
  You can switch from one array to another array only at the common elements.

Note:  When we switch from one array to other,
 we need to consider the common element only once in the result.
 Example1:Input: arr1 = [2, 3, 7, 10, 12] ,
  arr2 = [1, 5, 7, 8]
Output: 35
Explanation: The path will be 1+5+7+10+12 = 35, where 1 and 5 come from arr2 and
then 7 is common so we switch to arr1 and add 10 and 12.                                                                       Example2: Input: arr1 = [1, 2, 3] , arr2[] = [3, 4, 5]
Output: 15.

Input: arr1 = [1, 2, 3] , arr2[] = [3, 4, 5]
Output: 15.
* */
public class MaxPathSum {

    public static int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int n = arr1.size();
        int m = arr2.size();

        int arr1First = arr1.get(0);
        int arr2First = arr2.get(0);
        int arr1Last = arr1.get(n-1);
        int arr2Last = arr2.get(m-1);

        int pathSum = 0;

        if(arr1First == arr2Last || arr1Last == arr2First){
            pathSum = Stream.of(arr1, arr2).flatMap(Collection::stream)
            .reduce(0, Integer::sum);

            pathSum = pathSum - Math.min(arr1Last, arr2Last);
            return pathSum;
        }else {
        /*
            int leftSum1 = 0;
            int leftSum2 = 0;
            int rightSum1 = 0;
            int rightSum2 = 0;

            int common = 0;

            // 6, 6:30
            int i = 0;
            int j = 0;

            do{
                if(arr1.get(i) == arr2.get(j)){
                    common = arr1.get(i);
                    break;
                }
                leftSum1 += arr1.get(i);
                leftSum2 += arr2.get(j);
                i++;
                j++;
            }while(arr1.get(i) != arr2.get(j) && i < n && j < m);

            int k = n-1;
            int l = m-1;
            while(arr1.get(k) != arr2.get(l) && k >= 0 && l >= 0){
                rightSum1 += arr1.get(k);
                rightSum2 += arr2.get(l);
                k--;
                l--;
            }
            pathSum = common + Math.max(leftSum1, leftSum2)
            + Math.max(rightSum1, rightSum2);
            */
            //}
            //return pathSum;

            int i = 0, j = 0;
            int sum1 = 0, sum2 = 0;
            int result = 0;

            // Traverse both arrays
            while (i < n && j < m) {
                // If arr1[i] is smaller, add it to sum1
                if (arr1.get(i) < arr2.get(j)) {
                    sum1 += arr1.get(i);
                    i++;
                }
                // If arr2[j] is smaller, add it to sum2
                else if (arr2.get(j) < arr1.get(i)) {
                    sum2 += arr2.get(j);
                    j++;
                }
                // If both are same, choose the maximum sum path and reset sums
                else {
                    result += Math.max(sum1, sum2) + arr1.get(i);
                    sum1 = 0;
                    sum2 = 0;
                    i++;
                    j++;
                }
            }

            // Add remaining elements of arr1
            while (i < n) {
                sum1 += arr1.get(i);
                i++;
            }

            // Add remaining elements of arr2
            while (j < m) {
                sum2 += arr2.get(j);
                j++;
            }

            // Add the maximum of the remaining sums
            result += Math.max(sum1, sum2);

            return result;
        }
    }

    public static void main(String[] args) {

        List<Integer> arr1 = Arrays.asList(2, 3, 7, 10, 12);
        List<Integer> arr2 = Arrays.asList(1, 5, 7, 8);

        List<Integer> arr3 = Arrays.asList(1, 2, 3);
        List<Integer> arr4 = Arrays.asList(3, 4, 5);
        //Output: 15.

        int pathSum = maxPathSum(arr1, arr2);
        System.out.println(pathSum);

        int pathSum2 = maxPathSum(arr3, arr4);
        System.out.println(pathSum2);
    }
}