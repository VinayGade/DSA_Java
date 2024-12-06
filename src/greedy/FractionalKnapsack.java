package greedy;

import java.util.Arrays;
import java.util.Comparator;

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

        //eg 2
        Item[] arr2 = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50;

        double maxValue = getMaxValue(arr, capacity);

        // Function call
        System.out.println(maxValue);
    }

    //approach 2:

    //method to get maximum value
    private static double getMaxValue(Item[] arr, int W){
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {

                double cpr1
                        = new Double((double)item1.val
                        / (double)item1.wt);
                double cpr2
                        = new Double((double)item2.val
                        / (double)item2.wt);

                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });

        double totalValue = 0d;
        for(Item i: arr){
            int curWt = i.wt;
            int curVal = i.val;

            if(W-curWt >= 0){
                //This weight can be picked whole
                W = W-curWt;
                totalValue+=curVal;
            }else{
                //item could be picked in fractional amt
                double fraction = (double)W/(double)curWt;
                totalValue += (curVal * fraction);
                W=(int) (W -(curWt * fraction));
                break;
            }
        }
        return totalValue;
    }
}
