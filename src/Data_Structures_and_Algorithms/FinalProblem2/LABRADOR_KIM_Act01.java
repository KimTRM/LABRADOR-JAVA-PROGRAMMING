package Data_Structures_and_Algorithms.FinalProblem2;

public class LABRADOR_KIM_Act01 {
    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        IO.print("Original: ");
        printList(head);

        head = reverseList(head);

        IO.print("Reversed: ");
        printList(head);
    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;   // store next
            current.next = prev;   // reverse link
            prev = current;        // move prev
            current = next;        // move current
        }

        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            IO.print(temp.data + " -> ");
            temp = temp.next;
        }
        IO.println("null");
    }
}
