package search.practice;

import java.util.Arrays;

/*
Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and
smallest positive missing number is 1.

N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and
smallest positive missing number is 2.
* */

public class FindMissingRepeating {

    static int[] findTwoElement(int A[], int n) {
        // find the missing and repeating element
        int missing = -1;
        int repeating = -1;
        boolean flag1 = true;
        boolean flag2 = true;
        Arrays.sort(A);
        for(int i=0; i<n; i++) {
            if (!flag1 && !flag2)
                break;
            if (flag1 && A[i] > (i + 1)) {
                missing = A[i] - 1;
                flag1 = false;
            }
            if (flag2 && i < (n - 1) && A[i] == A[i + 1]) {
                repeating = A[i];
                flag2 = false;
            }
        }
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {

        /*
        N = 3
        Arr[] = {1, 3, 3}
        * */

        int arr[] = {1, 3, 3};
        int N = 3;
        int[] solution = findTwoElement(arr, N);
        System.out.println(solution[0]+" "+solution[1]);
    }
}
