package dataStructures.singleLinkedList;

public class Main {
    public static void main(String[] args) {
        singleLinkedList myList=new singleLinkedList(1);
        myList.append(8);
        myList.append(1);
        myList.append(1);
        myList.append(5);

        //System.out.println(myList.findMiddleNode().value);
        myList.append(6);
        myList.printList();

        //myList.partitionList(1);
        myList.removeDuplicates();
        myList.printList();
        //System.out.println(myList.findMiddleNode().value);
    }

}
