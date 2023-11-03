package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SubarraySum {

    //Function to find a continuous sub-array which adds up to a given number.
    /*
    input:
    1
    5 12
    1 2 3 7 5
    output: 2 4
    * */

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> range = new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        int sum = arr[0];

        if(s == 0){
            range.add(-1);
            return range;
        }
        while(end < n){
            if(sum == s){
                range.add(start+1);
                range.add(end+1);
                return range;
            }else if(sum < s){ //end index
                end++;
                if(end < n)
                    sum += arr[end];
            }else{  //start index
                sum -= arr[start];
                start++;
            }
        }
        range.add(-1); // sub-array not found;
        return range;
    }

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int a[] = new int [n];
        ArrayList<Integer> range = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            a[arr[i]]++;
        }
        for(int i=0; i<a.length; i++){
            if (a[i] > 1){
                range.add(i);
            }
        }
        return range;
    }

    //method 2: sliding window (Efficient Approach)
    /*
    * Algorithm :
        1. Create three variables, l=0, sum = 0
        2. Traverse the array from start to end.
        3. Update the variable sum by adding current element, sum = sum + array[i]
        4. If the sum is greater than the given sum,
           update the variable sum as sum = sum – array[l], and update l as, l++.
        5. If the sum is equal to given sum, print the subarray and break the loop.
    *
    * */
     /* Returns true if the there is a
       subarray of arr[] with sum equal
       to 'sum' otherwise returns false.
       Also, prints the result */
    int subArraySum(int arr[], int n, int sum)
    {
        int currentSum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++)
        {
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (currentSum > sum && start < i - 1)
            {
                currentSum = currentSum - arr[start];
                start++;
            }
            // If curr_sum becomes equal to sum,
            // then return true
            if (currentSum == sum)
            {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " +
                                start + " and " + p);
                return 1;
            }
            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }
        System.out.println("No subarray found");
        return 0;
    }

    // Leetcode 209. Minimum Size Subarray Sum
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            String s[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);

            ArrayList<Integer> res = subarraySum(a, n, k);
            for(int j = 0; j<res.size(); j++)
                ot.print(res.get(j) + " ");
            ot.println();
        }
        ot.close();
    }
}