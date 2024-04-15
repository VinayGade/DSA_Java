package hashing;

import java.util.*;

//HackerRank : MissingNumbers
public class MissingNumbers {

    /*
10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
    *
    * */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        //brr: original list
        //arr: new list
        TreeMap<Integer, Integer> integerFreqMap = new TreeMap<>();

        // Add elements of original list
        for (int x : brr) {
            int freq = integerFreqMap.getOrDefault(x, 0);
            freq++;
            integerFreqMap.put(x, freq);
        }

        // Remove elements of new list arr
        // update frequencies of arr
        for(int x:arr){
            int freq = integerFreqMap.get(x);
            freq--;
            if(freq==0)
                integerFreqMap.remove(x);
            else
                integerFreqMap.put(x, freq);
        }

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : integerFreqMap.entrySet()){
            result.add(entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);
        List<Integer> missing = missingNumbers(arr,brr);
        missing.forEach(x -> System.out.print(x+" "));
    }
}
