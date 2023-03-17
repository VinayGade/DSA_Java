package recursion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* Find occurrence of each element in unsorted array
* */
public class CountFrequencies {

    public void countFrequencies(int[] arr){

        int n = arr.length;
        boolean[] visited = new boolean[n];

        Arrays.fill(visited, false);

        for(int i=0; i<n; i++){

            if(visited[i])
                continue;

            int count = 1;
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arr[i] + " " + count);
        }
    }

    // Map<number, frequency> ... efficient solution,  Time Complexity : O(N)
    public Map<Integer, Integer> frequencyMap(int [] arr){

        Map<Integer, Integer> numberFrequencyMap= new LinkedHashMap<>();

        for(int i=0; i<arr.length; i++){

            if(numberFrequencyMap.containsKey(arr[i]))
                numberFrequencyMap.put(arr[i], numberFrequencyMap.get(arr[i]) + 1);
            else
                numberFrequencyMap.put(arr[i], 1);
        }
        return numberFrequencyMap;
    }

    public void iterateUsingStreamAPI(Map<Integer, Integer> map) {
        map.entrySet()
                .stream()
                .forEach(e -> System.out.println("Number="+e.getKey() + ", Frequency=" + e.getValue()));
    }

    public void iterateUsingIteratorAndEntry(Map<Integer, Integer> map) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Number="+entry.getKey() + ", Frequency=" + entry.getValue());
        }
    }

    public void iterateUsingEntrySet(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("[Number: "+entry.getKey() + ", Frequency:" + entry.getValue()+"]");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 10, 6, 7, 6, 4, 10, 10, 2, 3, 1, 7, 6, 3};

        CountFrequencies frequencies = new CountFrequencies();
        frequencies.countFrequencies(arr);

        System.out.println("\nNumber frequency map : ");
        Map<Integer, Integer> numFrequencyMap = frequencies.frequencyMap(arr);

        numFrequencyMap.forEach(
                (k,v) -> System.out.println("Number = "+k+", Frequency = "+v)
        );

        System.out.println("\nIterating Number frequency map using stream API: ");
        frequencies.iterateUsingStreamAPI(numFrequencyMap);

        System.out.println("\nNumber frequency map using Iterator: ");
        frequencies.iterateUsingIteratorAndEntry(numFrequencyMap);

        System.out.println("\nNumber frequency map using EntrySet: ");
        frequencies.iterateUsingEntrySet(numFrequencyMap);
    }
}