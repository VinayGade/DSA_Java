package array.math.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint {

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public int equilibriumPoint(long arr[], int n) {

        if(n==1)
            return 1;

        int index = -1;

        /*
        // 2-pointer approach
        int i = 0;
        int j = n-1;

        int leftSum = 0;
        int rightSum = 0;

        while(i < j){
            leftSum += arr[i];
            rightSum+= arr[j];
            if(leftSum == rightSum){
                index = i+2;
                break;
            }
            i++;
            j--;
        }

        return index;
        */

        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        long leftsum = 0;
        long rightsum = sum;

        for(int i=0;i<n;i++){
            rightsum-=arr[i];
            if(leftsum == rightsum)
                return i+1;
            leftsum+=arr[i];
        }
        return -1;
    }

    /*
    Input:
n = 5
A[] = {1,3,5,2,2}
Output:
3
Explanation:
equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2).

Input:
n = 1
A[] = {1}
Output:
1
Explanation:
Since there's only element hence its only the equilibrium point.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            EquilibriumPoint ob = new EquilibriumPoint();

            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
    /*
    input:

    2
    5
    1 3 5 2 2
    1
    4
    * */
}
