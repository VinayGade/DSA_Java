package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PairsWithSum {

    static class pair  {
        long first, second;
        public pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static pair[] allPairs( long A[], long B[], long N, long M, long X) {

        // binary seach method
        List<pair> al=new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<N;i++){
            int low=0;
            int high=B.length-1;
            while(low<=high){
                int  mid=(low+high)/2;
                long val=A[i]+B[mid];
                if(val==X){
                    al.add(new pair(A[i],B[mid]));
                    break;
                }else if(val>X)
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        pair p[]=new pair[al.size()];
        for(int i=0;i<al.size();i++){
            p[i]=al.get(i);
        }

        return p;
    }

    static pair[] allPairsBinarySearch( long A[], long B[], long N, long M, long X) {
        Arrays.sort(A);
        Arrays.sort(B);
        List<pair> pairs = new ArrayList<>();
        for(int i=0; i<(int)N; i++){
            long D = X - A[i];
            int index = binarySearch(B, D);
            if(index!=(-1)){
                long K = B [index];
                pairs.add(new pair(A[i], K));
            }
        }
        //String[] arr = list.stream().toArray(String[] ::new);
        pair[] pairArr = pairs.stream().toArray(pair[] ::new);
        return pairArr;
    }

    static int binarySearch(long arr[], long key){
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int mid = (low + high) / 2;

            if(arr[mid] == key)
                return mid;
            else if(arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Brute - force
    static pair[] allPairsWorst( long A[], long B[], long N, long M, long X) {
        // Your code goes here
        Arrays.sort(A);
        ArrayList<pair> pairs = new ArrayList<>();

        for (int n=0; n<N; n++) {
            for (int m=0; m<M; m++) {
                if (A[n] + B[m] == X) {
                    pairs.add(new pair(A[n], B[m]));
                }
            }
        }

        return pairs.toArray(new pair[0]);
    }

    // using Set
    public pair[] allPairsHashSet( long A[], long B[], long N, long M, long X) {

        Arrays.sort(A);
        HashSet<Long> set = new HashSet<>();
        // pair[] result = new pair[1];
        ArrayList<pair> list = new ArrayList<>();

        for(long num:B)
            set.add(num);

        for(long num: A){

            long find = (X - num);

            if(set.contains(find)){
                list.add(new pair( num, find));
            }
        }

        pair[] result = new pair[list.size()];

        for (int i = 0; i < list.size(); i++) {
            pair p = list.get(i);
            result[i] = new pair(p.first, p.second);
        }
        return result;
    }

    public static void main(String[] args) {

        long A[] = {1, 2, 4, 5, 7};
        long B[] = {5, 6, 3, 4, 8};
        long X = 9;

        pair[] pairs = allPairs(A, B, A.length, B.length, X);
        Arrays.stream(pairs).forEach(pair ->
                System.out.println( pair.first+" "+pair.second));
    }
}
