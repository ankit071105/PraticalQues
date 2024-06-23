public class StackUsingLinkedList {
    Node top;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Stack elements:");
        stack.display();
         
        System.out.println("Popped element is: " + stack.pop()); 
        System.out.println("Popped element is: " + stack.pop()); 
        System.out.println("Popped element is: " + stack.pop()); 
        System.out.println("Popped element is: " + stack.pop()); 
        stack.push(40);
        stack.push(50);
        
        System.out.println("Stack elements after pushing 40 and 50:");
        stack.display();
    }
}
