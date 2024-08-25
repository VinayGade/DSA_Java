package array.math.two_pointers;

import java.util.Scanner;

// CodeChef : Greedy Algorithms : Snakes, Mongooses and the Ultimate Election

/*
eg.
input:
4
sm
ssm
sms
ssmmmssss

Output:
mongooses
tie
tie

snakes
* */

public class SnakeMongooseGame {

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading 't'

        while (t-- > 0) {

            String input = scanner.nextLine().trim();

            String winner = snakeMongooseElection(input);
            //String winner = snakeMongooseGame(input);
            System.out.println(winner);
        }
    }

    static String snakeMongooseElection(String str) {

        int s = 0; // snake count
        int m = 0; // mongoose count

        char[] input = str.toCharArray();
        int n = input.length;

        // keep track of eaten snakes
        boolean[] eaten = new boolean[n];

        // Count initial snakes and mongooses
        for (int i = 0; i < n; i++) {
            if (input[i] == 's')
                s++;
            else if (input[i] == 'm')
                m++;
        }

        // Simulate eating process
        for (int i = 0; i < n; i++) {

            if (input[i] == 'm') {

                // Check left neighbor

                if (i > 0 && input[i - 1] == 's' && !eaten[i - 1]) {
                    eaten[i - 1] = true;
                    s--; // Mongoose eats the snake
                }

                // Check right neighbor

                else if (i < (n - 1) && input[i + 1] == 's' && !eaten[i + 1]) {
                    eaten[i + 1] = true;
                    s--; // Mongoose eats the snake
                }
            }
        }
        return (m > s) ? "mongooses" :(m < s) ? "snakes" : "tie";
    }

    static String snakeMongooseGameVoting(String input){
        int s = 0;  // snake count
        int m = 0;  // mongoose count
        int n = input.length();

        boolean[] eaten = new boolean[n]; // To keep track of eaten snakes

        // Count initial snakes and mongooses
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 's') {
                s++;
            } else if (input.charAt(i) == 'm') {
                m++;
            }
        }

        // Simulate eating process
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'm') {
                // Check left neighbor
                if (i > 0 && input.charAt(i - 1) == 's' && !eaten[i - 1]) {
                    eaten[i - 1] = true;
                    s--; // Mongoose eats the snake
                }
                // Check right neighbor
                else if (i < n - 1 && input.charAt(i + 1) == 's' && !eaten[i + 1]) {
                    eaten[i + 1] = true;
                    s--; // Mongoose eats the snake
                }
            }
        }

        // Determine the winner
        if (m > s) {
            return "mongooses";
        } else if (s > m) {
            return "snakes";
        } else {
            return "tie";
        }
    }

    static String snakeMongooseGame(String input){

        /*
        Snake Mongoose Game
        i.  1 Mongoose can eat 1 snake adjacent to it.

        ii. After (i), if | Mongoose | == | Snakes |.  then "tie".

        iii.After (i). winner = Max ( | Mongoose | , | Snakes |)
        */

        /*
        Input
        4
        sm
        ssm
        sms
        ssmmmssss

Output
mongooses
tie
tie
snakes
        */

        // 2 - Pointer Approach

        int i = 1;
        //int j = 1;

        int s = 0;  // snake count
        int m = 0;  // Mongoose count

        char[] turns = input.toCharArray();

        int n = turns.length;

        boolean[] eaten = new boolean[n];

        if(turns[0] == 'm')
            m++;
        else
            s++;

        while(n>2 && i<(n-1)){

            if(turns[i] == 'm')
                m++;

            if(turns[i] == 's'
                    //|| turns[j] == 's'
            ) {
                s++;
                if((turns[i] != turns[i-1] && turns[i-1] == 'm') ||
                        (turns[i] != turns[i+1] && turns[i+1] == 'm')) {

                    //if(turns[i] == 's')
                        turns[i] = '.';
                    //else
                        //turns[j] = '.';
                    eaten[i] = true;
                    s--;
                }
            }
            i++;
            //j++;
        }

        if(turns[n-1] == 'm')
            m++;
        else{
            if(turns[n-1] == 's'){
                if(turns[n-2] == 'm' && turns[n-3] != '.')
                //!eaten[n-1])
                    s--;
                else
                    s++;
            }
        }

        return (m > s) ? "mongooses" :(m < s) ? "snakes" : "tie";
    }
}