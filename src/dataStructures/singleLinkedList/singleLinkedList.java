package dataStructures.singleLinkedList;
import java.util.*;
public class singleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value)
        {
            this.value=value;
        }
    }
    public singleLinkedList()
    {
        head=null;
        tail=null;
        length=0;
    }

    public singleLinkedList(int value)
    {
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList()
    {
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public void append(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            head=newNode;
            tail=newNode;

        }
        else{
            tail.next=newNode;
            tail=newNode;

        }
        length++;
    }

    public void removeLast()
    {
        if(head==tail)
        {
            head=null;
            tail=null;
        }
        else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        length--;
    }

    public void prepend(int val){
        Node newNode=new Node(val);

        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }

    public void removeFirst()
    {
        if(head==tail)
        {
            head=null;
            tail=null;
        }
        else {
            Node Temp=head.next;
            head.next=null;
            head=Temp;
        }
        length--;

    }

    public Node get(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++) {
            temp = temp.next;
        }
        return temp;
        //System.out.println("Node at index: "+index+" is "+temp.value);

    }

    public boolean set(int index,int val)
    {
        Node temp=get(index);
        if(temp!=null)
        {
            temp.value=val;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean Insert(int index,int val) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(val);
            return true;
        }
        if (index == length) {
            append(val);
            return true;
        }
        Node newNode = new Node(val);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public boolean Remove(int index)
    {
        if(index<0 || index>=length)
            return false;
        if(index==0)
        {
            removeFirst();
            return true;
        }
        if(index==length-1)
        {
            removeLast();
            return true;
        }
        Node prev=get(index-1);
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
        length--;
        return true;
    }

    public boolean reverse()
    {
        if(length<=1)
            return false;
        Node temp=head;
        head=tail;
        Node before=null;
        Node after=temp.next;
        for(int i=0;i<length;i++)
        {
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
        return true;
    }
    public Node findMiddleNode()
    {
        Node fast=head;
        Node slow=head;
        while(fast!=tail && fast!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public boolean hasLoop()
    {
        Node fast=head;
        Node slow=head;
        while(fast != null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
    }
    //without length
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    //used to find Length
    public Node findKthFromEndLength(int k)
    {
        int Length=1;
        Node len=head;
        Node kthNode=null;
        while(len!=tail)
        {
            len=len.next;
            Length+=1;
        }
        if(k>Length)
        {
            return null;
        }
        if(k==Length)
        {
            return head;
        }
        if(k<Length)
        {
            kthNode=head;
            int required=Length-k;
            for(int i=0;i<required;i++)
            {
                kthNode=kthNode.next;
            }
        }
        return kthNode;
    }
    public void partitionList(int x)
    {
        Node lowerhead=null;
        Node lowertail=null;
        Node higherhead=null;
        Node highertail=null;
        Node travel=head;



        while(travel!=null)
        {
            if(travel.value<x)
            {
                if(lowerhead==null && lowertail==null){
                    lowerhead=travel;
                    lowertail=travel;
                }

                else{
                    lowertail.next=travel;
                    lowertail=travel;
                }

            }
            else{
                if(higherhead==null && highertail==null){
                    higherhead=travel;
                    highertail=travel;
                }

                else{
                    highertail.next=travel;
                    highertail=travel;
                }
            }
            travel=travel.next;
        }
        //checking all are greater and all are smaller
        if(lowerhead!=null && higherhead!=null)
        {
            lowertail.next=null;
            highertail.next=null;
            lowertail.next=higherhead;
            head=lowerhead;
        }
    }
    public void removeDuplicates()
    {
        Node temp1=head;
        Node temp2=head;
        while(temp1!=null)
        {
            temp2=temp1;
            while(temp2.next!=null)
            {
                if(temp1.value==temp2.next.value)
                {
                    Node temp=temp2.next;
                    temp2.next=temp.next;
                }
                else{ // added in else because duplicates like 2->1->1->1 repeating are also covered
                    temp2=temp2.next;
                }
            }
            temp1=temp1.next;
        }
    }
    public void removeDuplicatesSet() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }
}
