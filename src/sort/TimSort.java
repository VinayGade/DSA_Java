package sort;

public class TimSort extends CommonUtility{

    static int MIN_MERGE = 32;

    public static void main(String[] args) {

        int[] arr = { -2, 7,  100,  -12, 0, 50, 6, 1, 9, -80, -200, -89, 512, 1024, 10, 1630, 1857, 1307,
                -7, -4, -13, 5, 8, -14, 12, 200, 240, 420, 360};
        int n = arr.length;
        System.out.println("Given Array is");

        TimSort timSort = new TimSort();

        timSort.display(arr);

        timSort(arr, n);

        System.out.println("After Sorting Array is");
        timSort.display(arr);
    }

    /*
    public static int minRunLength(int n)
    {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
     */

    public static void timSort(int arr[], int n)
    {

        for (int i = 0; i < n; i += MIN_MERGE)
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));

        for (int size = MIN_MERGE; size < n; size = 2 * size) {

            for (int left = 0; left < n; left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                merge(arr, left, mid, right);
            }
        }
    }

    /*
    // Iterative Timsort function to sort the
    // array[0...n-1] (similar to merge sort)
    public static void timSort(int[] arr, int n)
    {
        int minRun = minRunLength(MIN_MERGE);

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += minRun) {
            insertionSort(
                    arr, i,
                    Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Start merging from size
        // RUN (or 32). It will
        // merge to form size 64,
        // then 128, 256 and so on
        // ....
        for (int size = minRun; size < n; size = 2 * size) {

            // Pick starting point
            // of left sub array. We
            // are going to merge
            // arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we
            // increase left by 2*size
            for (int left = 0; left < n; left += 2 * size) {

                // Find ending point of left sub array
                // mid+1 is starting point of right sub
                // array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                // Merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }
     */

    public static void insertionSort(int[] a, int left, int right){

        for(int i=left+1; i<=right; i++){
            int temp = a[i];
            int j=i-1;
            while(j>=left && temp < a[j]){
                a[j+1] = a[j]; // right shift array
                j--;
            }
            a[j+1]=temp;
            //i++;
            //right part is sorted hence don't move i'th pointer.
        }
    }

    public static void merge(int[] a, int l, int mid, int r){

        int leftLength = mid - l + 1;
        int rightLength = r - mid;

        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for(int i=0; i<leftLength; i++)
            left[i] = a[l+i];

        for(int i=0; i<rightLength; i++)
            right[i] = a[(mid+1)+i];

        int i = 0;
        int j = 0;
        int k = l;

        while(i<leftLength && j<rightLength){

            if(left[i] < right[j]){
                a[k] = left[i];
                i++;
            }else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<leftLength){
            a[k] = left[i];
            i++;
            k++;
        }

        while(j<rightLength){
            a[k] = right[i];
            j++;
            k++;
        }
    }
}