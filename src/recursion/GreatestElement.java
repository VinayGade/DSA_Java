package recursion;

import java.util.NoSuchElementException;

public class GreatestElement {

    public static int maxElement (int[] vals) {
        if (vals.length == 0)
            throw new NoSuchElementException("No Max Element in Empty Array.");

        return maxElement(vals, 0, vals.length);
    }

    static int maxElement(int[] vals, int left, int right){

        if(right-left==1)
            return vals[left];

        // compute subproblems
        int mid = (left + right)/2;
        int max1 = maxElement(vals, left, mid);
        int max2 = maxElement(vals, mid, right);

        // Resolution: compute result from results of subproblems
        if (max1 > max2)
            return max1;
        return max2;
    }

    public static void main(String[] args) {
        int[] numbers = {500, 100, 25, 50, 20, 15, 200, 30, 900, 40, 70, 80, 300, 90};
        int greatest = maxElement(numbers);
        System.out.println("Largest number from numbers = "+greatest);
    }
}
