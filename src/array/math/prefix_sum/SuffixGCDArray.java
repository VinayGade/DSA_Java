package array.math.prefix_sum;

import java.util.Scanner;

/*

codechef: prefix sum: Suffix Arrays

A suffix array is similar to prefix array.
 The only difference is that a suffix array works from right to left,
 while a prefix array works from left to right.

Suffix array of [1, 2, 3, 4, 5] => [15, 14, 12, 9, 5]

We generally use prefix/suffix arrays to store the sum,
but we can also use them to store some other operations like multiplication, GCD.

Some algorithms required us to use both prefix and suffix operations of different types together.

input:
4
4 3 2 6

output:
2

explanation:
Remove 4: Remaining elements are [3, 2, 6]. GCD(3, 2, 6) = 1
Remove 3: Remaining elements are [4, 2, 6]. GCD(4, 2, 6) = 2
Remove 2: Remaining elements are [4, 3, 6]. GCD(4, 3, 6) = 1
Remove 6: Remaining elements are [4, 3, 2]. GCD(4, 3, 2) = 1
The maximum GCD among [1, 2, 1, 1] is 2.

 * */

public class SuffixGCDArray {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] a = new int[N];

        int[] aux = new int[N]; // Create auxiliary array once

        for (int i = 0; i < N; i++)
            a[i] = scanner.nextInt();

        int maxGCD = findMaxGCD(a, N);
        System.out.println(maxGCD);
    }

    /*
    approach:
    The problem requires you to calculate the maximum GCD (Greatest Common Divisor)
     that can be obtained by removing one element from a given array.
     You need to iterate through the array, and for each element,
     you temporarily remove it and calculate the GCD of the remaining elements.
     Finally, you find the maximum GCD among all these calculations.

     calculate the prefix GCD and suffix GCD to efficiently compute the GCD of
     remaining elements after removing one element at a time
    * */
    public static int findMaxGCD(int[] a, int n){

        int maxGcd = 0;

        if (n == 1) {
            return 0; // Or any other appropriate value since removing the only element makes no sense for GCD.
        }

        int[] prefixGcd = new int[n];
        int[] suffixGcd = new int[n];

        // Calculate prefix GCD array
        prefixGcd[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefixGcd[i] = findGcd(prefixGcd[i - 1], a[i]);
        }

        // Calculate suffix GCD array
        suffixGcd[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGcd[i] = findGcd(suffixGcd[i + 1], a[i]);
        }

        // Iterat array and calculate GCD after removing each element
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxGcd = Math.max(maxGcd, suffixGcd[1]);
            } else if (i == n - 1) {
                maxGcd = Math.max(maxGcd, prefixGcd[n - 2]);
            } else {
                maxGcd = Math.max(maxGcd, findGcd(prefixGcd[i - 1], suffixGcd[i + 1]));
            }
        }
        return maxGcd;
    }

    static int findGcd(int a, int b){

        if(b == 0)
            return a;
        return findGcd(b, a%b);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int findGCDofArr(int[] array, int n){

        int res = array[0];

        for (int i = 1; i < array.length; i++) {
            res = findGcd(array[i], res);

            // If res becomes 1 at any iteration then it remains 1
            // So no need to check further
            if (res == 1)
                return 1;
        }

        return res;
    }
}
