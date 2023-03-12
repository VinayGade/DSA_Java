package sort.gfg;

public class SelectionSort {

    public static void main(String[] args) {

        int arr[] = {100, 90, 30, 20, 50, 70, 80, 10, 5, 40};

        SelectionSort selection = new SelectionSort();
        selection.selectionSort(arr);

        System.out.println("sorted array :");

        for(int x : arr)
            System.out.println(x);

    }

    public void selectionSort(int[] a){

        // Rule : Find min and replace it with current element

        int n = a.length;

        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
