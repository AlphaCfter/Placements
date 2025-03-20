package trees;

public class Trees {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Root of the tree
    public Node root;

    Trees() {
        this.root = null;
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addRecursive(root, value);
        }
    }


    private void addRecursive(Node node, int value) {
        if (node.left == null) {
            node.left = new Node(value);
            return;
        }


        if (node.right == null) {
            node.right = new Node(value);
            return;
        }

        addRecursive(node.left, value);
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.value + " ");
            printInOrderRecursive(node.right);
        }
    }

    public static void main(String[] args) {
        Trees tree = new Trees();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        System.out.println("In-order traversal of the Binary Tree:");
        tree.printInOrder();
    }
}
