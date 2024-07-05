package array.math.two_pointers;

import java.util.*;

//CodeChef
public class MaximumUniqueSegments {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] c = new int[n];
            long[] w = new long[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                w[i] = scanner.nextInt();
            }
            long sum = maximumUniqueSegmentSum(c, w, n);
            System.out.println(sum);
        }
    }

    static long maximumUniqueSegmentSum(int[] c, long[] w, int n){
        /*
        0 1 2 0 2
        5 6 7 8 2

        range [2, 4] -> unique range: (1, 2, 0) ... no duplicates
        sum = 6 + 7 + 8 = 21
        * */
        Set<Integer> set = new HashSet<>();
        int j = 0;
        int i = 0;
        long fs = 0;
        long sum = 0;

        while(i < n){
            while(set.contains(c[i])){
                sum -= w[j];
                set.remove(c[j]);
                j++;
            }
            set.add(c[i]);
            sum+=w[i];
            fs=(sum>fs)?sum:fs;
            i++;
        }
        return fs;
    }
}
