package solution;

public class InOrderSuccessor {

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left, right, parent;
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
        }

        private boolean isLeaf() { return left == null && right == null; }

        @Override
        public String toString() {
            return String.format("%s <- %s", data, parent);
        }
    }

    private static Node root;

    private static <T extends Comparable<T>> void insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null)
            root = node;
        else {
            insert(root, value);
        }
    }

    private static <T extends Comparable<T>> void insert(Node<T> root, T value) {
        if (root.data.compareTo(value) > 0) {
            if (root.left == null)
                root.left = new Node<T>(value, root);
            else
                insert(root.left, value);
        }
        else {
            if (root.right == null)
                root.right = new Node<T>(value, root);
            else
                insert(root.right, value);
        }
    }

    public static <T extends Comparable<T>> Node<T> inOrderSuccessor(Node<T> root, Node<T> node) {
        if (root == null)
            return root;

        else if(root.right != null) {
            Node<T> copy = root.right;
            while (copy.left != null) {
                copy = copy.left;
            }
            return copy;
        }

        else {
            Node parent = root.parent;
        }

        return null;
    }
    private static <T extends Comparable<T>> void print(Node<T> node) {
        System.out.printf(" %s", node.data);
    }

    private static<T extends Comparable<T>> void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            print(node);
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Integer [][] set = {
            {10, 20, 30, 15, 12, -15, 35, 30}
            ,{50, 30, 20, 40, 70, 60, 80}
            ,{50, 30, 20, 40, 70, 60, 80, 10}
            ,{5, 3, 6, 2, 4, 7}
        };
        for (Integer s : set[3]) {
            insert(s);
        }
        inorder(root);
    }
}
