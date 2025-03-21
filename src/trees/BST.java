package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

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

    BST() {
        this.root = null;
    }

    public void add(int value) {

            root = addRecursive(root, value);

    }

    private Node addRecursive(Node node, int value) {

        if (node == null) {
            return new Node(value);
        }
        else if( value < node.value){
            node.left=addRecursive(node.left, value);
        }else if( value > node.value){
            node.right=addRecursive(node.right, value);
        }

        return node;
    }

    private void levelOrderTraversal(){
        if(root == null){
            System.out.println("Tree empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.value+" ");

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }

    private void printTree(Node node){
        if (node != null){
            printTree(node.left);
            System.out.print(node.value+" ");
            printTree(node.right);
        }
    }


    private boolean isPresent(Node node, int key){
        if ( node == null){
            return false;
        }
        if( key == node.value){
            return true;
        }

        if( key < node.value){
            return isPresent(node.left, key);
        }else{
            return isPresent(node.right, key);
        }

    }

    private Node deleteElement(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.value) {
            node.left = deleteElement(node.left, key);
        } else if (key > node.value) {
            node.right = deleteElement(node.right, key);
        } else {

            // Node to be deleted found

            // Case 1: Node has no children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 3: Node has two children
            Node temp = findMinimum(node.right);
            node.value = temp.value;
            node.right = deleteElement(node.right, temp.value);
        }

        return node;
    }


    private Node findMinimum(Node node) {
        Node temp = node;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        System.out.println("Testing is present values");
        boolean a = tree.isPresent(tree.root, 10);
        boolean b = tree.isPresent(tree.root, 1000);

        System.out.println(a);
        System.out.println(b);

        System.out.println("Printing tree");
        tree.printTree(tree.root);

        System.out.println("\nLevel order traversal");
        tree.levelOrderTraversal();

    }
}
