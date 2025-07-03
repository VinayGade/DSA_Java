package heap.problems;

//CodeChef: Heaps: Cleaning Up

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*

Input
3
6 3
2 4 1
3 2
3 2
8 2
3 8

Output
3 6
5
1
-1
1 4 6
2 5 7
* */

public class CleaningUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Total jobs
            int m = scanner.nextInt(); // Completed jobs

            // Input completed jobs
            int[] completedJobs = new int[m];
            for (int i = 0; i < m; i++) {
                completedJobs[i] = scanner.nextInt();
            }

            // Create a list to mark completed jobs
            boolean[] remainingJobs = new boolean[n + 1];
            Arrays.fill(remainingJobs, true); // All jobs initially marked as unfinished

            // Mark completed jobs
            for (int job : completedJobs) {
                remainingJobs[job] = false;
            }

            // Collect the remaining jobs
            List<Integer> unfinishedJobs = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (remainingJobs[i]) {
                    unfinishedJobs.add(i);
                }
            }

            // Assign jobs to Chef and Assistant
            List<Integer> chefJobs = new ArrayList<>();
            List<Integer> assistantJobs = new ArrayList<>();

            for (int i = 0; i < unfinishedJobs.size(); i++) {
                if (i % 2 == 0) {
                    chefJobs.add(unfinishedJobs.get(i)); // Chef takes the job
                } else {
                    assistantJobs.add(unfinishedJobs.get(i)); // Assistant takes the job
                }
            }

            // Print results for Chef
            if (!chefJobs.isEmpty()) {
                for (int job : chefJobs) {
                    System.out.print(job + " ");
                }
                System.out.println(); // New line after printing Chef's jobs
            } else {
                System.out.println("-1"); // If Chef has no jobs
            }

            // Print results for Assistant
            if (!assistantJobs.isEmpty()) {
                for (int job : assistantJobs) {
                    System.out.print(job + " ");
                }
                System.out.println(); // New line after printing Assistant's jobs
            } else {
                System.out.println("-1"); // If Assistant has no jobs
            }
        }

        scanner.close();
    }

    // optimised approach

    public static void main2(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[] completed = new int[M];
            for (int i = 0; i < M; i++) {
                completed[i] = scanner.nextInt();
            }

            boolean[] remainingJobs = new boolean[N + 1];
            Arrays.fill(remainingJobs, true);

            for (int job : completed) {
                remainingJobs[job] = false;
            }

            List<Integer> chefJobs = new ArrayList<>();
            List<Integer> assistantJobs = new ArrayList<>();

            int turn = 0; // 0 for Chef, 1 for Assistant

            for (int i = 1; i <= N; i++) {
                if (remainingJobs[i]) {
                    if (turn == 0) {
                        chefJobs.add(i);
                    } else {
                        assistantJobs.add(i);
                    }
                    turn = 1 - turn; // Switch turns
                }
            }

            // Print results
            printJobs(chefJobs);
            printJobs(assistantJobs);
        }
        scanner.close();
    }

    static void printJobs(List<Integer> jobs) {
        if (!jobs.isEmpty()) {
            for (int i = 0; i < jobs.size(); i++) {
                System.out.print(jobs.get(i));
                if (i < jobs.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
}
