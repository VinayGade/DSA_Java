package heap.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Game with String

/*

Given a string s consisting of lowercase alphabets and an integer k,
your task is to find the minimum possible value of the string after
removing exactly k characters.

The value of the string is defined as the sum of the squares of the frequencies
of each distinct character present in the string.

Input: s = "abbccc", k = 2
Output: 6

Explaination: We remove two 'c' to get the value as 1^2 + 2^2 + 1^2 = 6 or
We remove one 'b' and one 'c' to get the value 1^2 + 1^2 + 2^2 = 6.

Input: s = "aaab", k = 2
Output: 2
Explaination: We remove two 'a'. Now we get the value as 1^2 + 1^2 = 2.
* */

public class MinValueStringGame {

    public int minValue(String s, int k) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Add frequencies to max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqMap.values()) {
            maxHeap.add(freq);
        }

        // Step 3: Perform k removals, always from the highest frequency
        while (k > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            if (top > 1) {
                maxHeap.add(top - 1);
            }
            k--;
        }

        // Step 4: Sum of squares of the remaining frequencies
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            int freq = maxHeap.poll();
            sum += freq * freq;
        }

        return sum;
    }

    // Optional main for testing
    public static void main(String[] args) {
        MinValueStringGame sol = new MinValueStringGame();
        String s = "aaabccdeeeeefgg";
        int k = 7;
        int result = sol.minValue(s, k);
        System.out.println("Minimum sum of squares after removals: " + result);
    }
}
