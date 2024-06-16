package greedy.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToysPriyanka {

    public static int toys(List<Integer> prices) {
        int k = 4;
        Collections.sort(prices);
        int selectedWeight = prices.get(0);
        int cost = 1;

        for(int price: prices){
            if(price > (selectedWeight + k)){
                cost++;
                selectedWeight = price;
            }
        }
        return cost;
    }

    /*
    * input:
8
1 2 3 21 7 12 14 21

Output: 4
    * */

    public static void main(String[] args) {
        int n = 8;
        List<Integer> list = Arrays.asList(1, 2, 3, 21, 7, 12, 14, 21);
        int containerCount = toys(list);
        System.out.println(containerCount);
    }

}
