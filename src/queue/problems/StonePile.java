package queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// CodeChef: Stack and Queue: Stone Pile
public class StonePile {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (--T >= 0) {
            int N = scanner.nextInt(); // count of stones
            int[] A = new int[N]; // pile of stones

            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }
            int[] result = stonePile(A, N);
            System.out.println(result[0]+" "+result[1]);
        }
    }

    public static int[] stonePile(int[] a, int n){
        int[] finisher = new int[n];
        /*
        Order : 1 0 1 0 ... until only 1 left in pile

        * Aman (1):
        *  1 - 1
        *  2 - 1
        *  Total Operations = 2
        * Akshat (0):
        *  1 - 2
        *  2 - 1
           Total Operations = 3

           Remove from Front and insert at the rear: QUEUE
        * */

        Queue<Integer> q = new LinkedList<>();
        for(int x: a)
            q.add(x);

        int player = 0; // Aman = 0 and he plays first
        while(q.size() > 1){
            if(player == 0){ // Aman's turn
                q.offer(q.poll());   //Move 1 rotate once
                q.poll();            //Move 2
            }else{ // Akshat's turn
                q.offer(q.poll());   //Move 1 rotate twice
                q.offer(q.poll());
                q.poll();            //Move 2
            }
            player = 1 - player;     // switch player after each turn
        }
        finisher[0] = player;
        finisher[1] = q.peek();  // returns the only element left in pile
        return finisher;
    }
}
