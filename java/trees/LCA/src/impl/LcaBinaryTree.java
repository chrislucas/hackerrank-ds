package impl;

public class LcaBinaryTree {

    static class Node<T> {
        T data;
        Node<T> left, right;
        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("%s", data);
        }
    }


    public static void main(String[] args) {

    }
}
