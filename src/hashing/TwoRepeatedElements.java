package hashing;

/*
Two Repeated Elements:

You are given an integer n and an integer array arr of size n+2.
All elements of the array are in the range from 1 to n.
Also, all elements occur once except two numbers which occur twice.
 Find the two repeating numbers.

 Note: Return the numbers in their order of appearing twice.
 So, if x and y are repeating numbers, and x's second appearance comes
 before the second appearance of y, then the order should be (x, y).

Input: n = 4, arr[] = [1, 2, 1, 3, 4, 3]
Output: 1 3

Input: n = 2, arr[] = [1, 2, 2, 1]
Output: 2 1

* */
public class TwoRepeatedElements {

    public static void main(String[] args) {

        int n = 4;
        int[] arr = {1, 2, 1, 3, 4, 3};

        int[] repeated = twoRepeated(n, arr);

        System.out.println(repeated[0] +" "+ repeated[1]);
    }

    // Backend complete function template for JAVA


        // Function to find two repeated elements.
        static int[] twoRepeated(int n, int arr[]) {
            boolean first = false;
            int[] res = new int[2];

            // iterating over the array elements.
            for (int p = 0; p < n + 2; p++) {
                // making the visited elements negative.
                if (arr[Math.abs(arr[p])] > 0) {
                    arr[Math.abs(arr[p])] = -arr[Math.abs(arr[p])];
                }
                // if the number is negative, it was visited previously
                // so this would be the repeated element.
                else {
                    // storing first and second repeated element accordingly.
                    if (!first) {
                        res[0] = Math.abs(arr[p]);
                        first = true;
                    } else
                        res[1] = Math.abs(arr[p]);
                }
            }
            // returning the result.
            return res;
        }
}
