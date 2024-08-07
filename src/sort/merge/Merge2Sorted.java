package sort.merge;

public class Merge2Sorted {
    static int[] merge(int [] L, int [] M){

        int n1 = L.length;
        int n2 = M.length;

        int n = n1+n2;

        int[] arr = new int[n];

        // Maintain current index of sub-arrays and main array
        int i = 0;
        int j = 0;
        int k = 0;

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
            arr[k] = M[j];
            j++;
            k++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int arr[] = merge(arr1, arr2);
        for(int x: arr){
            System.out.print(x+ " ");
        }
    }
}
