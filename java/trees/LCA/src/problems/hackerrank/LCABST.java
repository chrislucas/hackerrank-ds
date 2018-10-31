package problems.hackerrank;

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
 * DONE
 * */

public class LCABST {

    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
    /**
     * Solucao implementada diretamente no editor do site
     * */

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        while(root != null) {
            int data = root.data;
            if (data > v1 && data > v2)
                root = root.left;
            else if (data < v1 && data < v2)
                root = root.right;
            else
                break;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
