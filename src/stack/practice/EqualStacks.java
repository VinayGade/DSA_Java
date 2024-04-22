package stack.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Equal Stacks

/*
You have three stacks of cylinders where each cylinder has the same diameter,
but they may vary in height. You can change the height of a stack by removing
and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are
exactly the same height. This means you must remove zero or more cylinders from
the top of zero or more of the three stacks until they are all the same height,
then return the height.

input:

STDIN       Function
-----       --------
5 3 4       h1[] size n1 = 5, h2[] size n2 = 3, h3[] size n3 = 4
3 2 1 1 1   h1 = [3, 2, 1, 1, 1]
4 3 2       h2 = [4, 3, 2]
1 1 4 1     h3 = [1, 1, 4, 1]

output : 5
----------
h1 [2 1 1 1]
h2 [3 2]
h3 [4 1]


* */
public class EqualStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        int maxHeight = 0;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        fillStacks(stack1, h1, stack2, h2, stack3, h3);

        //Run a loop until every stack has at least 1 element

        while(!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()){

            int stack1Height = stack1.peek();
            int stack2Height = stack2.peek();
            int stack3Height = stack3.peek();

            //if all stacks are at same height return height
            if(stack1Height == stack2Height && stack2Height == stack3Height){
                maxHeight = stack1Height;
                break;
            }

            //else find the stack with max height & remove block
            if(stack1Height >= stack2Height && stack1Height >= stack3Height)
                stack1.pop();
            else if(stack2Height >= stack1Height && stack2Height >= stack3Height)
                stack2.pop();
            else
                stack3.pop();
        }
        return maxHeight;
    }

    static void fillStacks(Stack<Integer>stack1, List<Integer> h1, 
        Stack<Integer> stack2, List<Integer> h2,
        Stack<Integer> stack3, List<Integer> h3){

        int st1TotalHeight = 0, st2TotalHeight = 0, st3TotalHeight = 0;

        int i=h1.size()-1, j=h2.size()-1, k=h3.size()-1;

        while(i>=0 || j>=0 || k>=0){
            if(i>=0){
                st1TotalHeight += h1.get(i);
                stack1.push(st1TotalHeight);
                i--;
            }
            if(j>=0){
                st2TotalHeight += h2.get(j);
                stack2.push(st2TotalHeight);
                j--;
            }
            if(k>=0){
                st3TotalHeight += h3.get(k);
                stack3.push(st3TotalHeight);
                k--;
            }
            if(i<0 && j<0 && k<0)
                break;
        }
    }

    public static void main(String[] args) {
        List<Integer> h1= Arrays.asList(3, 2, 1, 1, 1);
        List<Integer> h2= Arrays.asList(4, 3, 2);
        List<Integer> h3= Arrays.asList(1, 1, 4, 1);

        int max = equalStacks(h1, h2, h3);
        System.out.println("max height = "+max);
    }
}
