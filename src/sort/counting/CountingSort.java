package sort.counting;

import java.util.*;

public class CountingSort {

    public static List < Integer > frequencyBasedSort(int n, List< Integer > arr) {

        Map< Integer, Integer > map = frequency(arr);
        List < Map.Entry < Integer, Integer >> entries = new ArrayList< >(map.entrySet());
        Collections.sort(entries, (e1, e2) -> {
            int freqCompare = e1.getValue().compareTo(e2.getValue());
            if (freqCompare != 0)
                return freqCompare;
            else
                return e1.getKey().compareTo(e2.getKey());

        });
        List < Integer > list = new ArrayList < > ();
        for (Map.Entry < Integer, Integer > entry: entries) {
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    static Map < Integer, Integer > frequency(List < Integer > list) {

        Map < Integer, Integer > map = new HashMap< >();
        for (int x: list) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List < Integer > arr = new ArrayList < > ();
        for (int i = 0; i < n; ++i) {
            arr.add(scanner.nextInt());
        }
        // Function call to perform frequency-based sorting
        List < Integer > sortedList = frequencyBasedSort(n, arr);
        // Print the sorted list
        for (int i = 0; i < sortedList.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(sortedList.get(i));
        }
    }

    public static void frequencyBasedSort(List<Integer> arr) {

        int n = arr.size();
        // Initialize a count array to count frequencies (since max value is 100)
        final int max_value = 100;
        int[] count = new int[max_value + 1];
        // Count frequencies of each integer
        for (int num : arr) {
            count[num]++;
        }
        // Create a list of pairs (value, frequency)
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>();
        for (int i = 0; i <= max_value; ++i) {
            if (count[i] > 0) {
                freqList.add(new AbstractMap.SimpleEntry<>(i, count[i]));
            }
        }
        // Sort the list by frequency (ascending) and by value (ascending if frequencies are the same)
        freqList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return Integer.compare(a.getKey(), b.getKey()); // Sort by value if frequencies are the same
            }
            return Integer.compare(a.getValue(), b.getValue()); // Otherwise, sort by frequency
        });
        // Output the sorted list based on frequency
        for (Map.Entry<Integer, Integer> p : freqList) {
            for (int i = 0; i < p.getValue(); ++i) {
                System.out.print(p.getKey() + " ");
            }
        }
        System.out.println();
    }
}
