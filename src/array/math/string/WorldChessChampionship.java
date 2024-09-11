package array.math.string;

import java.util.Scanner;

/*
14 Classical games will be played between Chef and Carlsen in the championship,
where each game has one of three outcomes:
it can be won by Carlsen, won by Chef, or it can be a draw. The winner of a game gets 2 pts.
the loser gets 0 pts
if draw : 1 pt to each
The total prize pool of the championship = 100 * X
if one player has strictly more points than the other, he is declared the champion and
gets 60 * X as price money.
and  40 * X given to loser.
If the total points are tied, then the defending champion Carlsen is declared the winner.
However, if this happens, the winner gets only 55 * X, loser gets 45 * X.

Input:
4
100
CCCCCCCCCCCCCC
400
CDCDCDCDCDCDCD
30
DDCCNNDDDCCNND
1
NNDNNDDDNNDNDN

Output:
6000
24000
1650
40
*/
public class WorldChessChampionship {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            // total prize = 100 * X

            /*
            outcomes
            Carlson : C : 2
            Chef    : N : 2
            Draw.   : D : 1 1
            */

            int X = scanner.nextInt();
            String outcomes = scanner.next();

            long prize = computeCarlsonPrize(outcomes, X);
            System.out.println(prize);
        }
    }

    static long computeCarlsonPrize(String outcomes, int x) {
        int carlsenPoints = 0;
        int chefPoints = 0;

        for (char result: outcomes.toCharArray()) {
            if (result == 'C')
                carlsenPoints += 2;
            else if (result == 'N')
                chefPoints += 2;
            else if (result == 'D'){
                carlsenPoints += 1;
                chefPoints += 1;
            }
        }
        if (carlsenPoints > chefPoints)
            return 60L * x; // Carlsen wins outright
        else if (carlsenPoints < chefPoints)
            return 40L * x; // Chef wins outright
        else
            return 55L * x; // Tie, but Carlsen wins as defending champion
    }

/*
    static long computeCarlsonPrize(String outcomes, int x) {

        char[] outcome = outcomes.toCharArray();

        Map < Character, Integer > frequencies = findFrequencies(outcome);

        char winner =
            (frequencies.get('C') < frequencies.get('N')) ? 'N' : 'C';

        long prize = (winner == 'C') ? (x * 60) : (x * 40);
        return prize;
    }

    static Map < Character, Integer > findFrequencies(char[] outcome) {

        Map < Character, Integer > frequencies = new HashMap < > ();

        for (char c: outcome)
            frequencies.put(c,
                frequencies.getOrDefault(c, 0) + 1);

        return frequencies;
    }*/
}
