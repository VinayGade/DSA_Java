package heap.min;

// root - smallest element than its children
public class MinHeap2 {

    private int Heap[];

    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap2(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;

        Heap=new int[this.maxSize+1];
        Heap[0]=Integer.MIN_VALUE;
    }

    /*Return position of parent of current node*/

    public int parent(int position){
        return position/2;
    }

    public int leftChild(int position){
        return 2*position;
    }

    public int rightChild(int position){
        return 2*position + 1;
    }

    public boolean isLeaf(int position){
        return position <= size && position > (size/2);
    }

    public void swap(int fpos, int spos){
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    public void minHeapify(int position){
        /*
        *  if node is non-leaf node and > any of its child
        * */
        if(!isLeaf(position) &&
                (Heap[position] > Heap[leftChild(position)] ||
                        Heap[position]> Heap[rightChild(position)])){

            if(Heap[leftChild(position)] < Heap[rightChild(position)]){

                swap(position, leftChild(position));
                minHeapify(leftChild(position));
            }else{

                swap(position, rightChild(position));
                minHeapify(rightChild(position));
            }
        }
    }

    public void insert(int element) {

        if (size >= maxSize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // To remove and return the minimum
    // element from the heap
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + Heap[i]
                            + " LEFT CHILD : " + Heap[2 * i]
                            + " RIGHT CHILD :" + Heap[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    // Main driver method
    public static void main(String[] arg) {

        // Display message
        System.out.println("The Min Heap is ");

        // Creating object opf class in main() methodn
        MinHeap2 minHeap = new MinHeap2(15);

        // Inserting element to minHeap
        // using insert() method

        // Custom input entries
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        // Print all elements of the heap
        minHeap.print();

        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                + minHeap.remove());

        System.out.println("The 2nd min Element = "
                + minHeap.remove());

        System.out.println("The 3rd min Element = "
                + minHeap.remove());
    }
}