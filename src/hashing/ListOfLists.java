package hashing;

import java.util.*;

// CodeChef: > practice > arrays-string-sorting
public class ListOfLists {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int result = 0;
            if (n > 1)
                result = countOperations(a, n);
            System.out.println(result);
        }
    }

    static int countOperations(int[] a, int n) {
        Map< Integer, Integer > frequencyMap = numberFrequency(a);
        Set< Integer > frequencies = new HashSet< >(frequencyMap.values());
        int max = findLargest(frequencies);
        return (frequencyMap.size() == 1) ? 0 :(frequencyMap.size() == n) ? -1 : (n - max + 1);
    }

    static int findLargest(Set < Integer > frequencies) {
        int largest = -1;
        for (int y: frequencies)
            largest = Math.max(largest, y);
        return largest;
    }

    static Map < Integer, Integer > numberFrequency(int[] a) {
        Map < Integer, Integer > numberFrequencyMap = new HashMap< >();
        for (int x: a) {
            numberFrequencyMap.put(x,
                    numberFrequencyMap.getOrDefault(x, 0) + 1);
        }
        return numberFrequencyMap;
    }
}