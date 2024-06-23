class Node {
    int data;
    Node next;
}

class LinkedListQueue {
     Node front = null;
     Node rear = null;
    void push(int item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }
    int pop() {
        if (this.front == null)
            return -1;
        Node temp = this.front;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;

        return temp.data;
    }
    boolean isEmpty() {
        return front == null;
    }
    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);

        System.out.println("Pop item: " + queue.pop());
        
        System.out.println("Queue elements:");
        queue.display();
    }
}
