class DoublyLinkedList {
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
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println();
        System.out.println("Insert at First");
        list.insertAtPosition(1, 0);  
        list.printList();
        list.insertAtPosition(2, 2);  
System.out.println(" Insert at any");
list.printList();
System.out.println(" Insert at end");
list.insertAtPosition(3, 3);  
list.printList();
        System.out.println("Reverse the List");
        list.printListReverse();
    }
}
