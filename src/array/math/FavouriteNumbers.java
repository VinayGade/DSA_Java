package array.math;

/*
Alice likes numbers which are even, and are a multiple of 7.
Bob likes numbers which are odd, and are a multiple of 9.

Alice, Bob, and Charlie find a number A.

If Alice likes A, Alice takes home the number.
If Alice likes A, Bob takes home the number.
If both Alice and Bob don't like the number, Charlie takes it home.

Given A, find who takes it home.

Note: You can prove that there is no integer A such that both Alice and Bob like it.

Input:
8
7
14
21
18
27
63
126
8

Output:
Charlie
Alice
Charlie
Charlie
Bob
Bob
Alice
Charlie
* */

import java.util.Scanner;

public class FavouriteNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int a = scanner.nextInt();
            String winner = findWinner(a);
            System.out.println(winner);
        }
    }

    static String findWinner(int a){

        String winner = "";
        /*
        * if(even)
            if(%7==0)
               'Alice'
          else
             if(%9==0)
                'Bob'
          'Charlie' otherwise
        * */

        if(a % 2 == 0 && a % 7 == 0)
            winner = "Alice";
        else if(a % 2 == 1 && a % 9 == 0)
            winner = "Bob";
        else
            winner = "Charlie";

        return winner;
    }
}
