import java.util.Scanner;

public class CircularInsertPosition {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node insertAtEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        return head;
    }

    static Node insertAtPosition(Node head, int data, int position) {

        Node newNode = new Node(data);

        if (position <= 0) {
            System.out.println("Invalid position.");
            return head;
        }

        if (head == null && position == 1) {
            newNode.next = newNode;
            return newNode;
        }

        if (position == 1) {

            Node last = head;

            while (last.next != head) {
                last = last.next;
            }

            newNode.next = head;
            last.next = newNode;

            return newNode;
        }

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {

            if (temp.next == head) {
                System.out.println("Invalid position.");
                return head;
            }

            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    static void display(Node head) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter data: ");
            int data = sc.nextInt();

            head = insertAtEnd(head, data);
        }

        System.out.println("Original Circular Linked List:");
        display(head);

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        System.out.print("Enter position: ");
        int position = sc.nextInt();

        head = insertAtPosition(head, value, position);

        System.out.println("After insertion:");
        display(head);

        sc.close();
    }
}
