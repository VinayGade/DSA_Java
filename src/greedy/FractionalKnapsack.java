package greedy;

import java.util.Arrays;

/*
Fractional Knapsack:

Given: n items with {weight, value} of each item
       Capacity of Knapsack = W

Task: Put (all/ some) of these items into Knapsack such that final value of items
in knapsack is maximum.

Note: You can take fractional volume (part of weight) of item to gain maximum profit
(to gain maximum value.)

* */
class Item implements Comparable<Item>{

    int wt;
    int val;

    public Item(int w, int v){
        this.wt=w;
        this.val=v;
    }

    @Override
    public int compareTo(Item item) {
        return (wt*item.val - val*item.wt) ;
    }

}

public class FractionalKnapsack {

    static double fractionalKnapsack(Item[] arr, int W){
        Arrays.sort(arr);
        double result = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].wt <= W){
                result += arr[i].val;
                W=W-arr[i].wt;
            }else{
                result = result + arr[i].val * (double)W/(double)arr[i].wt;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Item[] arr = {
                new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)
        };
        int W = 50;
        double totalCost = fractionalKnapsack(arr, W);
        System.out.println(totalCost);
    }
}
