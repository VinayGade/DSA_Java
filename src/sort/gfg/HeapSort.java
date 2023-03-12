package sort.gfg;

public class HeapSort {

    public static void main(String[] args) {


    }

    public void maxHeapify(int [] a, int n, int i){

        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && a[left]>a[largest])
            largest = left;

        else if(right < n && a[right]>a[largest])
            largest = right;

        if(largest != i){

            //swap ( a[largest], a[i])
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;

            maxHeapify(a, n, largest);
        }

    }

    // step 1 : Build Max Heap.
    public void buildHeap(int [] a, int n){

        int i = (n-2)/2;    // parent of last node
        while(i>=0){
            maxHeapify(a, n, i);
            i--;
        }
    }

    /*
    Repeatedly swap root with last node,
    reduce heap size by 1 and heapify.
    * */

    public void heapSort(int[] a, int n){

        buildHeap(a, n);
        for(int i = n-1; i>=1; i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            maxHeapify(a, i, 0);
        }
    }
}
