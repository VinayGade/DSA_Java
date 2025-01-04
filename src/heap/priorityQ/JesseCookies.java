package heap.priorityQ;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
HackerRank: Jesse and Cookies

Jesse loves cookies and wants the sweetness of some cookies to be greater than value k.
To do this, two cookies with the least sweetness are repeatedly mixed.
This creates a special combined cookie with:

sweetness = Least sweet cookie  + 2 * 2nd least sweet cookie

This occurs until all the cookies have a sweetness >= k

Given the sweetness of a number of cookies,
determine the minimum number of operations required. If it is not possible, return -1

eg.
k=9
A=[2 7 3 6 4 6]

initially count = 0
The smallest values are 2,3.
Remove them then return 2+2*3=8. to the array. Now A=[8 7 6 4 6].     count = 1
Remove 4, 6 and return 4+6*2=16 to the array. Now A=[16 8 7 6].       count = 2
Remove 6, 7 return 6+7*2=20 and A=[20 16 8].                          count = 3
Finally, remove 8, 16. 16*2+8 = 40 Hence Now A=[40 20 16].            count = 4
All values are > k (16>9) so the process stops after  iterations. Return 4 (count).

eg 2.
STDIN               Function
-----               --------
6 7                 A[] size n = 6, k = 7
1 2 3 9 10 12       A = [1, 2, 3, 9, 10, 12]

output: 2
* */
public class JesseCookies {

    static int cookies(int k, List<Integer> cookies){
        PriorityQueue<Integer> queue = new PriorityQueue<>(cookies);
        int count = 0;
        while(queue.peek() < k && queue.size() > 1){
            int smallest=queue.poll();
            int secondSmallest=queue.poll();
            queue.add(smallest + 2 * secondSmallest);
            count++;
        }
        if(queue.peek() < k)
            return -1;
        return count;
    }

    public static int cookiesCount(int k, List<Integer> cookies) {

        int result = 0;
        PriorityQueue<Integer> cookiesSorted = new PriorityQueue<>(cookies);

        while (cookiesSorted.size() >= 2 && cookiesSorted.peek() < k) {
            cookiesSorted.add(cookiesSorted.poll() + 2 * cookiesSorted.poll());
            result++;
        }

        return cookiesSorted.peek() < k ? -1 : result;

    }

    public static void main(String[] args) {
        List<Integer> cookies= Arrays.asList(1, 2, 3, 9, 10, 12);
        int k = 7;
        int count = cookies(k, cookies);
        System.out.println("count = "+count);
    }
}
