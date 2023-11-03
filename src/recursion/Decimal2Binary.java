package recursion;
import java.io.*;

public class Decimal2Binary {

    // HackerRank : Tutorials > 30 Days of code : Day 10: Binary Numbers

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println("Binary( "+n+" ) = ");
        decimalToBinary(n);

        System.out.println(result(n));

        bufferedReader.close();
    }

    public static int result(int num) {
        int currConsecutive = 0;
        int maxConsecutive = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                currConsecutive++;
                maxConsecutive = Math.max(currConsecutive, maxConsecutive);
            } else {
                currConsecutive = 0;
            }
            num /= 2;
        }
        return maxConsecutive;
    }

    private static void decimalToBinary(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;
        }

        remainder = number % 2;
        decimalToBinary(number >> 1);
        System.out.print(remainder);
    }

    public static String decimalToBinaryString(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal = decimal / 2;
        }
        return binary;
    }
}
