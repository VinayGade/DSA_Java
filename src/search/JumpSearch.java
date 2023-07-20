package search;

import java.util.Scanner;

public class JumpSearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = { 10, 30, 50, 70, 100, 150, 180, 200, 210, 140, 300, 390, 500, 900, 1000};

        int key = 900;
        int position = jumpSearch(arr, key);

        System.out.println("Element "+key+" is found at "+position);
    }

    public static int jumpSearch( int[] a, int key){

        int n = a.length;
        int step = (int) Math.floor(Math.sqrt(n));  //block size to jump.

        int prev = 0;

        // Find block where element is present

        while(a[Math.min(step, n) - 1] < key){

            prev = step;
            step += (int) Math.floor(Math.sqrt(n));  // step += step;

            if(prev >= n)
                return -1;
        }

        // Perform linear search to find key inside selected block

        while(a[prev] < key){

            prev++;
            if(prev == Math.min( step,n))
                return -1;
        }

        if(a[prev] == key)
            return prev;

        return -1;
    }
}