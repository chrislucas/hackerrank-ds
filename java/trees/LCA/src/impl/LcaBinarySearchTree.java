package impl;


public class LcaBinarySearchTree {

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left, right;
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

    private static <T extends Comparable<T>> Node<T> insert(Node<T> root, T value) {
        Node<T> node = new Node<>(value);
        if(root != null) {
            if (root.data.compareTo(value) > 0) {
                root.left = (root.left == null) ? node : insert(root.left, value);
            }
            else {
                root.right = (root.right == null) ? node : insert(root.right, value);
            }
        }
        else
            root = node;
        return root;
    }

    private static <T extends Comparable<T>> Node<T> lca(Node<T> node, T a, T b) {
        if (node == null)
            return null;
        else if (node.data.compareTo(a) > 0 && node.data.compareTo(b) > 0)
            return lca(node.left, a, b);
        else if (node.data.compareTo(a) < 0 && node.data.compareTo(b) < 0)
            return lca(node.right, a, b);
        return node;
    }

    private static <T extends Comparable<T>> Node<T> ilca(Node<T> node, T a, T b) {
        while (node != null) {
            if (node.data.compareTo(a) > 0 && node.data.compareTo(b) > 0)
                node = node.left;
            else if (node.data.compareTo(a) < 0 && node.data.compareTo(b) < 0)
                node = node.right;
            else
                break;
        }
        return node;
    }

    private static <T extends Comparable<T>> void print(Node<T> node) {
        System.out.printf(" %s", node);
    }

    private static <T extends Comparable<T>> void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            print(node);
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Integer [][] set = {
            {5, 8, 3, 4, 2, 9, 7}
            ,{20, 8, 22, 4, 12, 10, 14}
            , {2, 1, 3, 4, 5, 6}
            , {4, 2, 3, 1, 7, 6}
        };
        Node root = null;
        for (Integer s : set[3]) {
            root = insert(root, s);
        }
        inorder(root);
        System.out.println("");
        System.out.println(lca(root, 2, 1));
        System.out.println(lca(root, 1, 2));
        System.out.println(lca(root, 1, 6));
        System.out.println(lca(root, 1, 3));
        System.out.println(lca(root, 6, 3));
        System.out.println(ilca(root, 6, 3));
        System.out.println(ilca(root, 1, 3));
        inorder(root);
    }
}
