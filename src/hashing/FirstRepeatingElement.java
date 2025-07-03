package hashing;

import java.util.*;

public class FirstRepeatingElement {

    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {

        /*
       int index=-1;
       Map<Integer, Integer> indexMap = new LinkedHashMap<>();
        for(int i=0; i<n; i++){
            if(!indexMap.containsKey(arr[i]))
                indexMap.put(arr[i], i+1);
        }
        Map.Entry<Integer, Integer> keyEntry = null;

        int i=0;
        for(Map.Entry<Integer, Integer> entry: indexMap.entrySet()){
            if(i>0)
                break;
            keyEntry=entry;
            i++;
        }
        for(int j=n-1; j>=0; j--){
            if(arr[j]==keyEntry.getKey()){
                index=keyEntry.getValue();
                break;
            }
        }
        return index;
        */

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<n; i++)
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0)+1);

        for(int i=0; i<n; i++)
            if(frequencyMap.get(arr[i])>1)
                return i+1;

        return -1;
    }

    public static int firstRepeatedFound(int[] arr, int n) {

        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!indexMap.containsKey(arr[i]))
                indexMap.put(arr[i], i+1);
            else
                return indexMap.get(arr[i]);
        }
        return -1;
    }

    public static int firstRepeatingElement(int[] elements, int n) {
        int index = -1;
        Set<Integer> set = new HashSet<>();

        for (int i = n - 1; i>=0; i--) {
            if (set.contains(elements[i]))
                index = i;
            set.add(elements[i]);
        }
        return  (index != -1) ? elements[index] : index;
    }

    public static Map<Integer, Integer> findFrequency(ArrayList<Integer> A){
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for(int x: A){
            frequencyMap.put(x, frequencyMap.getOrDefault(x, 0)+1);
        }
        return frequencyMap;
    }

    public int findFirstRepeating(ArrayList<Integer> A){
        int repeating = -1;
        Map<Integer, Integer> frequencyMap =findFrequency(A);
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            if(entry.getValue() > 1){
                repeating = entry.getKey();
                break;
            }
        }
        return repeating;
    }

    public static void main(String[] args) {
        int n = 7;
        int arr[] = {1, 5, 3, 4, 3, 5, 6};

        int index = firstRepeated(arr, n);
        int element = firstRepeatingElement(arr, n);
        int repeatingFound = firstRepeatedFound(arr, n);

        System.out.println("first repeating element ="+element);
        System.out.println("index of first repeating element ="+index);
        System.out.println("index of first occurrence of repeating element found="+repeatingFound);
    }
}
