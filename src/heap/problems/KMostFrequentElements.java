package heap.problems;

import java.util.*;

public class KMostFrequentElements {

    // Function to print the sum of frequencies of k numbers
    // with most occurrences in an array.
    static int kMostFrequent(int arr[], int n, int k) {

        Map<Integer, Integer> map = findFrequency(arr);

        List<int[]> frequencies = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            frequencies.add(new int[]{entry.getKey(), entry.getValue()});
        }

        frequencies.sort(new FrequencyComparator());
        int sum = 0;

        for(int i=0; i<k; i++){
            sum += frequencies.get(i)[1];
        }
        return sum;
    }

    // Function to find k numbers with most occurrences using PriorityQueue
    static ArrayList<Integer> topKFrequent(int[] arr, int k) {

        // HashMap 'mp' implemented as frequency hash
        // table
        Map<Integer, Integer> mp = new HashMap<>();
        for (int val : arr)
            mp.put(val, mp.getOrDefault(val, 0) + 1);

        // Priority queue (Min-Heap) with custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(new FrequencyComparator());

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            if (pq.size() > k)
                pq.poll();
        }

        // store the result
        ArrayList<Integer> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll()[1]);
        }

        Collections.reverse(res);
        return res;
    }

    static Map<Integer, Integer> findFrequency(int[] arr){

        Map<Integer, Integer> map = new HashMap<>();

        for(int x: arr){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return map;
    }

    static class FrequencyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] p1, int[] p2){

            if(p1[1] == p2[1]){
                return Integer.compare(p1[0], p2[0]);
            }
            return Integer.compare(p1[1], p2[1]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};

        int k = 2;

        ArrayList<Integer> topKFrequent = topKFrequent(arr, k);

        int sum = 0;
        for(int x: topKFrequent){
            sum += x;
        }

        System.out.println(sum);
    }
}
