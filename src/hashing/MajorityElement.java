package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public ArrayList<Integer> findMajority(int[] arr) {

        int n = (int) (arr.length/3);

        HashMap<Integer, Integer> map = findFrequency(arr);
        ArrayList<Integer> majorityElements = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > n){
                majorityElements.add(entry.getKey());
            }
        }
        Collections.sort(majorityElements);
        return majorityElements;
    }

    public ArrayList<Integer> findMajorityElement(int[] arr) {

        int n = (int) (arr.length/3);

        HashMap<Integer, Integer> map = findFrequency(arr);
        ArrayList<Integer> majorityElements = new ArrayList<>();

        map.forEach((key, value) -> {
            if (value > n) {
                majorityElements.add(key);
            }
        });
        Collections.sort(majorityElements);
        return majorityElements;
    }

    HashMap<Integer, Integer> findFrequency(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x: arr){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        return map;
    }

}
