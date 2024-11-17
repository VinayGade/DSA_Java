package search.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Squirrel and chestnut:

There are n squirrel(s) waiting below the feet of m chestnut tree(s).
The first chestnut of the i-th tree will fall right after Ti second(s),
and one more every Pi second(s) after that.
The “big mama” of squirrels wants them to bring their nest no less than k
chestnuts to avoid the big storm coming, as fast as possible!
So they are discussing to wait below which trees to take enough chestnuts in the shortest time.
Time to move to the positions is zero, and the squirrels move nowhere after that.

input:
2
3 2 5
5 1 2
1 2 1
3 2 5
5 1 2
1 1 1

output:
4
3

* */
public class SquirrelChestnut {

    static class TreeInfo {
        int fallTime;
        int interval;

        TreeInfo(int fallTime, int interval) {
            this.fallTime = fallTime;
            this.interval = interval;
        }
    }

    public static void main(String[] args) throws Exception {
        // Use BufferedReader for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read number of test cases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }

    static void solve(BufferedReader br) throws Exception {
        // Read input values
        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);

        // List to store tree information
        List<TreeInfo> trees = new ArrayList<>();

        // Read fall times
        String[] fallTimes = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int fallTime = Integer.parseInt(fallTimes[i]);
            trees.add(new TreeInfo(fallTime, 0));
        }

        // Read intervals and update the list
        String[] intervals = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int interval = Integer.parseInt(intervals[i]);
            trees.get(i).interval = interval;
        }

        long ans = findShortestTime(m, n, k, trees);
        System.out.println(ans);
    }

    static long findShortestTime(int m, int n, int k, List<TreeInfo> trees) {
        long ans = -1;
        long low = 0;
        long high = 1000000; // Consider increasing high value given constraints

        // Binary search to find the answer
        while (low <= high) {
            long mid = low + (high - low) / 2;
            List<Long> chestnuts = new ArrayList<>();

            for (TreeInfo tree : trees) {
                if (tree.fallTime > mid) {
                    chestnuts.add(0L);
                } else {
                    long timeAfterFirst = mid - tree.fallTime;
                    long count = timeAfterFirst / tree.interval + 1;
                    chestnuts.add(count);
                }
            }

            Collections.sort(chestnuts, Collections.reverseOrder());
            long collectedChestnuts = 0;
            for (int i = 0; i < Math.min(m, n); i++) {
                collectedChestnuts += chestnuts.get(i);
            }

            if (collectedChestnuts >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
