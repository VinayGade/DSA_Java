package hashing;

//LeetCode 496. Next Greater Element I

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n2 = nums2.length;
        int n1 = nums1.length;

        for(int i=n2-1; i>=0; i--){

            int num = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= num)
                stack.pop();

            if(stack.isEmpty())
                map.put(num, -1);

            else
                map.put(num, stack.peek());

            stack.push(num);
        }

        for(int i=0; i<n1; i++)
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] nextGreater = nextGreaterElement(nums1, nums2);
        for (int x : nextGreater)
            System.out.println(x);
    }
}
