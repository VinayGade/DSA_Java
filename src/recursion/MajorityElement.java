package recursion;

import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityElement {

    /*
    Given an array A of N elements. Find the majority element in the array. A majority element
 in an array A of size N is an element that appears strictly more than N/2 times in the array.
    * */

    static int majorityElement(int a[], int size) {
        int majority = -1;
        int halfSize = size/2;
        Map<Integer, Integer> numberFrequency = frequency(a, size);
        for(Map.Entry<Integer, Integer> entry: numberFrequency.entrySet()){
            if(entry.getValue()>halfSize){
                majority = entry.getKey();
                break;
            }
        }
        return majority;
    }

    static Map<Integer, Integer> frequency(int a[], int size){
        Map<Integer, Integer> numberFrequency = new LinkedHashMap<>();
        for(int i=0; i<size; i++)
            numberFrequency.put(a[i], numberFrequency.getOrDefault(a[i], 0)+1);
        return numberFrequency;
    }

    // Leetcode 169. Majority Element
    // time complexity : O(N) space : O(1)
    public static int majorityElement(int[] num) {
        int n = num.length;
        int count = 0;
        int major = num[0];
        for(int i: num) {
            if(count==0){
                major=i;
                count++;
            }
            else if(i==major)
                count++;
            else
                count--;
        }
        return (count > n/2) ? major : -1;
    }

    static int majorityElementMoore(int a[], int size) {
        /*****MOORE's ALGORITHM*****/
        int el=-1,count=0;

        for(int i=0;i<size;i++){
            if(count==0){
                el=a[i];
                count=1;
            }
            else if(a[i]==el)
                ++count;
            else
                --count;
        }
        count=0;
        for(int i:a){
            if(i==el)
                count++;
        }
        if(count>(size/2))
            return el;
        return -1;
    }

    public static void main(String[] args) {
        int a[]={3,1,3,3,2,5,3,5,3,9,3,3};
        int size=a.length;
        int majority = majorityElement(a, size);
        int majorityItem = majorityElement(a);
        System.out.println("Majority Element = "+majority);
        System.out.println("Majority Item = "+majorityItem);
    }
}
