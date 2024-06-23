class SingleDelteInsert {
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

    public void deleteAtPosition(int position) {
        if (head == null) {
            return; 
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node previous = head;
        int currentIndex = 0;
        while (previous != null && currentIndex < position - 1) {
            previous = previous.next;
            currentIndex++;
        }

        if (previous == null || previous.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        Node nodeToDelete = previous.next;
        previous.next = nodeToDelete.next;
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
        SingleDelteInsert list = new SingleDelteInsert();

        list.insertAtPosition(1, 0);  // Insert at head
        list.insertAtPosition(2, 1);  // Insert at end
        list.insertAtPosition(3, 1);  // Insert at position 1
        list.insertAtPosition(4, 10); // Insert at a position greater than the length of the list (end)
        list.printList();

        list.deleteAtPosition(0);     // Delete at head
        list.printList();

        list.deleteAtPosition(1);     // Delete at position 1
        list.printList();

        list.deleteAtPosition(10);    // Attempt to delete at a position greater than the length of the list
        list.printList();
    }
}
