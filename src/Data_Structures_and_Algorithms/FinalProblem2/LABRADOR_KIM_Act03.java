package Data_Structures_and_Algorithms.FinalProblem2;

public class LABRADOR_KIM_Act03 {
    static void main() {
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Node merged = mergeLists(list1, list2);

        IO.print("Merged List: ");
        printList(merged);
    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeLists(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
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
