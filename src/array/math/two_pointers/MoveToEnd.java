package array.math.two_pointers;

public class MoveToEnd {

    /*
    int n = 8, k = 2
    input: a[] = {2, 1, 2, 2, 2, 3, 4, 2}

    Output: a[] =  {1, 3, 4, 2, 2, 2, 2, 2}
    * */

    public static void moveToEnd(int[] a, int n, int k) {
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            while (i < j && a[j] == k){
                // Decrement right pointer
                j--;
            }

            if (a[i] == k) {

                // Swap the two elements
                // in the array
                swap(a, i, j);
            }

            // Increment left pointer
            i++;
        }
    }

    static int[] swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 2, 2, 2, 3, 4, 2};
        int n = 8;
        int k = 2;
        moveToEnd(a, n, k);
        for(int x: a)
            System.out.print(x+" ");
    }

}
