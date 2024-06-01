package search.practice;

import java.util.Arrays;
import java.util.Scanner;

//CodeChef: Devu and friendship testing

/*
Devu has n weird friends. Its his birthday today, so they thought that this
is the best occasion for testing their friendship with him.
They put up conditions before Devu that they will break the friendship
unless he gives them a grand party on their chosen day.
Formally, ith friend will break his friendship if he does not receive a grand party on dith day.

Devu despite being as rich as Gatsby, is quite frugal and can give
at most one grand party daily. Also, he wants to invite only one person in a party.
So he just wonders what is the maximum number of friendships he can save.
Please help Devu in this tough task !!

Input
The first line of the input contains an integer T denoting the number of test cases.
The description of T test cases follows.
First line will contain a single integer denoting n.
Second line will contain n space separated integers where ith integer
corresponds to the day dith as given in the problem.

Input
2
2
3 2
2
1 1

Output
2
1
* */
public class DevuFriendship {

    static int friendship(int[] a, int n){
        Arrays.sort(a);
        int count = 1;
        for(int i=0; i<(n-1); i++){
            if(a[i]!=a[i+1])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){
            int N = scan.nextInt();
            int[] a = new int[N];
            for(int i=0; i<N; i++)
                a[i] = scan.nextInt();

            int count = friendship(a, N);
            System.out.println(count);
        }
    }
}