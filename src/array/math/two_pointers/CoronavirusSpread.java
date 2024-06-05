package array.math.two_pointers;

import java.util.Scanner;

//Codechef
public class CoronavirusSpread {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int N = scan.nextInt();
            int[] a = new int[N];
            for(int i=0; i<N; i++)
                a[i] = scan.nextInt();
            int[] infectedPeople = countInfectedPeople(a, N);
            System.out.print(infectedPeople[0]+" "+
                    infectedPeople[1]);
            System.out.println();
        }
    }

    static int[] countInfectedPeople(int[] a, int n){
        int[] infected =  new int[2]/*{1, 1}*/;
        int maximum = 1;
        int minimum = Integer.MAX_VALUE;
        int count = 1;
        for(int i=1; i<n; i++){
            if((a[i] - a[i-1]) <= 2){

                count++;
	           /*
	            infected[0]+=2;
	            infected[1]+=;
	            */
            }else{
                maximum = Math.max(count, maximum);
                minimum = Math.min(count, minimum);
                count = 1;
            }
        }
        maximum = Math.max(count, maximum);
        minimum = Math.min(count, minimum);
        infected[0] = minimum;
        infected[1] = maximum;
        return infected;
    }
}
