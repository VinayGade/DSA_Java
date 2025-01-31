package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
CodeChef: Backtracking - Find Unique Permutations

You are given an array of length N hat may contain duplicates.
Find all possible unique permutations of A.

Note: The permutations must be printed in lexicographically increasing order.
Permutatios a1, a2, ..., an is said to be lexicographically smaller than permutation
b1, b2, ..., bn.

if there exists a position i where ai < bi and aj = bj for all j < i.

input:
3
3
4 5 5
3
5 25 10
2
6 8

output:
3
4 5 5
5 4 5
5 5 4
6
5 10 25
5 25 10
10 5 25
10 25 5
25 5 10
25 10 5
2
6 8
8 6
* */

public class PermutationsUnique {

    static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    static void permute(int l, int n, int[] a, Set<List<Integer>> ans) {
        if (l == n) {
            List<Integer> p = new ArrayList<>();
            for (int value : a) p.add(value);
            ans.add(p);
            return;
        }
        boolean[] visited = new boolean[11]; // Since 1 <= A_i <= 10
        for (int i = l; i < n; i++) {
            if (!visited[a[i]]) {
                visited[a[i]] = true;
                swap(a, l, i);
                permute(l + 1, n, a, ans);
                swap(a, l, i);
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = Arrays.stream(br.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Arrays.sort(a);
            List<List<Integer>> permutations = new ArrayList<>();
            permute(0, n, a, permutations);

            // Sort permutations lexicographically
            permutations.sort((list1, list2) -> {
                for (int i = 0; i < list1.size(); i++) {
                    if (!list1.get(i).equals(list2.get(i))) {
                        return list1.get(i) - list2.get(i);
                    }
                }
                return 0;
            });

            out.println(permutations.size());
            for (List<Integer> perm : permutations) {
                StringBuilder sb = new StringBuilder();
                for (int num : perm) {
                    sb.append(num).append(" ");
                }
                out.println(sb.toString().trim());
            }
        }
        out.close();
    }

    static List < Integer > convertToArrayList(int a[]) {

        List < Integer > ans = new ArrayList < > ();
        for (int e: a) {
            ans.add(e);
        }
        return ans;
    }

    static void swapNums(int[] a, int l, int r) {

        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;

    }

    static void permutations(int l, int n, int[] a, HashSet < List < Integer >> ans) {

        if (l >= n) {
            List < Integer > p = convertToArrayList(a);
            ans.add(new ArrayList(p));
            return;
        }

        for (int i = l; i < n; i++) {
            if (a[i] != a[l]) {
                swapNums(a, l, i);
                permutations(l + 1, n, a, ans);
                swapNums(a, l, i);
            }
            else {
                permutations(l + 1, n, a, ans);
            }
        }
    }

    /*
     Task: Refactor the above code to optimize time complexity by
     i.  Reduced Redundancy
     ii. Enhanced Sorting
     iii.Eliminated Unnecessary Checks:
     */

    static void permute(int l, int n, int[] a, List<List<Integer>> ans) {
        if (l == n) {
            List<Integer> permutation = new ArrayList<>();
            for (int value : a) {
                permutation.add(value);
            }
            ans.add(permutation);
            return;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = l; i < n; i++) {
            if (!seen.contains(a[i])) {
                seen.add(a[i]);
                swap(a, l, i);
                permute(l + 1, n, a, ans);
                swap(a, l, i);
            }
        }
    }

    static void swapNumbers(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main2(String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        PrintWriter out = new PrintWriter(System.out);

        // 		int t = sc.nextInt();
        int t = Integer.valueOf(br.readLine());

        while (t--> 0) {
            int n = Integer.valueOf(br.readLine());
            int[] a = new int[n];
            String s = br.readLine();
            String str[] = s.split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.valueOf(str[i]);
            Arrays.sort(a);
            HashSet < List < Integer >> ans = new HashSet < > ();

            //  System.out.println( Arrays.toString( a ) );
            List < Integer > temp = convertToArrayList(a);
            boolean flag = false;
            for (int e: temp) {
                if (Collections.frequency(temp, e) == n) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                out.println(1);
                out.println(temp.toString().replace(",", "").replace("[", "").replace("]", ""));
            }
            else {
                permutations(0, n, a, ans);
                out.println(ans.size());
                List < List < Integer >> ians = new ArrayList < > (ans);
                Collections.sort(ians, new Comparator < List < Integer >> () {
                    public int compare(List < Integer > list1, List < Integer > list2) {
                        int result = 0;
                        for (int i = 0; i <= list1.size() - 1 && result == 0; i++)
                        {
                            result = list1.get(i).compareTo(list2.get(i));
                        }
                        return result;
                    }
                });

                for (List < Integer > b: ians) {
                    out.println(b.toString().replace(",", "").replace("[", "").replace("]", ""));
                }
            }
            //System.out.println( ans.toString() );
        }
        out.close();
    }
}
