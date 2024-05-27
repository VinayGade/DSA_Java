package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DominantElement {

    // CodeChef: Dominant Element

    public static void main (String[] args) throws java.lang.Exception{
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int N = scan.nextInt();
            int[] a = new int[N];
            for(int i=0; i<N; i++)
                a[i] = scan.nextInt();

            Map<Integer, Integer> numberFrequencyMap = numberFrequency(a);

            /*
            int[] pair = dominantElement(numberFrequencyMap);
            int max = pair[0];
            int maxFrequency = pair[1];
            String result = (maxFrequency == 1) ? "NO" : "YES";
            */

            String result = dominantElement(numberFrequencyMap);
            System.out.println(result);
        }
    }

    static String dominantElement(Map<Integer, Integer> map){
        int maxFrequency = 1;
        //int max = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int frequency = entry.getValue();
            if(maxFrequency < frequency){
                //maxFrequency = Math.max(max, entry.getValue())
                maxFrequency = frequency;
                //max = entry.getKey();
            }
        }
        //int[] pair ={max, maxFrequency};

        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == maxFrequency)
                count++;
        }
        return (count > 1) ? "NO" : "YES";
    }

    static Map<Integer, Integer> numberFrequency(int[] a){
        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
        for(int x: a)
            numberFrequencyMap.put(x,
                    numberFrequencyMap.getOrDefault(x, 0) + 1);
        return numberFrequencyMap;
    }
}
