package linkedlist;

public class DoublyLinkedList {

    static class Node {
        private final String data;
        private Node next;
        private Node prev;

        public Node(String data) {
            this.data = data;
        }
    }

    Node head = null;

    private void addNode(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    private void rotateByN(int n){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head.prev = temp;

    }

    private void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        // Add nodes to the list
        dList.addNode("1");
        dList.addNode("2");
        dList.addNode("3");
        dList.addNode("4");
        dList.addNode("5");

        dList.display();
    }
}
