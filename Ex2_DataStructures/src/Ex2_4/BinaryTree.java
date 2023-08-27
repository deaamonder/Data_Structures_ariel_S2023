package Ex2_4;

public class BinaryTree {
    private final Node root;
    public BinaryTree(Node root) {
        this.root = root;
    }
    public Node getRoot() {
        return root;
    }
    public boolean isLeaf(){
        return this.root.getLeft()==null && this.root.getRight()==null;
    }
}
