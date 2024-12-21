package backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 77. Combinations
/*
Given two integers n and k, return all possible combinations of k numbers
chosen from the range [1, n].
You may return the answer in any order.

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be
the same combination.

* */

public class Combinations {

    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(1, n, new ArrayList(), subsets, k);
        return subsets;
    }

    static void generateSubsets(int start, int n, List<Integer> current, List<List<Integer>> subsets, int k){
        if(current.size() == k){
            subsets.add(new ArrayList(current));
            return ;
        }
        for(int i=start; i<=n; i++){
            current.add(i);
            generateSubsets(i+1, n, current, subsets, k);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] args) {
        int n = 4, k = 2;

        List<List<Integer>> combinations = combine(n, k);
        for(List<Integer> pair: combinations){
            System.out.println(pair);
        }
    }
}
