package dataStructures.doubleLinkedList;

public class doubleLinkedList {
    private Node head;
    private Node tail;
    int length;

    public doubleLinkedList(int value)
    {
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public doubleLinkedList()
    {
        head=null;
        tail=null;
        length=0;
    }

    public void printList()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp=temp.next;
        }

    }
    public void getHead()
    {
        System.out.println("Head is: "+head.value);
    }
    public void getTail()
    {
        System.out.println("Tail is: "+tail.value);
    }
    public void getLength()
    {
        System.out.println("Length is : "+length);
    }
    public void append(int value)
    {
        Node newNode=new Node(value);
        if(length==0)
        {
            head=tail=newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    public Node removeLast()
    {
        Node temp=tail;
        if(length==0)
        {
            return null;
        }
        else if(length==1)
        {
            head=tail=null;
        }
        else{
            tail=tail.prev;
            tail.next=null;
            temp.prev=null;
        }
        length--;
        return temp;
    }
    public void prepend(int value)
    {
        Node newNode=new Node(value);
        if(length==0)
        {
            head=tail=newNode;
        }
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        length++;
    }
    public Node removeFirst()
    {
        Node temp=head;
        if(length==0)
        {
            return  null;
        }
        if(length==1)
        {
            head=tail=null;
        }
        else{
            head=head.next;
            head.prev=null;
            temp.next=null;
        }
        length--;
        return temp;

    }

    public Node get(int index)
    {
        Node temp=head;
        if(length<=index || index<0)
        {
            return null;
        }
        if(index<length/2)
        {    for(int i=0;i<index;i++)
            {
                temp=temp.next;
            }
            return temp;
        }
        else {
            temp=tail;
            for(int i=length-1;i>index;i--)
            {
                temp=temp.prev;
            }
            return temp;
        }
    }

    /*public boolean set(int index,int value)
    {
        Node temp=head;
        if(length<=index || index<0)
        {
            return false;
        }
        if(index<length/2)
        {    for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
            temp.value=value;
            return true;
        }
        else {
            temp=tail;
            for(int i=length-1;i>index;i--)
            {
                temp=temp.prev;
            }
            temp.value=value;
            return true;
        }
    }*/
    public boolean set(int index,int value)
    {
        Node temp=get(index);
        if(temp!=null)
        {
            temp.value=value;
            return true;
        }
        return false;

    }
    public boolean insert(int index,int value)
    {
        if(index<0 && index>length)
            return false;
        if(index==0) {
            prepend(value);
        }
        if(index==length-1) {
            append(value);
        }
        else {
            Node temp = get(index);
            Node newNode = new Node(value);
            temp.prev.next = newNode;
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev = newNode;
        }
        length++;
        return true;
    }
    public boolean remove(int index)
    {
        if(index<0 && index>length)
            return false;
        if(index==0) {
            removeFirst();
        }
        if(index==length-1) {
            removeLast();
        }
        else {
            Node temp = get(index);

            temp.prev.next = temp.next;
            temp.next.prev=temp.prev;
            temp.next=null;
            temp.prev=null;
        }
        length--;
        return true;
    }
}
