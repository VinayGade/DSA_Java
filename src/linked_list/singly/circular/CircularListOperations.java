package linked_list.singly.circular;

public class CircularListOperations {

    public static void main(String[] args) {

        CircularLinkedList circularList = new CircularLinkedList();

        int length = circularList.size();

        System.out.println("Size of empty circular list = "+length);

        // insert node at begin
        System.out.println("insert at begin of circular list ");

        circularList.insertBegin(80);
        circularList.insertBegin(50);
        circularList.insertBegin(20);
        circularList.insertBegin(10);

        System.out.println("Size of circular list after insertions = "+circularList.size());

        System.out.println("Traverse Circular List:");

        circularList.traverse();

        circularList.insertEnd(90);
        circularList.insertEnd(100);

        System.out.println("Traverse Circular List after inserting at end:");

        circularList.traverse();

        System.out.println("Size of circular list after insertions = "+circularList.size());

        System.out.println("Deleted 1st element  : "+circularList.deleteBegin());

        System.out.println("Traverse Circular List after delete:");

        circularList.traverse();

        System.out.println("Size of circular list after delete = "+circularList.size());

        System.out.println("\nDeleted last element  : "+circularList.deleteEnd());

        System.out.println("\nTraverse Circular List after delete end:");

        circularList.traverse();

        System.out.println("Size of circular list after delete end = "+circularList.size());

        System.out.println("\nsearch 80 in circular list  : "+circularList.search(80));

        System.out.println("\ninsert 70 at position 2 in circular list  : ");
        circularList.insertAt(2, 70);


        System.out.println("\ninsert 60 after 50 in circular list  : ");
        circularList.insertAfter(50, 60);

        System.out.println("\nTraverse Circular List after insertions:");

        circularList.traverse();

        System.out.println("\nsearch 80 in circular list  : "+circularList.search(80));

        System.out.println("\ndelete 20 in circular list  : "+circularList.delete(20));  // 60 50 20

        System.out.println("\nTraverse Circular List after deletion:");

        circularList.traverse();

        System.out.println("\ndelete element at index 4 from circular list (last element) : "+circularList.deleteAt(4));

        System.out.println("\nTraverse Circular List after deletion:");

        circularList.traverse();
    }
}
