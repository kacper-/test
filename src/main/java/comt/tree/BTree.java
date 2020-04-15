package comt.tree;

import java.util.ArrayList;
import java.util.List;

public class BTree {
    private Node head;

    public BTree(Node node) {
        this.head = node;
    }

    public String print() {
        List<String> printList = new ArrayList<>();
        printList.clear();
        print(head, 0, printList);
        String result = "";
        for (int i = 0; i < printList.size(); i++) {
            for (int j = 0; j < printList.size() - i; j++)
                result += "\t";
            result += printList.get(i) + "\n";
        }
        return result;
    }

    private void print(Node node, int i, List<String> printList) {
        if (node == null) {
            putIntoList("null", i, printList);
            return;
        }
        putIntoList(node.getName(), i, printList);
        if (node.getLeft() != null || node.getRight() != null) {
            print(node.getLeft(), i + 1, printList);
            print(node.getRight(), i + 1, printList);
        }
    }

    private void putIntoList(String s, int i, List<String> printList) {
        if (i < printList.size()) {
            String a = printList.get(i) + "\t" + s;
            printList.set(i, a);
        } else {
            printList.add(s);
        }
    }
}
