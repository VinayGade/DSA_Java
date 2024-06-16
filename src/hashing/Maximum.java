package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maximum {

    public static void main (String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            //Map<Integer, Integer> frequencyMap = numberFrequency(a, n);

            int N = scan.nextInt();

            int[] a = new int[N];
            for(int i=0; i<N; i++)
                a[i] = scan.nextInt();

            int[] maximum = findMaximum(a, N);
            System.out.print(maximum[0]+" "+maximum[1]);
            System.out.println();
        }
    }

    static int[] findMaximum(int[] a, int n){

        Map<Integer, Integer> frequencyMap = numberFrequency(a, n);

        int[] maximum = new int[2];
        int max = -1;
        int maxFrequency = 0;
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            int v = entry.getValue();
            int k = entry.getKey();
            maxFrequency = Math.max(v, maxFrequency);
            if(v == maxFrequency)
                max = k;
        }

        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){

            int v = entry.getValue();
            int k = entry.getKey();
            if(v == maxFrequency && k < max){
                //if(k < max)
                max = k;
                //break;
            }
        }
        maximum[0] = max;
        maximum[1] = maxFrequency;
        return maximum;
    }

    static Map<Integer, Integer> numberFrequency(int[] a, int n){
        Map<Integer, Integer> frequency=new HashMap<>();

        for(int i=0; i<n; i++){
            if(!frequency.containsKey(a[i]))
                frequency.put(a[i], 1);
            else
                frequency.put(a[i], frequency.get(a[i])+1);
        }
        return frequency;
    }
}
