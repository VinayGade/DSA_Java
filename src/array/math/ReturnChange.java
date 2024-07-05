package array.math;

import java.util.Scanner;

/*
In Chefland, denominations less than rupees 10 have stopped and now rupees
10 is the smallest denomination.

Suppose Chef goes to buy some item with cost not a multiple of 10
then, he will be charged the cost that is the nearest multiple of 10

If the cost is equally distant from two nearest multiples of 10
then the cost is rounded up.

35 38 40 44  -> 40   Hence Output: 60 (100 - 40 = 60)

input:
4
35
54
80
12

output:
60
50
20
90

* */
public class ReturnChange {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int x = scanner.nextInt();
            int amount = amountToReturn(x);
            System.out.println(amount);
        }
    }

    public static int amountToReturn(int cost) {
        if (cost % 10 >= 5)
            cost += 10 - cost % 10;
        else
            cost -= cost % 10;
        return 100 - cost;
        /*
        int mod = cost % 10;
        if (mod == 0)
            amount = 100 - cost;
        else {
            for (int i = 1; i <= 5; i--) {
                if (mod >= 5) {
                    if ((i + mod) == 10) {
                        amount = 100 - (cost + mod);
                        break;
                    }
                } else {
                    if ((mod - i) == 0) {
                        amount = 100 - (cost - mod);
                        break;
                    }
                }
            }
        }
        return amount;
        */
    }
}