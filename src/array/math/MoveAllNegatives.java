package array.math;

import java.util.ArrayList;
import java.util.List;

public class MoveAllNegatives {

    /*
    Input :
n = 8
arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output :
1  3  2  11  6  -1  -7  -5

Input :
n = 8
arr[] = {-5, 7, -3, -4, 9, 10, -1, 11}
Output :
7  9  10  11  -5  -3  -4  -1
    * */

    static int[] segregateElements(int arr[], int n) {
        int j=0;
        //int n=arr.length;
        List<Integer> negatives = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(arr[i]>=0) {
                arr[j]=arr[i];
                j++;
            }else
                negatives.add(arr[i]);
        }
        int k = 0;
        //while(j<n && k < negatives.size()) {
        while(j<n) {
            arr[j]=negatives.get(k);
            j++;
            k++;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] array = {1, -1, 3, 2, -7, -5, 11, 6};
        int n = array.length;
        int[] shifted = segregateElements(array, n);
        //int[] result = moveZeroesOptimized(array);
        for(int x: shifted){
            System.out.print(x+" ");
        }
    }
}
