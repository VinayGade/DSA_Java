package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestSubString {

    public static String findShortestSubString(String s, String t) {
        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowFreq.get(c) <= tFreq.get(c)) {
                count++;
            }

            while (left <= right && count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                windowFreq.put(s.charAt(left), windowFreq.get(s.charAt(left)) - 1);
                if (tFreq.containsKey(s.charAt(left)) && windowFreq.get(s.charAt(left)) < tFreq.get(s.charAt(left))) {
                    count--;
                }
                left++;
            }
        }

        if (minLen > s.length()) {
            return "IMPOSSIBLE";
        }

        return s.substring(start, start + minLen);
    }

    public static String findShortestSubstring(String s, String t,
                                               int n, int m) {

        Map<Character, Integer> tFreq = characterFrequency(t);
        Map<Character, Integer> windowFreq = new HashMap<>();

        int minLength = Integer.MIN_VALUE;
        int start = 0;
        int left = 0;
        int count = 0;

        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0)+1);

            if(tFreq.containsKey(c) && windowFreq.get(c) <= tFreq.get(c))
                count++;

            while(left <= right && count == m){
                if((right - left + 1) < minLength){
                    minLength = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                windowFreq.put(l, windowFreq.get(l)-1);

                if(tFreq.containsKey(l) && windowFreq.get(l) < tFreq.get(l))
                    count--;

                left++;
            }
            if (minLength > n)
                return "IMPOSSIBLE";
        }
        return s.substring(start, start + minLength);
    }

    public static Map<Character, Integer> characterFrequency(String string){

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c: string.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        return frequencyMap;
    }

    public static void main (String[] args) throws java.lang.Exception{

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String S = scanner.next();
        String T = scanner.next();
        //String result = findShortestSubstring(S, T, n, m);
        String result = findShortestSubString(S, T);
        System.out.println(result);
        scanner.close();
    }
}
