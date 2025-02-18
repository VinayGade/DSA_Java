package search.practice;

import java.util.Scanner;

//CodeChef : Binary Search : Pyramid of Bricks
public class PyramidOfBricks {

    public static void main(String[] args) {
        // Write your code here

        /*
        N bricks -> M layers

         N.    M
         3     2.     2 * (2+1)/2
         6.    3.     3 * (3+1)/2
         10.   4.     4 * (4+1)/2
         15.   5.     5 * (5+1)/2
         21    6.     6 * (6+1)/2

         N = M * (M + 1) / 2
        */

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int i=0; i<T; i++){
            int N = scanner.nextInt();
            int M = countLayers(N);
            System.out.println(M);
        }
    }

    static int countLayers(int n){

        // N = M * (M + 1) / 2

        int left = 0;
        int right = n;
        int count = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long totalBricks = (long) mid * (mid + 1) / 2;
            if(totalBricks <= n){
                count = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return count;
    }
}
