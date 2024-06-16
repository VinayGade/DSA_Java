package heap.problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
public class Largest2ndLargestSum {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                int sum = findSumLargest2ndLargest(a, n);
                System.out.println(sum);
            }
            // Your code goes here
        }

        static int findSumLargest2ndLargest(int[] a, int n) {

            int sum = 0;
            //int count = 0; //upto count == 2

            Queue < Integer > heap = new PriorityQueue < > (Collections.reverseOrder());

            for (int i = 0; i < n; i++)
                heap.add(a[i]);

            //int largest = heap.peek();
            int largest = heap.poll();
            sum += largest;
            //count++;

            for (int j = 0; j < (n-1); j++) {
                /*
                if (count == 2)
                    break;

                 */

                if(heap.peek() == largest)
                    heap.poll();
                else{
                    sum += heap.poll();
                    break;
                }

                //int max = heap.poll();

                /*
                if (max < largest) {
                    sum += max;
                    //count++;
                    break;
                }*/
            }
            return sum;
        }
}
