package array.math.hackerrank.mini_max_sum;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {

        double pos=0;
        double neg =0;
        double zero =0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>0){
                pos++;
            }
            else if(arr.get(i)<0){
                neg++;
            }
            else{
                zero++;
            }
        }
        System.out.println(pos/arr.size());
        System.out.println(neg/arr.size());
        System.out.println(zero/arr.size());
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 0, -1, -1);
        plusMinus(arr);
    }
}
