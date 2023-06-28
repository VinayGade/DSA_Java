package sort;

public class MergeSort2 extends CommonUtility{

    // Divide the array into two sub-arrays, sort them and merge them
    public void mergeSort(int[] arr, int l, int r){

        if (l < r) {

            // m : point where array is divided into 2 sub-arrays
            int m = (l+r)/2;

            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            // Merge the sorted sub-arrays
            merge(arr, l, m, r);
        }
    }

    void merge(int[] arr, int p, int q, int r){

        int n1 = q-p+1;
        int n2 = r-q;

        int [] L = new int[n1];
        int [] M = new int[n2];

        for(int i=0; i<n1; i++)
            L[i] = arr[p+i];

        for(int j=0; j<n2; j++)
            M[j] = arr[q+1+j];

        // Maintain current index of sub-arrays and main array
        int i = 0;
        int j = 0;
        int k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while(i<n1 && j<n2){

            if(L[i] <= M[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = L[j];
            j++;
            k++;
        }
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {80, 100, 6, 5, 12, 10, 9, 1, 200, 2, 50, 4, 150, 140, 120, 90};

        MergeSort ob = new MergeSort();

        System.out.println("Before Sort:");
        ob.display(arr);

        ob.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        ob.display(arr);
    }
}
