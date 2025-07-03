package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Check if frequencies can be equal :

Given a string s consisting only lowercase alphabetic characters,
check whether it is possible to remove at most one character such that
the  frequency of each distinct character in the string becomes same.
Return true if it is possible; otherwise, return false.

Input: s = "xyyz"
Output: true
Explanation: Removing one 'y' will make frequency of each distinct character to be 1.
Input: s = "xyyzz"
Output: true
Explanation: Removing one 'x' will make frequency of each distinct character to be 2.
Input: s = "xxxxyyzz"
Output: false
Explanation: Frequency can not be made same by removing at most one character.

* */
public class EqualFrequencies {

    static boolean sameFreq(String s) {

        char[] sarr = s.toCharArray();

        Map<Character, Integer> freqMap = numberFrequency(sarr);
        /*
        int diff = 0;

        Set<Integer> frequencies = new HashSet<>();
        frequencies.addAll(freqMap.values());

        for(Map.Entry<Character, Integer> entry: map.entrySet()){

            int frequency = entry.getValue();

        }*/
        /*
        if(frequencies.size() < 3){
            Integer[] freq = new Integer[2];

            int i = 0;
            for(int x: frequencies){

                freq[i] = x;
                i++;
            }

            int larger = Math.max(freq[0], freq[1]);

            int countLarger = 0;
            int count = 0;

            for(Map.Entry<Character, Integer> entry: map.entrySet()){

                int frequency = entry.getValue();
                if(frequency == larger)
                    countLarger++;
                else count++;
            }
            if(countLarger > count)
                return true;
            else return false;
        }else {
            return false;
        }*/

        Map<Integer, Integer> freqCountMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqCountMap.put(freq, freqCountMap.getOrDefault(freq, 0) + 1);
        }

        int size = freqCountMap.size();
        // If all characters already have same frequency
        if (size == 1)
            return true;

        // If more than 2 different frequencies, not fixable with one deletion
        if (size > 2)
            return false;

        // Get the two frequencies and their counts
        List<Integer> freqs = new ArrayList<>(freqCountMap.keySet());
        int f1 = freqs.get(0), f2 = freqs.get(1);
        int count1 = freqCountMap.get(f1), count2 = freqCountMap.get(f2);

        // Case 1: One frequency is 1 and occurs only once → remove that char
        if ((f1 == 1 && count1 == 1) || (f2 == 1 && count2 == 1))
            return true;

        // Case 2: Frequencies differ by 1 and the higher one occurs only once
        if ((Math.abs(f1 - f2) == 1) && ((f1 > f2 && count1 == 1) || (f2 > f1 && count2 == 1)))
            return true;

        return false;
    }

    static Map<Character, Integer> numberFrequency(char[] a){
        Map<Character, Integer> numberFrequencyMap = new HashMap<>();
        for(char x: a){
            numberFrequencyMap.put(x,
                    numberFrequencyMap.getOrDefault(x, 0) + 1);
        }
        return numberFrequencyMap;
    }

    public static void main(String[] args) {

        String s = "xxxxyyzz";

        boolean flag = sameFreq(s);

        System.out.println(flag);

    }
}
