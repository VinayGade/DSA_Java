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

        System.out.println("Size of circular list after insertions = "+circularList.size());

        System.out.println("Traverse Circular List:");

        circularList.traverse();

        circularList.insertEnd(90);
        circularList.insertEnd(100);

        System.out.println("Traverse Circular List after inserting at end:");

        circularList.traverse();

        System.out.println("Size of circular list after insertions = "+circularList.size());
    }
}
