package Ex3_3;

public class RBTree {
    public static final boolean BLACK = false;
    public static final boolean RED = true;

    class Node {
        Integer key;
        boolean color;
        Node left, right;

        public Node(Integer data, boolean color) {
            this.key = data;
            this.color = color;
            left = right = null;
        }

        public String toString() {
            String c = "red";
            if (color == BLACK) c = "black";
            return "key: " + key + ", " + c;
        }
    }

    Node root; // root of the RBTree

    public RBTree() {
        root = null;
    }

    // Check if the tree is a valid Red-Black Tree
    public static boolean isValidRadBlackTree(RBTree tree) {
        return isValidRadBlackTreeHelper(tree.root);
    }

    private static boolean isValidRadBlackTreeHelper(Node node) {
        if (node == null) {
            // Empty node is a valid RBTree
            return true;
        }

        // Check for property #1 - The root is black
        if (node != null && node.color == RED) {
            return false;
        }

        // Count the number of black nodes on the left path and right path
        int leftBlackCount = countBlackNodes(node.left);
        int rightBlackCount = countBlackNodes(node.right);

        // Check for property #4 - All simple paths from a node to its descendant
        // leaves contain the same number of black nodes
        if (leftBlackCount != rightBlackCount) {
            return false;
        }

        // Recursively check for all nodes in the tree
        return isValidRadBlackTreeHelper(node.left) && isValidRadBlackTreeHelper(node.right);
    }

    private static int countBlackNodes(Node node) {
        if (node == null) {
            // Empty node has a black height of 0
            return 0;
        }

        // Count the black height from the left child, as all paths should have the same black height
        int leftBlackHeight = countBlackNodes(node.left);

        // Check for property #2 - Every leaf (NIL) is black
        if (node.color == RED && (node.left != null && node.left.color == RED)) {
            return -1; // Red node with a red child
        }

        // Check for property #3 - If a node is red, then both its children are black
        if (node.color == RED && (node.right != null && node.right.color == RED)) {
            return -1; // Red node with a red child
        }

        // Add 1 to the black height if the current node is black
        return leftBlackHeight + (node.color == BLACK ? 1 : 0);
    }
}

