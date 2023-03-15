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
    }
}
