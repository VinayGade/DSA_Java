package hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//CodeChef: Heaps: Chef and Apple Trees

public class AppleTrees {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            Set<Integer> distinctApples = new HashSet<>();

            for (int i = 0; i < N; i++) {
                int apples = sc.nextInt();
                distinctApples.add(apples);
            }

            System.out.println(distinctApples.size());
        }

        sc.close();
    }
}
