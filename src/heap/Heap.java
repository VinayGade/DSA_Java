package heap;

public class Heap {

    private Node[] heapArray;
    private int maxSize;         // size of array
    private int currentSize;     // number of nodes in array

    public Heap(int maxSize){
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean insert(int data){
        if(currentSize == maxSize)
            return false;

        Node node = new Node(data);
        heapArray[currentSize] = node;
        tickleUp(currentSize++);
        return true;
    }

    public void tickleUp(int index){
        int parent = (index - 1)/2;
        Node bottom = heapArray[index];

        while(index > 0 && heapArray[parent].getData() < bottom.getData()){

            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1)/2;
        }
        heapArray[index] = bottom;
    }

    public void tickleDown(int index){
        int largeChild;
        Node top = heapArray[index];    // save root

        while(index < (currentSize/2)){    // while node has at least 1 child

            int leftChild = 2*index + 1;
            int rightChild = leftChild + 1;

            // find larger child

            if(rightChild < currentSize &&   // rightchild exisits?
                heapArray[leftChild].getData() < heapArray[rightChild].getData()){

                largeChild = rightChild;
            }else
                largeChild = leftChild;

            if(top.getData() >= heapArray[largeChild].getData())  // top >= largerChild?
                break;

            heapArray[index] = heapArray[largeChild];
            index = largeChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int data){
        if(index<0 || index>=currentSize)
            return false;

        int oldData = heapArray[index].getData();  // store old

        heapArray[index].setData(data);            // change with new

        if(oldData < data)                    // if raised
            tickleUp(index);

        else                                  // if lowered
            tickleDown(index);

        return true;
    }

    public void display(){

        System.out.println("heapArray :" );

        for(int m = 0; m<currentSize; m++){
            if(heapArray[m]!= null)
                System.out.print(heapArray[m].getData()+" ");
            else
                System.out.print("--");
        }
        System.out.println();


    }
}
