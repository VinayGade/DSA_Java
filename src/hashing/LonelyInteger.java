package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers, where all elements but one occur twice, find the unique element.

eg.
input: [1, 2, 3, 4, 3, 2, 1]
output: 4

since 4 occurs only once.
* */
public class LonelyInteger {

    public static int lonelyInteger(List<Integer> a) {
        //Integer[] arr = (Integer[]) a.toArray();
        Map<Integer, Integer> frequencyMap = findFrequency(a, a.size());
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    static Map<Integer, Integer> findFrequency(List<Integer> arr, int n){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<n; i++){
            int key = arr.get(i);
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0)+1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        int unique = lonelyInteger(arr);
        System.out.println("Lonely Integer = "+unique);
    }
}
