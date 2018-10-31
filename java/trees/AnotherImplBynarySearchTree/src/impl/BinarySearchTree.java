package impl;

public class BinarySearchTree {


    private static class Node<T> {
        private T data;
        private Node le, ri;


        public Node(T data) {
            this.data = data;
        }

        private Node getLeft() {
            return le;
        }

        private Node getRight() {
            return ri;
        }
    }

    private static Node root;


    public static void main(String[] args) {

    }
}
