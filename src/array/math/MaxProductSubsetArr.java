package array.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Input: arr[] = [-1, 0, -2, 4, 3]
Output: 24
Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
* */

public class MaxProductSubsetArr {

    public static long findMaxProduct(List<Integer> arr) {
        int n = arr.size();
        if(n <= 2){
            if(arr.contains(0))
                return 0;
            else if(n == 1)
                return arr.get(0);
            else
                return (long) arr.get(0) * arr.get(1);

        }else{
            int countNeg = 0;
            long negProduct = 1;
            long product = 1;
            Collections.sort(arr);
            long first = arr.get(0);
            for(int i = 0; i<n; i++){
                long x = arr.get(i) ;
                //long next = arr.get(i+1) ;
                if(x <= 0 && arr.get(i+1) > 0 && countNeg > 0){
                    if(x == 0){
                        first = arr.get(i-1);
                        //continue;
                    }else{
                        first = arr.get(i);
                    }
                }
                else if(x < 0){
                    negProduct *= x;
                    countNeg++;
                }
                else{
                    product *= x;
                }
            }
            if(countNeg > 1){
                if(countNeg % 2 == 1){
                    negProduct /= first;
                }
                product *= negProduct;
            }
            return product;
        }
    }

    public static long findMaxProduct(List<Integer> arr, int n) {
        // If the array is empty, return 0
        if(arr==null || arr.isEmpty())
            return 0;

        //int n=arr.size();

        if(n==1)
            return arr.get(0);

        int min=0;
        int count_neg=0,count_zero=0;
        int mod=1000000007;
        int id=-1;
        long prod=1;

        for(int i=0;i<n;i++){
            int num=arr.get(i);
            if(num==0) {
                count_zero++;
                continue;
            }

            if(num<0){
                count_neg++;
                if(id==-1 || num>min){
                    id=i;
                    min=num;
                }
            }
        }
        if(count_zero==n)
            return 0;

        if(count_neg==1 && count_zero==n-1)
            return 0;

        for(int i=0; i<n; i++){
            int num=arr.get(i);
            if(num==0)
                continue;

            if(count_neg%2==1 && i==id)
                continue;

            prod=((prod*num)%mod+mod)%mod;
        }
        return prod;
    }

    public long findMaxProduct(int n, List<Integer> arr) {

        if(n==1)
            return arr.get(0);
        long pos=1,neg=1,negLar=Long.MIN_VALUE,mod=1000000007,c1=0,c2=0;
        for(Integer x: arr){
            if(x<0){
                neg=(neg*(long)x)%mod;
                negLar=Math.max((long)x,negLar);
                c1++;
            }
            if(x>0){
                pos=(pos*(long)x)%mod;
                c2++;
            }
        }
        if(c1<=1 && c2==0)
            return 0;
        if(neg<0)
            neg/=negLar;
        return (pos*neg)%mod;
    }

    public static ArrayList < Integer > factor(int n) {
        ArrayList < Integer > ret = new ArrayList < > ();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ret.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            ret.add(n);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(-1, 0, -2, 4, 3);
        int n = arr.size();
        long maxProduct = findMaxProduct(arr, n);
        System.out.println(maxProduct);
    }
}