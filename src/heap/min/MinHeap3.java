package heap.min;

public class MinHeap3 {

    int [] arr;
    int size;   // size <= capacity
    int capacity;

    MinHeap3(int c){
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    int left(int i){return (2*i+1);}

    int right(int i){return (2*i+2);}

    int parent(int i){return (i-1)/2;}

    void insert(int x){
        if(size <= capacity){
            size++;
            arr[size-1]=x;
            for(int i=size-1; i!=0 && arr[parent(i)]>arr[i]; ){
                /* Min Heap - parent > child */
                //swap(arr[i], arr[parent(i)]);

                int temp = arr[i];
                arr[i]=arr[parent(i)];
                arr[parent(i)]=temp;
                i = parent(i);
            }
        }
    }

    // Heapify and extract min...
    void minHeapify(int i){
        int leftChild = left(i);
        int rightChild = right(i);
        int smallest = i;
        if(leftChild < size && arr[leftChild] < arr[i])
            smallest = leftChild;
        else if(rightChild < size && arr[rightChild] < arr[smallest])
            smallest = rightChild;
        if(smallest != i){
            //swap(arr[smallest], arr[i])
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            minHeapify(smallest);
        }
    }

    int min(){
        if(size == 0)
            return -1;
        if(size == 1) {
            size--;
            return arr[0];
        }

        //swap (arr[0], arr[size-1])
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;
        minHeapify(0);
        return arr[size];
    }

    // Decrease key, delete and build heap
    
}
