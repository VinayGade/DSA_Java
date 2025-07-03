package search.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class CountIn2Arr {

    public static ArrayList<Integer> countLessEq(int a[], int b[]) {

        ArrayList<Integer> ans = new ArrayList<>();

        int n = a.length;
        Arrays.sort(b);

        for (int x : a) {

            int count = binarySearch(b, x);
            while (count < b.length && b[count] == x)
                count++;

            ans.add(count);
        }
        return ans;
    }

    static int binarySearch(int[] a, int key){

        int low = 0;
        int high = a.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(a[mid] == key){
                return mid;
            }else if(a[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int a[] = {4, 8, 7, 5, 1};
        int b[] = {4, 48, 3, 0, 1, 1};

        ArrayList<Integer> ans = countLessEq(a, b);

        for(int x: ans){
            System.out.println(x);
        }
    }
}
