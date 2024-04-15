package heap.problems;

import java.util.PriorityQueue;

// LeetCode 2785. (Medium) Sort Vowels in a String

public class SortVowelsString {

    public static String sortVowels(String s) {
        char[] str = s.toCharArray();
        PriorityQueue<Character> pq = new PriorityQueue<Character>();

        String vowels = "AEIOUaeiou";
        for (char c : str)
            if (vowels.indexOf(c) != -1)
                pq.offer(c);

        for (int i=0; i < str.length; i++)
            if (vowels.indexOf(str[i]) != -1)
                str[i] = pq.poll();

        return new String(str);
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        String result = sortVowels(s);
        System.out.println(result);
    }
}
