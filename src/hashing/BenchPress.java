package hashing;

//CodeChef: 3-star-difficulty-problems: Bench Press

/*
In the gym, Chef prefers to lift at least W grams during a bench press
and if that's impossible, Chef considers his workout to be incomplete and feels bad.

The rod weighs Wr grams and there are N other weights lying on the floor
that weigh w1, w2, ..., wn grams.

To maintain balance and to ensure that there is no unnecessary load due to torque,
it's important that the weights added to the left side are symmetric to the weights
 added to the right side.

 It is not required to use all of the weights.
 It is also not required to use any weights at all,
 if Chef feels satisfied lifting only the rod.

input:
3
2 5 10
2 2
7 100 50
100 10 10 10 10 10 90
6 100 40
10 10 10 10 10 10

output:
YES
NO
YES
* */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BenchPress {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();

            // total weight Chef can carry.
            int W = scanner.nextInt();

            // weight of Rod
            int Wr = scanner.nextInt();

            //weights lying on the floor
            int[] weights = new int[N];

            for (int i = 0; i < N; i++)
                weights[i] = scanner.nextInt();

            String status = isSatisfied(weights, N, W, Wr) ? "YES": "NO";

            System.out.println(status);
        }
    }

    static boolean isSatisfied(int[] weights, int n, int w, int wr){

        // count occurrences of each weight
        Map<Integer, Integer> weightCount = countWeight(weights);

        // Initialize the total weight Chef can use, starting with the weight of the rod
        long totalWeight = wr;

        // Calculate maximum achievable weight by adding balanced weights
        for (Map.Entry<Integer, Integer> entry : weightCount.entrySet()) {
            int weight = entry.getKey();
            int count = entry.getValue();

            // We can only use pairs of weights to keep the configuration balanced
            totalWeight += (long) (count / 2) * 2 * weight;
        }

        // Check if we can reach or exceed the required weight
        return totalWeight >= w;
    }

    // count occurrences of each weight
    static Map<Integer, Integer> countWeight(int[] weights){

        Map<Integer, Integer> weightCount = new HashMap<>();

        // Count each weight
        for (int weight : weights)
            weightCount.put(weight, weightCount.getOrDefault(weight, 0) + 1);

        return weightCount;
    }
}
