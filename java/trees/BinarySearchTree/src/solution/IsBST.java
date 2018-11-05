package solution;

public class IsBST {

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left, right, parent;
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private boolean isLeaf() { return left == null && right == null; }

        @Override
        public String toString() {
            return String.format("%s", data);
        }
    }

    private static <T extends Comparable<T>> boolean isValid(Node<T> root, T min, T max) {
        if (root == null)
            return true;
        boolean flag = root.data.compareTo(min) > 0 && root.data.compareTo(max) < 0;
        return flag && isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }


    public static void main(String[] args) {

    }
}
