package array.math;

import java.util.Arrays;
import java.util.List;

//Algorithms > Search > Sherlock and Array
public class SherlockArray {

    /*
    Watson gives Sherlock an array of integers. His challenge is to find
    an element of the array such that the sum of all elements to the left
    is equal to the sum of all elements to the right.

    eg.
    arr[] = [5,6,8,11]
    leftsum(8) == rightsum(8)
        (5+6 ) == 11
    return YES
    * */

    public static String balancedSums(List<Integer> arr) {
        int leftSum=0;
        int rightSum = 0;
        int n = arr.size();
        int sum = arr.stream().reduce((x, y) -> x+y).get();
        //System.out.println(sum);

        for(int i=0; i<n; i++){
            int key = arr.get(i);
            rightSum = sum - key - leftSum;
            if(leftSum == rightSum)
                return "YES";
            leftSum = leftSum + key;
        }
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5,6,8,11);
        System.out.println(balancedSums(arr));
    }
}
