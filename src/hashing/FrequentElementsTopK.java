package hashing;

// LeetCode 347. Top K Frequent Elements

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
* */
public class FrequentElementsTopK {

    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        int [] topK = topKFrequent(nums, k);
        for(int i=0; i<k; i++)
            System.out.print(topK[i]+" ");
    }

    public static int[] topKFrequent(int[] a, int k) {
        int[] elements = new int[k];
        Map<Integer, Integer> frequencyMap = numberFrequency(a);

        List< Map.Entry < Integer, Integer >> entries = new ArrayList< >(frequencyMap.entrySet());
        Collections.sort(entries, (e1, e2) -> {
            int freqCompare = e2.getValue().compareTo(e1.getValue());
            if (freqCompare > 0)
                return 1;
            else
                return -1;
        });

        int i = 0;
        //Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry: entries){
            if(i>=k)
                break;
            elements[i] = entry.getKey();
            i++;
        }
        return elements;
    }

    public static int[] topKFrequent(int k, int[] nums) {
        return Arrays.stream(nums)
                .parallel()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static List<Integer> topKFrequent(int k, int n, int[] a) {
        Map<Integer, Integer> map = numberFrequency(a);

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        /*
        int size = res.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = res.get(i);
        return arr;
        */

        return res;
    }

    public static ArrayList<Integer>  topKFrequent(int[] a, int k, int n) {
        Map<Integer, Integer> map = numberFrequency(a);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((x,y)->(y.getValue()-x.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public static int[] topKFrequent(int n, int[] a, int k) {
        Map<Integer, Integer> map = numberFrequency(a);

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[a.length+1];
        for(int x:map.keySet()){
            int freq = map.get(x);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(x);
        }

        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i];
                res.addAll(list);
                k-= list.size();
            }
        }

        int size = res.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = res.get(i);
        return arr;
    }

    static Map<Integer, Integer> numberFrequency(int[] a){
        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
        for(int x: a)
            numberFrequencyMap.put(x,
                    numberFrequencyMap.getOrDefault(x, 0) + 1);
        return numberFrequencyMap;
    }

    static Map<Integer, Long> numberFrequency(int[] a, int n){
        return Arrays.stream(a)
                .parallel()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}