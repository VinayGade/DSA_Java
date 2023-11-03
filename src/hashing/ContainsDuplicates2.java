package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

// LeetCode 219. Contains Duplicates
public class ContainsDuplicates2 {

    // a[i] == a[j]   (i-j) <= k

    public static void main(String[] args) {
        /*
        int[] a = {1,2,3,1};
        int k = 3;
        */
        int[] a = {1,0,1,1};
        int k = 1;
        int n = a.length;
        System.out.println(containsNearbyDuplicate(a, n, k));
    }

    /*
    public static boolean containsNearbyDuplicate(int[] a, int k) {

        int n = a.length;

        int[] duplicateIndex = firstDuplicateElement(a, n);

        return (duplicateIndex[1] - duplicateIndex[0]) <= k;
    }
     */

    private static boolean containsNearbyDuplicate(int[] a, int n, int k){

       // int[] duplicateIndex = new int[2];
        Map<Integer, Integer> numberIndices = new LinkedHashMap<>();
        //int[] visited = new int[n];

        for(int i=0; i<n; i++)
            if(numberIndices.containsKey(a[i]) && Math.abs(numberIndices.get(a[i])-i)<=k)
                return true;
            else
                numberIndices.put(a[i], i);;

        return false;
    }

}
