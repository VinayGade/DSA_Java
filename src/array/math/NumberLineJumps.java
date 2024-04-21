package array.math;

//HackerRank : NumberLineJumps

/*
You are choreographing a circus show with various animals. For 1 act, you are given two kangaroos
on a number line ready to jump in the positive direction (i.e, toward positive infinity).

The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.

You have to figure out a way to get both kangaroos at the same location
at the same time as part of the show.
If it is possible, return YES, otherwise return NO.

eg.
/*
        Kangaroo -> k1, k2

        k1 [x1=2, v1=1]
        k2 [x2=1, v2=2]    ... x2 > x1  always

        After one jump, they are both at x = 3
        x1 + v1 = 2+1
        x2 + v2 = 1+2

        answer is YES
*/


public class NumberLineJumps {

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        if(v2 > v1)
            return "NO";

        if(v1!=v2 && (x2-x1)%(v1-v2)==0)
            return "YES";

        else
            return "NO";
    }

    public static void main(String[] args) {

        /*
        Kangaroo -> k1, k2

        k1 [x1=0, v1=3]
        k2 [x2=4, v2=2]    ... x2 > x1  always

        * */

        int x1=0, v1=3;
        int x2=4, v2=2;

        System.out.println("Can both kangaroos at the same location at the same time?"
        +kangaroo(x1, v1, x2, v2));
    }
}
