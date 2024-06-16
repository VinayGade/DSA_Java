package array.math.two_pointers;

//CodeChef: College Life 5

import java.util.Scanner;

/*
There is only 1 TV in the common room, and as luck would have it, both the El Clasico football match and
the India-Pakistan cricket match are happening simultaneously.

There is one football fan who is looking at the live commentary online and will scream whenever an
'important' event takes place in the El Clasico. Similarly, there is a cricket fan who will do so
for every important event in the cricket match.

Find the total number of times you will have to switch between the channels.

|F| = N, |C| = M

F[] = {F1, F2, F3, ..., Fn} the times when an important event happens in the football match
C[] = {C1, C2, C3, ..., Cm} the times when an important event happens in the cricket match

Input:

3
2 2
1 3
2 4
3 1
100 200 300
1
1 2
1
100 200

Output:
3
2
1
* */
public class CollegeLife {

    public static void main (String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){

            int N = scan.nextInt();
            int M = scan.nextInt();

            int[] F = new int[N];  // football events
            int[] C = new int[M];  // circket events

            for(int i=0; i<N; i++)
                F[i] = scan.nextInt();

            for(int j=0; j<M; j++)
                C[j] = scan.nextInt();

            //find total number of switch among F and C
            int countSwitches = countSwitch(F, C, N, M);
            System.out.println(countSwitches);
        }

    }

	/*
	Input:
	4
2 2
1 3
2 4
3 1
100 200 300
1
1 2
1
100 200
1 1
1000000000
27

Output:
3
2
1
2
	*/

    static int countSwitch(int[] F, int[] C, int N, int M){

        /*
        Observation:

        Case 1: Initially We are watching Football

        i. Fi < Cj  ... Football event occurs before cricket event.  -> no need to switch
        ii.Cj < Fi  ... cricket event occurs before Football event.  -> switch

        Case 2: We are watching Cricket currently

        i. Cj < Fi  ... Continue watching, cricket event occurs before Football event.  -> no need to switch
        ii.Fi < Cj  ... Football event occurs before cricket event.  -> switch

        What happens when all the important events of one of the sport are completed ?
        * */

        /*
        int count = 0;
        if(N==M)
            count += N+M-1;
        else{
            int max = Math.max(N, M);
            int min = Math.min(N, M);
            count = max-min;
        }
        return count;
        */

        int i = 0, j = 0;
        boolean flag = true; //Football Event flag
        int count = 1;       // count number of switches

        while(i < N && j < M){
            if(F[i] < C[j]){   //Football event occurs before cricket event.
                if(!flag){     // watching Cricket
                    count++;   // switch to football
                    flag = !flag;  // reset flag
                }
                i++;  // Football event watched
            }else{              //cricket event occurs before Football event.
                if(flag){       // watching football
                    count++;    // switch to cricket
                    flag = !flag;  // reset flag
                }
                j++;  // cricket event watched
            }
        }
        return count;
    }
}
