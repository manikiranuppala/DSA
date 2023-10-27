package dataStructures.doubleLinkedList;

public class Main {
    public static void main(String[] args) {
        doubleLinkedList edd=new doubleLinkedList();
        edd.append(99);
        edd.printList();
        edd.getHead();
        edd.getTail();
        edd.getLength();
        doubleLinkedList dd=new doubleLinkedList(1);
        dd.append(2);
        dd.printList();
        dd.getHead();
        dd.getTail();
        dd.getLength();
        System.out.println(dd.removeLast().value);
        dd.printList();
        dd.prepend(0);
        dd.printList();
        dd.append(2);
        dd.getLength();
        dd.printList();
        System.out.println(dd.removeFirst().value);
        dd.getLength();
        dd.printList();
        dd.append(3);
        dd.append(4);
        dd.append(5);
        dd.getLength();
        dd.printList();
        System.out.println("Get for index 3 is : "+dd.get(3).value);
        System.out.println(dd.set(3,9));
        System.out.println(dd.set(1,10));
        dd.printList();
        dd.insert(2,11);
        dd.printList();
        dd.remove(2);
        dd.printList();
    }
}
