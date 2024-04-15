package search.practice;

import java.util.*;

// HackerRank > Algorithms > search
public class IceCreamParlour {

    // approach 1
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        List<Integer> flavors = new ArrayList<>();
        int n = arr.size();
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if((arr.get(i)+arr.get(j)) == m){
                    flavors.add(i+1);
                    flavors.add(j+1);
                    break;
                }
            }
        }
        return flavors;
    }

    // approach 2
    public static List<Integer> icecreamParlorMap(int m, List<Integer> arr) {
        /*
        x+y = m
          y = m-x
        * */
        List<Integer> selectedFlavors = new ArrayList<>();
        Map<Integer, Integer> flavorIndexMap = new HashMap<>();
        int n = arr.size();
        for(int i=0; i<n-1; i++){
            int x = arr.get(i);
            int y = m-x;
            Integer j = flavorIndexMap.get(y);
            if(j!=null){
                selectedFlavors.add(j+1);
                selectedFlavors.add(i+1);
            }
            flavorIndexMap.put(x, i);
        }
        return selectedFlavors;
    }

    public static void main(String[] args) {

        int m = 6;
        List<Integer> prices = Arrays.asList(1,2,3,5,6);
        List<Integer> purchasedFlavors = icecreamParlor(m, prices);
        System.out.println("Amount of money spent = "+m);
        System.out.println("2 distinct flavors chosen = "
                +prices.get(purchasedFlavors.stream().findFirst().get()-1) + ", " +
                +prices.get(purchasedFlavors.get(1)-1));
    }
}
