package array.math.prefix_sum;

import java.util.Scanner;

/*
Little Chef and Sums

Our little chef is fond of doing additions/sums in his free time.
Today, he has an array A and |A| = N
he will compute prefix and suffix sums over this array.

He first defines two functions prefixSum(i) and suffixSum(i) for the array as follows.
The function prefixSum(i) denotes the sum of first i numbers of the array.

Similarly, he defines suffixSum(i) as the sum of last N - i + 1 numbers of the array.

Little Chef is interested in finding the minimum index i
for which the value prefixSum(i) + suffixSum(i) is the minimum.

you should minimize the value of prefixSum(i) + suffixSum(i),
and then find the least index i for which this value is attained.

input:
2
3
1 2 3
4
2 1 3 1

output:
1
2
* */

public class ChefSum {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while(--T >= 0){

            int N = scanner.nextInt();
            int[] a = new int[N];

            for(int i=0; i<N; i++){
                a[i] = scanner.nextInt();
            }

            long[] prefixSum = calculatePrefixSum(a, N);
            long[] suffixSum = calculateSuffixSum(a, N);

            int idx = findBestSumIndex(prefixSum, suffixSum, N);
            System.out.println(idx);
        }

    }

    static int findBestSumIndex(long[] prefixSum, long[] suffixSum, int n){

        long minSum = Integer.MAX_VALUE;

        int index = -1;
        long sum = 0;

        for(int l=0; l<n; l++){

            sum = prefixSum[l] + suffixSum[l];

            if(sum < minSum){
                minSum = sum;
                index = l;
            }
        }
        return index+1;
    }

    static long[] calculatePrefixSum(int[] a, int n){

        long[] prefixSum = new long[n];

        long sum = 0;

        for(int i=0; i<n; i++){
            sum += a[i];
            prefixSum[i] = sum;
        }
        return prefixSum;
    }

    static long[] calculateSuffixSum(int[] a, int n){

        long[] suffixSum = new long[n];

        long sum = 0;

        for(int i=n-1; i>=0; i--){
            sum += a[i];
            suffixSum[i] = sum;
        }
        return suffixSum;
    }

    // more efficient approach

    /*

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while(--T >= 0){
            int N = scanner.nextInt();
            int[] a = new int[N];
            long totalSum = 0;

            for(int i=0; i<N; i++){
                a[i] = scanner.nextInt();
                totalSum += a[i];
            }

            int bestIndex = 0;
            long minSum = totalSum + a[0];

            for (int i = 1; i < N; i++) {
                long currentSum = totalSum + a[i];
                if (currentSum < minSum) {
                    minSum = currentSum;
                    bestIndex = i;
                }
            }

            System.out.println(bestIndex + 1);
        }
    }
    * */
}
