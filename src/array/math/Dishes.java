package array.math;

//CodeChef: 2 Dishes

/*
		Observation:
		1.  Every guest should get >=1 Dishes

		2.   input:
		     N: guest count
             A: Fruit count
             B: Veg count
             C: Fish count

             Recipe:
             i.  Dish1 = 1A + 1B
             ii. Dish2 = 1C + 1B

             find:
             D: Dishes count

             result:
             N <= D

        Conclusion:

             Following constraints must be satisfied To check for valid Dish Count

             i.   N <= B
             ii.  N <= (A+C)
             iii. N <= Min(B, (A+C))

             return N <= B && N <= (A+C)    ... from (i), (ii), (iii)
        */

/*
input
    4
2 1 2 1
3 2 2 2
4 2 6 3
3 1 3 1

Output:
YES
NO
YES
NO

1
56 29 55 28
Output: NO
    */

import java.util.Scanner;

public class Dishes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(--T >= 0){

            int N = scan.nextInt();    // guests count
            int A = scan.nextInt();    // Fruit count
            int B = scan.nextInt();    // Veg count
            int C = scan.nextInt();    // Fish count

            //int D = countDishes(N, A, B, C);
            String result = validDishCount(N, A, B, C) ? "YES": "NO";
            System.out.println(result);
        }
    }

    static boolean validDishCount(int N, int A, int B, int C){
        int sum = A + C;
        /*
        if(N>B || N>sum)
            return false;
        else if(N<= Math.min(B, sum))
            return true;
        else
            return false;
         */

        //Optimized code
        return N <= B && N <= sum;
    }

	/*
	static int countDishes(int N, int A, int B, int C){
	    int D = 0;
	    while(B > 0 && (A>0 || C>0)){
	        //Dish 1
	        if(A > 0){
	            A--;
	            B--;
	            D++;
	        }
	        //Dish 2
	        if(C > 0){
	            C--;
	            B--;
	            D++;
	        }
	    }
	    return D;
	}
	*/
}
