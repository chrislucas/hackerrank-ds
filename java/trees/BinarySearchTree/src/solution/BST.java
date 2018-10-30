package solution;

public class BST {

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
            return String.format("Value: %s", data);
        }
    }

    private static<T extends Comparable<T>> void preorder(Node<T> node) {
        if (node != null) {
            print(node);
            preorder(node.left);
            preorder(node.right);
        }
    }
    private static<T extends Comparable<T>> void postorder(Node<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            print(node);
        }
    }
    private static<T extends Comparable<T>> void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            print(node);
            inorder(node.right);
        }
    }

    private static <T extends Comparable<T>> void print(Node<T> node) {
        System.out.printf(" %s", node.data);
    }

    private static Node root;

    private static <T extends Comparable<T>> void insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null) {
            root = node;
        }
        else {
            insert(root, node);
        }
    }

    private static <T extends Comparable<T>> void insert(Node<T> root, Node<T> child) {
        if (root.data.compareTo(child.data) > 0) {
            if (root.left == null)
                root.left = child;
            else
                insert(root.left, child);
        }
        else {
            if (root.right == null)
                root.right = child;
            else
                insert(root.right, child);
        }
    }

    private static <T extends Comparable<T>> boolean search(Node<T> root, T value) {
        if (root == null) {
            return false;
        }
        else {
            int cmp = root.data.compareTo(value);
            // se o valor procurado for maior que o valor na raiz, va pelo no direita, senao pelo esquerda
            return  cmp == 0 || search(cmp > 0 ? root.left : root.right, value);
        }
    }

    private static <T extends Comparable<T>> Node<T> delete(Node<T> root, T value) {
        if (root == null) {
            return root;
        }
        else {
            int cmp = root.data.compareTo(value);
            if (cmp == 0) {
                Node<T> left = root.left;
                Node<T> right = root.right;
                if (left != null && right != null) {
                    Node<T> minNode = root.right;
                    // recuperar o 'inorder successor' o menor valor do lado direito
                    while (minNode.left != null) {
                        minNode = minNode.left;
                    }
                    root.data = minNode.data;
                    root.right = delete(root.right, minNode.data);
                }
                else {
                    return left == null ? right : left;
                }
            }
            else {
                if (cmp > 0)
                    root.left = delete(root.left, value);
                else
                    root.right = delete(root.right, value);
            }
        }
        return root;
    }


    /**
     * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
     * */
    public static <T extends Comparable<T>> int height(Node<T> root) {
        if (root == null)
            return 0;
        return  1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Integer [][] set = {
                {10, 20, 30, 15, 12, -15, 35, 30}
                ,{50, 30, 20, 40, 70, 60, 80}
                ,{50, 30, 20, 40, 70, 60, 80, 10}
                ,{5, 3, 6, 2, 4, 7}
                ,{5, 3, 6, 2, 4}
        };
        for (Integer s : set[4]) {
            insert(s);
        }
        System.out.printf("Altura: %d\n", height(root));

        System.out.println(search(root, 20));
        System.out.println("Inorder");
        inorder(root);
        System.out.println("");
        System.out.println("Preorder");
        preorder(root);
        System.out.println("");
        System.out.println("Postorder");
        postorder(root);
        System.out.println("");

        Node newRoot = delete(root, 50); // 30 para o set[2]
        System.out.println("");
        preorder(newRoot);
        System.out.println("");
    }
}
