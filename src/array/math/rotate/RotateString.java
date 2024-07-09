package array.math.rotate;

/*
LeetCode 796. Rotate String

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.

* */

public class RotateString {

    static boolean rotateString(String s, String goal) {

        int n = s.length();
        int m = goal.length();

        if(n != m)
            return false;
        if(n == 0)
            return true;

        char a = s.charAt(0);
        char b = goal.charAt(0);
        if(a == b)
            return s.equals(goal);
        else {
            for(int i=0; i<n; i++){
                if(rotateString(s, goal, i, n, m))
                    return true;
            }
        }
        return false;
    }

    static boolean rotateString(String s, String goal, int r, int n, int m) {
        // r: rotation factor

        for(int i=0; i<n; i++){
            if(s.charAt(i) != goal.charAt((i+r)%m))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        boolean flag = rotateString(s, goal);
        System.out.println(flag);
    }

}
