package recursion;

public class MinMax {

    static class Pair {
        int min;
        int max;
    }

    // Algorithms by Sahani
    public static Pair straightMinMax(int[] a, int n){

        int min;
        int max = min = a[0];
        for (int i=1; i<n; i++){
            if(a[i]> max)
                max =a[i];
            else if(a[i]< min)
                min =a[i];
        }
        Pair pair = new Pair();
        pair.max= max;
        pair.min= min;
        return pair;
        //System.out.println("max = "+max+", min = "+min);
    }

    static int getMin(int arr[], int i, int n)
    {
        // If there is single element, return it.
        // Else return minimum of first element and
        // minimum of remaining array.
        return (n == 1) ? arr[i] : Math.min(arr[i],
                getMin(arr,i + 1 , n - 1));
    }

    static int getMax(int arr[], int i, int n)
    {
        // If there is single element, return it.
        // Else return maximum of first element and
        // maximum of remaining array.
        return (n == 1) ? arr[i] : Math.max(arr[i],
                getMax(arr ,i + 1, n - 1));
    }

    /*
    public static void minMaxRecursive(int[] a, int n, int i, int max, int min){
        max=min=a[i];
        if(a[i+1]>max)
            minMaxRecursive(a, )

    }
     */

    public static void minMax(int[] a, int i, int j, int max, int min){

        //a[1 : n] is a global array. Parameters i and j are integers,
        //1<=i<=j<=n.The effect is to set max and min to the
        // largest and smallest values in a [i: j], respectively.
        if(i==j)
            max=min=a[i];

        else if(i==j-1){
            if(a[i] < a[j]){
                min = a[i];
                max = a[j];
            }else{
                max = a[i];
                min = a[j];
            }
        }else{
            //If P is not small, divide P into subproblems.
            //Find where to split the set.
            int mid = (i+j)/2;

            //Solve the subproblems.
            int max1=a[j];
            int min1=a[j];
            minMax(a, i, mid, max, min);
            minMax(a,mid + 1, j, max1, min1);

            // Combine the solutions.
            if (max < max1)
                max= max1;
            if (min > min1)
                min= min1;
        }
        System.out.println("max = "+max+", min = "+min);
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new  Pair();
        int i;

        /*If there is only one element then return it as min and max both*/
        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        /* If there are more than one elements, then initialize min
    and max*/
        if (arr[0] > arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for (i = 2; i < n; i++) {
            if (arr[i] > minmax.max) {
                minmax.max = arr[i];
            } else if (arr[i] < minmax.min) {
                minmax.min = arr[i];
            }
        }

        return minmax;
    }

    // tournament method : divide and conquer (GeeksForGeeks)
    /*
    Pair MaxMin(array, array_size)
    if array_size = 1
        return element as both max and min
    else if arry_size = 2
        one comparison to determine max and min
         return that pair
    else    ... array_size  > 2
        recur for max and min of left half
        recur for max and min of right half
        one comparison determines true max of the two candidates
        one comparison determines true min of the two candidates
            return the pair of max and min
    *
    * */
    static Pair getMinMaxTournament(int arr[], int n) {
        Pair minmax = new  Pair();
        int i;

        /*If there is only one element then return it as min and max both*/
        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        /* If there are more than one elements, then initialize min
    and max*/
        if (arr[0] > arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for (i = 2; i < n; i++) {
            if (arr[i] > minmax.max) {
                minmax.max = arr[i];
            } else if (arr[i] < minmax.min) {
                minmax.min = arr[i];
            }
        }

        return minmax;
    }

    public static void main(String[] args) {

        int[] a = {500, 100, 25, 50, 20, 15, 200, 30, 900, 40, 70, 80, 300, 90};
        int n = a.length;
        //minMax(a, 0, n-1, -1, -1);
        Pair minMax1 = straightMinMax(a, n);
        Pair minMax2 = getMinMax(a, n);
        Pair minMax3 = getMinMaxTournament(a, n);

        System.out.println("getMinMax : min = "+minMax2.min + ", max="+minMax2.max);
        System.out.println("straightMinMax : min = "+minMax1.min + ", max="+minMax1.max);
        System.out.println("getMinMaxTournament : min = "+minMax3.min + ", max="+minMax3.max);
    }
}