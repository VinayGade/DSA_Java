package hashing;
import java.util.*;

/*
CodeChef: Akash and Dinner

Akash got his money from CodeChef today, so he decided to have dinner outside.
He went to a restaurant having N items  on the menu. The ith item  on the menu
belongs to the category Ai and requires Bi time to be cooked.

Akash wants to have a complete meal. Thus, his meal should have at least
k  distinct categories of food.

The total time required to get all the food Akash orders, is the sum of the cooking time of all the items in the order.

Help Akash find the minimum time required to have a complete meal or tell if it is not possible to do so.

input:
4
3 1
1 2 3
2 1 3
8 3
1 3 2 2 4 1 3 5
3 3 0 1 2 4 1 4
1 1
5
1
5 3
1 1 2 2 1
1 1 0 3 5

output:
1
3
1
-1
* */
public class AkashDinner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            long time = computeTime(n, k, a, b);
            System.out.println(time);
        }
    }

    // Approach 1: using HashMap and PriorityQ
    static long computeTime(int n, int k, int[] a, int[] b){

        //Stack<Integer> categories = new Stack<>();
        Map<Integer, Integer> categoryMinTime = new HashMap<>();

        int minTime = 0;

        //int leastTime = Integer.MAX_VALUE;
        //int dishesCount = 0;

        for(int i=0; i<n; i++){
            if(categoryMinTime.containsKey(a[i])){
                //leastTime = Math.min(leastTime, b[i]);
                minTime = Math.min(b[i], categoryMinTime.get(a[i]));
                categoryMinTime.put(a[i], minTime);
            }else{
                categoryMinTime.put(a[i], b[i]);
            }
        }

        //Set<Map.Entry<Integer, Integer>> set = categoryMinTime.entrySet();
        //int categoriesCount = set.size();
        if(categoryMinTime.size() < k)
            return -1;

        /*
        totalTime += minTime;
        dishesCount++;
        k--;
        */

        /*
        for(Map.Entry<Integer, Integer> entry: categoryMinTime.entrySet()){
            int time = entry.getValue();

            if(time != minTime){
                if(dishesCount > k){
                    break;
                }
                timeQ.add(time);
            }

        }*/

        PriorityQueue < Integer > timeQ = new PriorityQueue < > (categoryMinTime.values());
        long totalTime = 0;

        for(int i=0; i<k; i++)
            totalTime += timeQ.poll();
        return totalTime;
    }

    // Approach 2: using list
    static long computeTime2(int n, int k, int[] a, int[] b) {

        Map < Integer, Integer > categoryMinTime = new HashMap < > ();

        int minTime = 0;

        for (int i = 0; i < n; i++) {
            if (categoryMinTime.containsKey(a[i])) {
                minTime = Math.min(b[i], categoryMinTime.get(a[i]));
                categoryMinTime.put(a[i], minTime);
            } else {
                categoryMinTime.put(a[i], b[i]);
            }
        }
        long ans = 0;
        List < Map.Entry < Integer, Integer >> list = new ArrayList < > (categoryMinTime.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry < Integer, Integer > entry: list) {
            ans = ans + entry.getValue();
            k--;
            if (k <= 0)
                break;
        }
        if (k > 0)
            ans = -1;
        return ans;
    }
}