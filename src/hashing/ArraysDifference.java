package hashing;

import java.util.*;
import java.util.stream.Collectors;

// LeetCode 2215. Find the Difference of Two Arrays
/*
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

* */
public class ArraysDifference {

    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> difference = new ArrayList<>();
        Map<Integer, Integer> frequency1 = computeFrequency(nums1);
        Map<Integer, Integer> frequency2 = computeFrequency(nums2);
        List<Integer> distincts1 = new ArrayList<>();
        List<Integer> distincts2 = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: frequency1.entrySet()){
            int key1 = entry.getKey();
            if(!frequency2.containsKey(key1)){
                distincts1.add(key1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: frequency2.entrySet()){
            int key2 = entry.getKey();
            if(!frequency1.containsKey(key2)){
                distincts2.add(key2);
            }
        }
        difference.add(distincts1);
        difference.add(distincts2);
        return difference;
    }

    public List<List<Integer>> findDifferenceStream(int[] a1, int[] a2){
        Set<Integer> s1 = Arrays.stream(a1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(a2).filter(n -> !s1.contains(n)).boxed().collect(Collectors.toSet());
        Arrays.stream(a2).forEach(s1::remove);
        return Arrays.asList(new ArrayList<>(s1), new ArrayList<>(s2));
    }

    public List<List<Integer>> findDifferenceSet(int[] nums1, int[] nums2) {
        // Initialize sets for both arrays
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();

        // Populate the sets
        for (int n : nums1) h1.add(n);
        for (int n : nums2) h2.add(n);

        // Remove common elements from both sets
        for (int n : nums2) {
            if (h1.contains(n)) {
                h1.remove(n);
                h2.remove(n);
            }
        }

        // Build the result
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(h1)); // Unique to nums1
        result.add(new ArrayList<>(h2)); // Unique to nums2

        return result;
    }

    static Map<Integer, Integer> computeFrequency(int[] a){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int x: a){
            frequencyMap.put(x, frequencyMap.getOrDefault(x, 1) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};

        List<List<Integer>> difference = findDifference(nums1, nums2);
        for(List<Integer> distincts: difference){
            distincts.forEach(x -> System.out.print(x+ " "));
            System.out.println();
        }
    }
}
