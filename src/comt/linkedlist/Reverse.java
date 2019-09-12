package comt.linkedlist;

public class Reverse {

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        print(n1);
        print(reverse(n1));
    }

    static Node reverse(Node oldHead) {
        Node newHead = oldHead;
        Node tmp;
        while (oldHead.next != null) {
            tmp = newHead;
            newHead = oldHead.next;
            oldHead.next = oldHead.next.next;
            newHead.next = tmp;
        }
        return newHead;
    }

    static void print(Node node) {
        Node n = node;
        while (n != null) {
            System.out.println(n.name);
            n = n.next;
        }
    }
}
