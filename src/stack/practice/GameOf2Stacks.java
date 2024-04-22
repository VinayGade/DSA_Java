package stack.practice;

import java.util.Arrays;
import java.util.List;

/* * * * Game of 2 Stacks * * * *

Alexa has two stacks of non-negative integers: a[n], b[m] ...tos=0
Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack a / b
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than
some integer maxSum given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
find the maximum possible score Nick can achieve.


input:
1
5 4 10
4 2 4 6 1
2 1 8 5

output: 4
*
**/

public class GameOf2Stacks {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int result=0;
        int counta=0;
        int countb=0;
        int totalSum=0;

        //get elements from stack a
        for(Integer x: a){
            if((totalSum + x) > maxSum)
                break;
            totalSum += x;
            counta++;
        }
        result = counta;

        //elements of stack b
        for(Integer y: b){
            totalSum += y;
            countb++;

            while(totalSum > maxSum && counta > 0)
                totalSum -= a.get(--counta);

            result = (totalSum <= maxSum) ? 
                        Math.max(counta + countb, result): result;
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(4, 2, 4, 6, 1);
        List<Integer> b = Arrays.asList(2, 1, 8, 5);

        int maxSum = 10;

        int count = twoStacks(maxSum, a, b);

        System.out.println("count ="+count);

    }
}
