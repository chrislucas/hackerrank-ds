package solution;

public class PreorderBST {
    static class Node<T extends Comparable<T>> {
        T data;
        private BST.Node<T> left, right;
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public String toString() {
            return String.format("Value: %s", data);
        }
    }



    public static void main(String[] args) {
        Integer [][] set = {{10, 5, 1, 7, 40, 50}};
    }
}
