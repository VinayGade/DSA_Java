package hashing;

import java.util.*;

/*
Find Duplicate in Array

Given a read-only array of n + 1 integers between 1 and n,
find one number that repeats in linear time using less than O(n) space and
traversing the stream sequentially O(1) times.
If there are multiple possible answers ( like in the sample case ),
output any one, if there is no duplicate, output -1
* */
public class RepeatedElement {
    static int repeatedNumber(final List<Integer> A) {
        int result = -1;
        Set<Integer> distincts = new LinkedHashSet<>();
        for(int x: A){
            if(!distincts.isEmpty() && distincts.contains(x)){
                result = x;
                break;
            }
            distincts.add(x);
        }
        return result;
    }

    public int findDuplicate(int[] arr) {
        int n = arr.length;
        Set<Integer> elements = new HashSet<>();
        for (int j : arr) {
            if (elements.contains(j))
                return j;
            else
                elements.add(j);
        }
        return -1; // This statement won't execute as per the problem stmt
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 4, 1, 4, 2);
        int repeated = repeatedNumber(A);
        System.out.println(repeated);
    }
}
