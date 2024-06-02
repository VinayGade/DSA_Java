package array.math;

import java.util.Arrays;

public class MissingAndRepeating {

    /*
Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and
smallest positive missing number is 2.

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and
smallest positive missing number is 1.
    * */

    static int[] findTwoElement(int arr[], int n) {

        // step 1: sort array
        Arrays.sort(arr);
        int[] result = new int[2];

        // step 2:
        /*
        2 sums:
        sum = sum of array elements
        totalSum = sum + missing element
        */
        int sum = arr[0], totalSum = 1;

        // step 3: iterate over array to find repeating element
        for(int i=n-1; i>0; i--){
            totalSum += i + 1;

            if(arr[i] == arr[i-1]){
                result[0] = arr[i];  // repeating element found
            }else{
                sum += arr[i];
            }
        }
        // step 4: missing element = totalSum - sum.  ... since step(2)
        result[1] = totalSum - sum;
        return result;
    }

    public static void main(String[] args) {
         /*
        N = 3
        Arr[] = {1, 3, 3}
        * */

        /*
        47
        13 33 43 16 25 19 23 31 29 35
        10 2  32 11 47 15 34 46 30 26
        41 18 5  17 37 39 6  4  20 27
        9  3  8  40 24 44 14 36 7  38
        12 1  42 12 28 22 45
        * */

        int arr[] = {
                13, 33, 43, 16, 25, 19, 23, 31, 29, 35,
                10, 2,  32, 11, 47, 15, 34, 46, 30, 26,
                41, 18, 5,  17, 37, 39, 6,  4,  20, 27,
                9,  3,  8,  40, 24, 44, 14, 36, 7,  38,
                12, 1,  42, 12, 28, 22, 45};
        int N = 47;
        //int[] solution = findMissingRepeating(arr, N);
        int[] solution = findTwoElement(arr, N);
        System.out.println(solution[0]+" "+solution[1]);
    }
}
