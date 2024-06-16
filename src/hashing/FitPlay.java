package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// CodeChef: Fit to Play

/*
Rayne Wooney has been one of the top players for his football club for the last few years.
But unfortunately, he got injured during a game a few months back and has been out of play
ever since.

He's got proper treatment and is eager to go out and play for his team again.
Before doing that, he has to prove to his fitness to the coach and manager of the team.
Rayne has been playing practice matches for the past few days. He's played N practice matches in all.

He wants to convince the coach and the manager that he's improved over time and
that his injury no longer affects his game.

 To increase his chances of getting back into the team, he's decided to show them stats of
 any 2 of his practice games.
 The coach and manager will look into the goals scored in both the games and see how much he's improved.
 If the number of goals scored in the 2nd game(the game which took place later) is greater than that in 1st,
 then he has a chance of getting in.

 Tell Rayne what is the maximum improvement in terms of goal difference that he can show
 to maximize his chances of getting into the team.

  If he hasn't improved over time, he's not fit to play. Scoring equal number of goals
  in 2 matches will not be considered an improvement.
  Also, he will be declared unfit if he doesn't have enough matches to show an improvement.

  input:
  3
6
3 7 1 4 2 4
5
5 4 3 2 1
5
4 3 2 2 3

Output:
4
UNFIT
1
* */

public class FitPlay {

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt(); //practice match count
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int d = goalDifference(a, n);
            System.out.println((d <= 0) ? "UNFIT" : d);
        }
    }

    static int goalDifference(int[] a, int n) {

        int difference = -1;
        int largest = -1;

        Map < Integer, Integer > indexMap = new HashMap < > ();
        for (int i = (n-1); i >= 0; i--) {
            largest = Math.max(largest, a[i]);
            indexMap.put(i, largest);
        }

        for (int i = 0; i < n; i++) {
            difference = Math.max(difference, indexMap.get(i) - a[i]);
        }
        return difference;
    }

    /*
    static int goalDifference(int[] a, int n) {
        int difference = -1;
        int maxIndex = -1;
        int largest = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] >= largest) {
                largest = a[i];
                maxIndex = i;
            }
        }
        difference = (maxIndex > 0) ? (largest - a[maxIndex - 1]) : largest - a[maxIndex + 1];
        return difference;
    }*/
}
