package dataStructures.stack;

public class Main {
    public static void main(String[] args) {
        stack myStack=new stack(1);
        myStack.printStack();
        myStack.getTop();
        myStack.getHeight();
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.getTop();
        myStack.getHeight();
        myStack.printStack();
        System.out.println("pop the element : "+myStack.pop().value);
        myStack.getTop();
        myStack.getHeight();
        myStack.printStack();

    }
}
