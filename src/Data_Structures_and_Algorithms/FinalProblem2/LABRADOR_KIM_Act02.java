package Data_Structures_and_Algorithms.FinalProblem2;

public class LABRADOR_KIM_Act02 {
    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Create a cycle (3 -> 2)
        head.next.next.next = head.next;

        if (hasCycle(head)) {
            IO.println("Cycle detected");
        } else {
            IO.println("No cycle");
        }
    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) {
                return true;           // cycle detected
            }
        }

        return false;
    }
}
