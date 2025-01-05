package hashing;

import java.util.*;

//Find Occurence of each Number in list

/*

You are given an integer array A.

You have to find the number of occurences of each number.

Return an array containing only the occurences with the smallest value's occurence first.

For example, A = [4, 3, 3], you have to return an array [2, 1], where 2 is the number of occurences for element 3,
and 1 is the number of occurences for element 4. But, 2 comes first because 3 is smaller than 4.

* */
public class OccurenceOfNumber {

    public static ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        Collections.sort(A);
        Map<Integer, Integer> frequencyMap = numberFrequency(A);
        ArrayList<Integer> occurences = new ArrayList<>(frequencyMap.values());
        return occurences;
    }

    private static Map<Integer, Integer> numberFrequency(ArrayList<Integer> A){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int x: A){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();//4, 3, 3
        numbers.add(4);
        numbers.add(3);
        numbers.add(3);
        ArrayList<Integer> occurences = findOccurences(numbers);
        for(int i: occurences)
            System.out.print(i+" ");
    }
}
