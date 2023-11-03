package hashing;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {

    public static void main(String[] args) {
        int [] a = {6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13};
        int size = a.length;
        int repeated = majorityElement(a, size);
        System.out.println("Most repeated element = "+repeated);
    }
        static int majorityElement(int a[], int size){
            int mostFrequent = -1;
            if(size > 1){
                if(size == 2 && (a[0] == a[1]))
                    mostFrequent = a[0];
                else{
                    int maxFrequency = 1;
                    int half = (int)(size/2);
                    Map<Integer, Integer> numberFrequencyMap = numberFrequency(a, size);
                    for(Map.Entry<Integer, Integer> entry: numberFrequencyMap.entrySet()){
                        int value = entry.getValue();
                        if(value > maxFrequency){
                            maxFrequency = value;
                            if(maxFrequency > half)
                                mostFrequent = entry.getKey();
                        }
                    }
                }
            }
            return mostFrequent;
        }

        static Map<Integer, Integer> numberFrequency(int a[], int size){

            Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
            for(int i=0; i<size; i++){
                if(numberFrequencyMap.containsKey(a[i]))
                    numberFrequencyMap.put(a[i], numberFrequencyMap.get(a[i])+1);
                else
                    numberFrequencyMap.put(a[i], 1);
            }
            return numberFrequencyMap;
        }
}
