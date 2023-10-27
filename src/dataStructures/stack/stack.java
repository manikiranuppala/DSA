package dataStructures.stack;

public class stack {
    private Node top;
    private int height;

    stack(int value)
    {
        //Node newNode=new Node(value);
        top=new Node(value);
        height=1;
    }

    public void printStack(){
        Node temp=top;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public void getTop()
    {
        System.out.println("the Top is: " +top.value);
    }

    public void getHeight()
    {
        System.out.println("the height of stack is: " +height);
    }

    public void push(int value)
    {
        Node newNode=new Node(value);
        if(height==0)
        {
            top=newNode;
        }
        else{
            newNode.next=top;
            top=newNode;
        }
        height++;
    }
    public Node pop(){
        Node temp;
        if(height==0)
        {
            return null;
        }
        else{
            temp=top;
            top=top.next;
            temp.next=null;
        }
        height--;
        return temp;
    }
}
