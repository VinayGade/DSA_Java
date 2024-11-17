package search.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// CodeChef: MinionChefBananas

public class MinionChefBananas {

    // Function to check if the time taken with current speed is <= h
    static boolean TorF(List<Integer> v, double val, long h) {
        long time = 0;
        for (int x : v) {
            time += Math.ceil(x / val);
        }
        return time <= h;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long n = Long.parseLong(input[0]);
            long h = Long.parseLong(input[1]);

            List<Integer> v = new ArrayList<>();
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                v.add(Integer.parseInt(arr[i]));
            }

            long first = 1, last = (long) 1e9;

            while (first < last) {
                long mid = first + (last - first) / 2;

                if (TorF(v, mid, h)) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            }

            System.out.println(first);
        }
    }
}
