class DoubleDeleteInsert {
    Node head; 
    class Node {
        int data;
        Node prev;
        Node next;
    }
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node();
        newNode.data = data;

        if (position == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }

        Node previous = head;
        int currentIndex = 0;
        while (previous != null && currentIndex < position - 1) {
            previous = previous.next;
            currentIndex++;
        }

        if (previous == null || previous.next == null) {
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
        } else {
            newNode.next = previous.next;
            if (previous.next != null) {
                previous.next.prev = newNode;
            }
            previous.next = newNode;
            newNode.prev = previous;
        }
    }
    public void deleteAtPosition(int position) {
        if (head == null) {
            return; 
        }

        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < position) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
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
    public void printListReverse() {
        Node node = head;
        if (node == null) {
            return;
        }

        while (node.next != null) {
            node = node.next;
        }

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleDeleteInsert list = new DoubleDeleteInsert();

        list.insertAtPosition(1, 0);  // Insert at head
        list.insertAtPosition(2, 1);  // Insert at end
        list.insertAtPosition(3, 1);  // Insert at position 1
        list.insertAtPosition(4, 10); // Insert at a position greater than the length of the list (end)
        list.printList();

        list.deleteAtPosition(0);    
        list.printList();

        list.deleteAtPosition(1);    
        list.printList();

        list.deleteAtPosition(10);    
        list.printList();
    }
}
