package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //binary search
    public static List<Double> runningMedian(List<Integer> a) {

        List<Double> list=new ArrayList<Double>();
        List<Double> result=new ArrayList<Double>();
        for(int i=0;i<a.size();i++){
            double x=a.get(i)*1.0;
            if(i==0){
                list.add(x);
                result.add(x);
            }
            else{
                int low=0,high=list.size()-1,index=0;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(list.get(mid)>x){
                        index=mid;
                        high=mid-1;
                    }
                    else{
                        index=mid+1;
                        low=mid+1;
                    }
                }
                list.add(index,x);
                if(list.size()%2==0){
                    int m=list.size()/2;
                    result.add((list.get(m)+list.get(m-1))/2);
                }
                else{
                    int m=list.size()/2;
                    result.add(list.get(m));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(12, 4, 5, 3, 8, 7);
        List<Double> medians = runningMedian(a);
        medians.forEach(System.out::println);
    }
}
