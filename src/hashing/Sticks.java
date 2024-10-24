package hashing;

import java.util.*;

public class Sticks {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++)
                a[i] = scanner.nextInt();

            int maxArea = rectangeArea(a, N);
            System.out.println(maxArea);
        }
    }

    static int rectangeArea(int[] a, int n){
        int pairCount = 0;
        int maxLength = Integer.MIN_VALUE;
        int maxBreadth = Integer.MIN_VALUE;
        int maxArea = 1;
        boolean isSquare = false;
        Map < Integer, Integer > frequencyMap = frequency(a);
        for (Map.Entry < Integer, Integer > entry: frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            if (frequency >= 2) {
                if (frequency >= 4) {
                    maxArea = maxArea * key * key;
                    isSquare = true;
                }
                maxBreadth = Math.min(key, maxLength);
                maxLength = Math.max(key, maxLength);
                pairCount++;
            }
        }

        return (pairCount < 2 && !isSquare) ? -1 : Math.max(maxArea, (maxLength * maxBreadth));
    }

    static int calculateMaxArea(int[] a, int n) {
        int pairCount = 0;
        int maxLength = 0;
        int secondMaxLength = 0;

        Map<Integer, Integer> frequencyMap = frequency(a);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();

            // We need at least two sticks of the same length for one side of a rectangle
            while (frequency >= 2) {
                // Track the maximum and second maximum lengths
                if (key > maxLength) {
                    secondMaxLength = maxLength;
                    maxLength = key;
                } else if (key > secondMaxLength) {
                    secondMaxLength = key;
                }
                frequency -= 2;
                pairCount++;
            }
        }

        // We need at least two pairs to form a rectangle
        if (pairCount < 2) return -1;

        return maxLength * secondMaxLength;
    }

    static int rectangeArea(int[] a){
        Map<Integer, Integer> frequencyMap = frequency(a);
        List<Integer> sides = new ArrayList<>();

        // Collect all possible sides
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            // If there are at least two sticks of this length, they can form a side
            while (count >= 2) {
                sides.add(key);
                count -= 2;
            }
        }

        // Sort the potential sides in descending order
        Collections.sort(sides, Collections.reverseOrder());

        // We need at least two pairs to form a rectangle
        if (sides.size() < 2) return -1;

        // The two largest sides form the rectangle
        return sides.get(0) * sides.get(1);
    }

    static  Map<Integer, Integer> frequency(int[] a){

        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for(int x: a)
            frequencyMap.put(x, frequencyMap.getOrDefault(x, 0)+1);
        return frequencyMap;
    }
}
