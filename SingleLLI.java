class LinkedList {
    Node head; 
    class Node {
        int data;
        Node next;
    }
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node();
        newNode.data = data; 
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node previous = head;
        int currentIndex = 0;
        while (previous != null && currentIndex < position - 1) {
            previous = previous.next;
            currentIndex++;
        }
        if (previous == null) {
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
System.out.println();
        list.insertAtPosition(1, 0);
        System.out.println(" Insert at Start");  
        list.printList();

        list.insertAtPosition(7, 1); 
        System.err.println("Insert at Any"); 
        list.printList();
        list.insertAtPosition(4, 3); 
        System.err.println("Insert at Any"); 
        list.printList();
        list.insertAtPosition(3, 6); 
        System.err.println("Insert at Any"); 
        list.printList();
        list.insertAtPosition(5, 7); 
        System.err.println("Insert at Any"); 
        list.printList();

        list.insertAtPosition(4, 10); 
        System.out.println("Insert at end");
        list.printList();
    }
}
