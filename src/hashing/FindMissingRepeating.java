package hashing;

import java.util.*;

public class FindMissingRepeating {

    int[] findTwoElement(int A[], int n) {
        // find the missing and repeating element
        int missing = -1;
        int repeating = -1;
        boolean flag1 = true;
        boolean flag2 = true;
        Arrays.sort(A);
        for(int i=0; i<n; i++) {
            if (!flag1 && !flag2)
                break;
            if (flag1 && A[i] > (i + 1)) {
                missing = A[i] - 1;
                flag1 = false;
            }
            if (flag2 && i < (n - 1) && A[i] == A[i + 1]) {
                repeating = A[i];
                flag2 = false;
            }
        }
        return new int[]{repeating, missing};
    }

    // Most memory and time efficient solution using HashMap

    static int[] findTwoElementOptimized(int arr[], int n) {
        int[] twoElements = new int[2];
        Map<Integer, Integer> elements = new HashMap<>();

        for(int i: arr) {
            if(elements.containsKey(i))
                twoElements[0] = i;     //found repeating element
            else
                elements.put(i, 1);
        }

        for(int i=0; i<=n; i++) {
            if(!elements.containsKey(i))
                twoElements[1] = i;
        }
        return twoElements;
    }

    static int[] findMissingRepeating(int A[], int n){
        // find the missing and repeating element
        Arrays.sort(A);
        int missing = -1;
        int repeating = -1;
        Map<Integer, Integer> frequencyMap = findFrequency(A, n);
        int prev = A[0];
        boolean foundRepeating = false;
        boolean foundMissing = false;
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            if(foundRepeating && foundMissing)
                break;
            else {
                int v = entry.getValue();
                int k = entry.getKey();

                if (!foundRepeating && v > 1) {
                    repeating = k;
                    foundRepeating = true;
                }
                if (!foundMissing && (k - prev) > 1) {
                    missing = k - 1;
                    foundMissing = true;
                }
                prev = k;
            }
        }
        return new int[]{repeating, missing};
    }

    static Map<Integer, Integer> findFrequency(int A[], int n){
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for(int i=0; i<n; i++){
            int k = A[i];
            if(!frequencyMap.containsKey(k))
                frequencyMap.put(k, 1);
            else
                frequencyMap.put(k, frequencyMap.get(k)+1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
         /*
        N = 3
        Arr[] = {1, 3, 3}
        * */

        /*
        47
        13 33 43 16 25 19 23 31 29 35
        10 2  32 11 47 15 34 46 30 26
        41 18 5  17 37 39 6  4  20 27
        9  3  8  40 24 44 14 36 7  38
        12 1  42 12 28 22 45
        * */

        int arr[] = {
                13, 33, 43, 16, 25, 19, 23, 31, 29, 35,
                10, 2,  32, 11, 47, 15, 34, 46, 30, 26,
                41, 18, 5,  17, 37, 39, 6,  4,  20, 27,
                9,  3,  8,  40, 24, 44, 14, 36, 7,  38,
                12, 1,  42, 12, 28, 22, 45};
        int N = 47;
        //int[] solution = findMissingRepeating(arr, N);
        int[] solution = findTwoElementOptimized(arr, N);
        System.out.println(solution[0]+" "+solution[1]);
    }
}
