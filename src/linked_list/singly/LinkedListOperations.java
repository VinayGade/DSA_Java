package linked_list.singly;

public class LinkedListOperations {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertBegin(20);
        list.insertBegin(10);
        list.insertEnd(40);
        list.insertAt(30, 2);
        list.insertEnd(50);
        list.insertEnd(80);
        list.insertEnd(90);
        list.insertEnd(100);

        list.traverse();

        System.out.println("\ncount = "+list.count());

        System.out.println("\n find 80 ?"+list.find(80));
        System.out.println("\n find 30 ?"+list.find(30));
        System.out.println("\n find 100 ?"+list.find(100));
        System.out.println("\n find 90 ?"+list.find(90));
        System.out.println("\n find 50 ?"+list.find(50));
        System.out.println("\n find 10 ?"+list.find(10));
        /*
        System.out.println("\n Reverse list : ");
        list.reverse();

         */
        list.deleteBegin();
        list.traverse();
        list.deleteEnd();
        System.out.println("\ncount = "+list.count());
        list.traverse();


        System.out.println("\n find 80 ?"+list.find(80));

        /*
        System.out.println("\n Reverse list : ");
        list.reverse();

         */

        list.replace(80,70);
        System.out.println("\n find 20 ?"+list.find(20));
        list.traverse();
        System.out.println("\n find 70 ?"+list.find(70));
        System.out.println("\n delete element 50 ?"+list.deleteElement(50));

        list.traverse();

        System.out.println("\n delete element at 3 ?"+list.deleteAt(3));

        list.insertEnd(200);
        list.insertBegin(5);

        list.traverse();
        System.out.println("\n Reverse list : ");
        list.reverse();
        list.traverse();

        System.out.println("\n find 20 ?"+list.find(20));
        System.out.println("\n find 90 ?"+list.find(90));
    }
}
