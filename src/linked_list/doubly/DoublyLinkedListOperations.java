package linked_list.doubly;

public class DoublyLinkedListOperations {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertBegin(10);
        dll.insertBegin(5);
        dll.insertEnd(20);
        dll.insertEnd(30);
        dll.insertEnd(100);

        System.out.println("list size = "+dll.count());
        System.out.println("find 20 from list  = "+dll.find(20));
        dll.display();
        dll.reverse();

        dll.insertAfter(30,40);

        dll.insertAfter(40,50);
        System.out.println("list size = "+dll.count());
        dll.display();
        dll.insertAfter(50,60);
        dll.insertAfter(60,70);
        dll.insertAfter(70,80);
        dll.insertAfter(80,90);


        dll.display();
        dll.reverse();

        System.out.println("list size = "+dll.count());
        System.out.println("find 70 from list  = "+dll.find(70));

        dll.deleteBegin();
        dll.deleteEnd();

        System.out.println("After deletion:");
        dll.display();

        System.out.println("list size = "+dll.count());

        dll.delete(70);
        dll.replace(80, 85);
        System.out.println("After deletion list size = "+dll.count());
        System.out.println("find 70 from list  = "+dll.find(70));
        System.out.println("find 85 from list  = "+dll.find(85));
        dll.reverse();
    }
}
