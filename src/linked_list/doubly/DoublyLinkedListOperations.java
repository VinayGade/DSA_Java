package linked_list.doubly;

public class DoublyLinkedListOperations {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertBegin(10);
        dll.insertBegin(5);
        dll.insertEnd(20);
        dll.insertEnd(30);
        dll.insertEnd(100);

        dll.display();

        System.out.println("list size = "+dll.size());
        System.out.println("list count = "+dll.count());
        System.out.println("find 20 from list  = "+dll.find(20));
        System.out.println("list contains 30 ? "+dll.contains(30));

        dll.reverse();

        dll.insertAfter(30,40);

        dll.insertAfter(40,50);
        System.out.println("list size = "+dll.size());
        System.out.println("list count = "+dll.count());

        dll.display();
        System.out.println("list contains 50 ? "+dll.contains(50));

        dll.insertAfter(50,60);
        dll.insertAfter(60,70);
        dll.insertAfter(70,80);
        dll.insertAfter(80,90);

        dll.display();
        dll.reverse();

        System.out.println("list size = "+dll.size());
        System.out.println("list count = "+dll.count());
        System.out.println("find 70 from list  = "+dll.find(70));
        System.out.println("list contains 80 ? "+dll.contains(80));

        System.out.println("list contains 5 ? "+dll.contains(5));
        System.out.println("list contains 90 ? "+dll.contains(90));
        dll.deleteBegin();
        dll.deleteEnd();

        System.out.println("After deletion:");
        dll.display();

        System.out.println("list contains 5 ? "+dll.contains(5));
        System.out.println("list contains 100 ? "+dll.contains(100));
        System.out.println("list size = "+dll.size());
        System.out.println("list count = "+dll.count());
        dll.delete(70);
        dll.replace(80, 85);
        System.out.println("\nAfter replacement:");
        dll.display();
        System.out.println("After deletion list size = "+dll.size());
        System.out.println("list count = "+dll.count());
        System.out.println("list contains 85 ? "+dll.contains(85));
        System.out.println("list contains 80 ? "+dll.contains(80));
        System.out.println("list contains 70 ? "+dll.contains(70));
        System.out.println("find 70 from list  = "+dll.find(70));
        System.out.println("find 85 from list  = "+dll.find(85));
        dll.reverse();
    }
}
