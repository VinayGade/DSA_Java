package greedy.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ToysMark {

    public static int maximumToys(List<Integer> prices, int k) {

        //loop through at each element until we reach the end of the array
        int toyCount = 0;
        int cost =0;
        int maxToys =0;
        int index = 0;
        Collections.sort(prices);

        //before we incremet toyCount we check if we are above the price limit
        //move throught the sorted list aggregating the cost
        while((cost + prices.get(index))<= k){
            toyCount++;
            cost+=prices.get(index);
            index++;

            maxToys = Math.max(toyCount, maxToys);
        }
        return maxToys;
    }

    public static void main(String[] args) {
        int n=7, k=50;
        List<Integer> prices = Arrays.asList(1, 12, 5, 111, 200, 1000, 10);
        int maxToys = maximumToys(prices, k);
        System.out.println(maxToys);
    }
}
