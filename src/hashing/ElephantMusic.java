package hashing;

//CodeChef: Greedy: Little Elephant and Music

/*
The Little Elephant from the Zoo of Lviv likes listening to music.

There are N songs, numbered from 1 to N, in his MP3-player.
The song i is described by a pair of integers Bi and Li - the band (integer)
that performed that song and the length of that song in seconds.
The Little Elephant is going to listen all the songs exactly once in some order.

The sweetness of the song is equal to the product of the length of that song and
the number of different bands listened before (including the current playing song).

Help the Little Elephant to find the order that maximizes the total sweetness of all N songs.
Print that sweetness.

Input:
2
3
1 2
2 2
3 2
3
2 3
1 2
2 4

Output:
12
16

Explanation:
In the first sample: if he listens the songs in given order, then
B1=1, L1=2: the sweetness = 2 * 1 = 2
B2=2, L2=2: the sweetness = 2 * 2 = 4
B3=3, L3=2: the sweetness = 2 * 3 = 6
So the total sweetness is 12. In this case, you can check the total sweetness does not depend on the order of the songs.

In the second sample: if he listens the songs in given order, then
B1=2, L1=3: the sweetness = 3 * 1 = 3
B2=1, L2=2: the sweetness = 2 * 2 = 4
B3=2, L3=4: the sweetness = 4 * 2 = 8
So the total sweetness is 15. However, he listens the song 2 firstly, then
B2=1, L2=2: the sweetness = 2 * 1 = 2
B1=2, L1=3: the sweetness = 3 * 2 = 6
B3=2, L3=4: the sweetness = 4 * 2 = 8
So the total sweetness is 16, and it is the maximum total sweetness.

* */

import java.util.*;

public class ElephantMusic {

    // Memory efficient sorting 2-d array (matrix)
    static long totalSweetness(int[][] arr, int n){

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            else
                return Long.compare(a[1], b[1]);
        });
        int count = 1;
        int[] ar = new int[n];
        ar[0] = arr[0][1];
        arr[0][2] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] != arr[i - 1][0]) {
                ar[i] = arr[i][1];
                count++;
                arr[i][2] = -1;
            }
        }
        Arrays.sort(ar);
        long total = 0;
        int a = count;
        for (int i = n - 1; i >= 0; i--) {
            if (ar[i] != 0) {
                total += (long) ar[i] * a;
                a--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][2] != -1) {
                total += (long) arr[i][1] * count;
            }
        }
        return total;
    }

    // Efficient approach: HashSet and HashMap
    public static void main2(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, List<Integer>> bandSongs = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int band = sc.nextInt();
                int length = sc.nextInt();
                bandSongs.computeIfAbsent(band, k -> new ArrayList<>()).add(length);
            }

            List<Integer> shortestSongs = new ArrayList<>();
            long totalRemainingLengths = 0;

            for (Map.Entry<Integer, List<Integer>> entry : bandSongs.entrySet()) {
                List<Integer> lengths = entry.getValue();
                Collections.sort(lengths);
                shortestSongs.add(lengths.get(0));
                for (int i = 1; i < lengths.size(); i++) {
                    totalRemainingLengths += (long) lengths.get(i);
                }
            }

            Collections.sort(shortestSongs);
            int m = shortestSongs.size();
            long totalSweetness = m * totalRemainingLengths;

            for (int i = 0; i < m; i++) {
                totalSweetness += (long) (i + 1) * shortestSongs.get(i);
            }

            System.out.println(totalSweetness);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            long total = totalSweetness(arr, n);
            System.out.println(total);
        }
    }
}
