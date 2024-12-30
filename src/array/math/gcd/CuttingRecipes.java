package array.math.gcd;

import java.util.Scanner;

/*
The chef has a recipe he wishes to use for his guests,
but the recipe will make far more food than he can serve to the guests.
 The chef therefore would like to make a reduced version of the recipe
 which has the same ratios of ingredients, but makes less food.
 The chef, however, does not like fractions.
 The original recipe contains only whole numbers of ingredients, and
 the chef wants the reduced recipe to only contain whole numbers of ingredients as well.
 Help the chef determine how much of each ingredient to use in order to make as little food as possible.

input:
 3
2 4 4
3 2 3 4
4 3 15 9 6

Output:
1 1
2 3 4
1 5 3 2
* */

public class CuttingRecipes {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Read number of test cases
        for (int it = 0; it < t; it++) {
            solve(scanner); // Call the solve method for each test case
        }
        scanner.close(); // Close the scanner
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt(); // Read the size of the array
        int[] numbers = new int[n]; // Create an array to store numbers

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt(); // Read each number
        }

        int g = gcd(numbers[0], numbers[1]); // Calculate GCD of the first two elements
        for (int i = 2; i < n; i++) {
            g = gcd(g, numbers[i]); // Update GCD with the next elements
        }
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] / g + " "); // Output the results
        }
        System.out.println(); // New line after each test case
    }

    // Function to calculate GCD of two numbers
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
