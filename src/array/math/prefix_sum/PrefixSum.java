package array.math.prefix_sum;

import java.util.Scanner;

/*
A "prefix array" is a data structure commonly used in programming,
algo related to strings or arrays.
Also known as a "prefix sum array", it stores cumulative sums of elements in an array.

array (a)        -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
prefix array (b) -> [1, 3, 6, 10, 15, 21, 28, 36, 45, 55]

We created a prefix array, which stores a cumulative sum of all the previous indexes of the array. This is our prefix array for a.

Similarly, we also have prefix arrays for strings:

string s = "codechef";
prefixOfs = [c,co,cod,code,codec,codech,codeche,codechef];

Pseudo Code for prefix sum

PrefixSum(arr)
Input: Array arr of size N
Output: Prefix sum array prefixSum of size N

Initialize an array prefixSum of size N

prefixSum[0] = arr[0]
for i = 1 to N-1 do
    prefixSum[i] = prefixSum[i-1] + arr[i]
return prefixSum
* */

public class PrefixSum {

    static int[] findPrefixSumArray(int[] a, int n) {
        int[] prefixSumArray = new int[n];
        prefixSumArray[0] = a[0];

        for (int i = 1; i < n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + a[i];
        }
        return prefixSumArray;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = scanner.nextInt();

        int[] prefixSumArray = findPrefixSumArray(a, N);

        for (int i = 0; i < (N - 1); i++)
            System.out.print(prefixSumArray[i] + " ");
        System.out.print(prefixSumArray[N - 1]);
    }
}
