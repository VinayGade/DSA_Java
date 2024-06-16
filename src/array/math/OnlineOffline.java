package array.math;

import java.util.Scanner;

public class OnlineOffline {

    static String foodChoice(int n, int m) {

        String choice = "ONLINE";

        if (n != m) {

            // online cost after applying discount
            //n = n - (int)(n / 10);

            //n = 9 * n / 10;

            double online = n - n * 0.1;
            double dining = (double) m;

            String ch = (online < dining) ? "ONLINE" : (online > dining) ? "DINING" : "EITHER";

            if (online < dining)
                choice = "ONLINE";
            else if (online > dining)
                choice = "DINING";
            else
                choice = "EITHER";
        }
        return choice;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt(); // online
            int m = scanner.nextInt(); // restaurant

            String choice = foodChoice(n, m);
            System.out.println(choice);
        }

    }
}
