package bitwise;

/*

LeetCode 476. Number Complement. :  The complement of an integer is the integer you get when
you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.
Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

* */
public class Compliment {

    static int findComplement(int num) {

        // Edge case: if num is 0, its complement is 1
        if (num == 0) return 1;

        // Create a bitmask with all bits set to 1, having the same number of bits as num
        int bitmask = 0;
        int temp = num;

        while (temp > 0) {
            bitmask = (bitmask << 1) | 1;
            temp >>= 1;
        }

        // XOR num with the bitmask to flip all bits
        return num ^ bitmask;
    }

    public static void main(String[] args) {
        int num = 21;
        int compliment = findComplement(num);
        System.out.println(compliment);
    }
}
