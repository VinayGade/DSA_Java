package array.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumStreak {

    /*
3
6
1 7 3 0 2 13
0 2 3 4 5 0
3
1 3 4
3 1 2
5
1 2 3 0 1
1 2 0 2 3

output:
Addy
Draw
Om


    1
7
0 0 0 0 0 0 0
0 0 0 0 0 0 1

output:
ADdy
    * */

    public static int calculateMaxStreak(int[] arr, int n) {
        int maxStreak = 0;
        int currentStreak = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                currentStreak++;
            } else {
                maxStreak = Math.max(maxStreak, currentStreak);
                currentStreak = 0;
            }
        }
        maxStreak = Math.max(maxStreak, currentStreak);

        return maxStreak;
    }

    static String maximumStreak2(int[] om, int[] addy, int n) {
        int omStreak = 0;
        int addyStreak = 0;
        String winner = "";
        for (int i = 0; i < (n-1); i++) {
            omStreak = (om[i] == 0) ? 0 : omStreak + 1;
            addyStreak = (addy[i] == 0) ? 0 : addyStreak + 1;
        }
        omStreak = (om[n-1]!=0) ? (omStreak + 1) : omStreak;
        addyStreak = (addy[n-1]!=0) ? (addyStreak + 1) : addyStreak;

        if (omStreak > addyStreak)
            winner = "Om";
        else if (omStreak < addyStreak)
            winner = "Addy";
        else
            winner = "Draw";
        return winner;
    }

    static String maximumStreak3(int[] om, int[] addy, int n) {
        int omStreak = 0;
        int addyStreak = 0;
        List<Integer> omStreaks = new ArrayList<>();
        List<Integer> addyStreaks = new ArrayList<>();
        String winner = "";
        for (int i = 0; i < n; i++) {
            if(om[i] == 0){
                if(omStreak > 0) {
                    omStreaks.add(omStreak);
                    omStreak = 0;
                }
            }
            if(om[i] != 0)
                omStreak++;
            if(i==(n-1) && omStreak > 0)
                omStreaks.add(omStreak);
            if(addy[i] == 0){
                if(addyStreak > 0) {
                    addyStreaks.add(addyStreak);
                    addyStreak = 0;
                }
            }if(addy[i] != 0)
                addyStreak++;
            if(i==(n-1) && addyStreak > 0)
                omStreaks.add(addyStreak);
            /*
            omStreak = (om[i] == 0) ? 0 : omStreak + 1;
            addyStreak = (addy[i] == 0) ? 0 : addyStreak + 1;
            */
        }

        if(!omStreaks.isEmpty())
            omStreak = findLargestStreak(omStreaks);

        if(!addyStreaks.isEmpty())
            addyStreak = findLargestStreak(addyStreaks);

        if (omStreak > addyStreak)
            winner = "Om";
        else if (omStreak < addyStreak)
            winner = "Addy";
        else
            winner = "Draw";
        return winner;
    }

    static int findLargestStreak(List<Integer> streaks){
        int largest = -1;
        for(int streak: streaks){
            largest = Math.max(largest, streak);
        }
        return largest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            int omMaxStreak = calculateMaxStreak(a, n);
            int addyMaxStreak = calculateMaxStreak(b, n);

            String winner="";
            if (omMaxStreak > addyMaxStreak)
                winner = "Om";
            else if (omMaxStreak < addyMaxStreak)
                winner = "Addy";
            else
                winner = "Draw";

            System.out.println(winner);
        }
        scanner.close();
    }
}
