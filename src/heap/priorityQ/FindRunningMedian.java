package heap.priorityQ;

import java.util.*;

// HackerRank > Data Structures > Heap > Find the Running Median
public class FindRunningMedian {

    /*
    The median of a set of integers is the midpoint value of the data set for which an equal number
    of integers are less than and greater than the value.
    To find the median, you must first sort your set of integers in non-decreasing order, then:
    1. If your set contains an odd number of elements, the median is the middle element of the sorted sample.
       In the sorted set [1,2,3] median = 2
    2. If your set contains an even number of elements, the median is the average of the two middle elements of
       the sorted sample.
       In the sorted set [1, 2, 3, 4] => median = (2+3)/2 = 2.5

       Given an input stream of n integers, perform the following task for each ith integer.
       i. Add the i'th integer to a running list of integers.
       ii.Find the median of the updated list (i.e., for the first element through the i'th element)
       iii.Print the updated median on a new line. The printed value must be a double-precision number
           scaled to 1 decimal place.

        eg.
       a = [7, 3, 5, 2]

       Sorted          Median
        [7]             7.0
        [3, 7]          5.0
        [3, 5, 7]       5.0
        [2, 3, 5, 7]    4.0

        sample:

STDIN   Function
-----   --------
6       a[] size n = 6
12      a = [12, 4, 5, 3, 8, 7]
4
5
3
8
7
    * */

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    // static inner class
    public static List<Double> runningMedian(List<Integer> a) {

        List<Double> medians = new ArrayList<>();

        //ascending order
        Queue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());

        //descending order
        Queue<Integer> minheap = new PriorityQueue<>(Integer::compareTo);

        for(int number: a){

            if(maxheap.isEmpty() || number < maxheap.peek())
                maxheap.add(number);
            else
                minheap.add(number);

            //balance both sides
            if(maxheap.size() > minheap.size() + 1)
                minheap.add(maxheap.poll());


            if(minheap.size() > maxheap.size() + 1)
                maxheap.add(minheap.poll());

            medians.add(calculateMedian(maxheap, minheap));
        }
        return medians;
    }

    public static double calculateMedian(Queue<Integer> maxheap, Queue<Integer> minheap) {
        if(maxheap.size() == minheap.size())
            return (maxheap.peek() + minheap.peek()) / 2.0;

        else
            return (double) maxheap.size() > minheap.size() ? maxheap.peek() : minheap.peek();
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(12, 4, 5, 3, 8, 7);
        List<Double> medians = runningMedian(a);
        medians.forEach(System.out::println);
    }
}
