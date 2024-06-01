package hashing;

import java.util.*;

/*
input:
3
2
1 2
3
1 2 3
4
3 1 1 2

output:
YES
NO
YES
* */
public class EqualDistinct {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int N = scan.nextInt();
            int[] a = new int[N];
            for(int i=0; i<N; i++){
                a[i] = scan.nextInt();
            }
            String result = isEqualDistinct(a, N) ? "YES" :"NO";
            System.out.println(result);
        }
    }

    //way 1: using HashMap  ... optimized time and space complexity
    static boolean isEqualDistinct(int[] a, int n){
        if(n%2 == 0)
            return true;

        Map<Integer, Integer> map = numberFrequency(a);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > 1 )
                return true;
        }
        return false;
    }

    static Map<Integer, Integer> numberFrequency(int[] a){
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: a)
            map.put(x, map.getOrDefault(x, 0) + 1);
        return map;
    }

    //way 1: using HashSet  ... more time and less space complexity
    static boolean equalDistinct(int[] a, int n){
        if(n%2 == 0)
            return true;

        Set<Integer> set = new HashSet<>();

        for(int x: a)
            set.add(x);

        //set.addAll(a);

        return n > set.size();
    }
}
