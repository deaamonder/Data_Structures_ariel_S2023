package Ex3_3;

public class Ex3_3 {
    public static void main(String[] args) {
        RBTree tree = new RBTree();
        tree.root = tree.new Node(15, RBTree.BLACK);
        tree.root.left = tree.new Node(10, RBTree.RED);
        tree.root.right = tree.new Node(20, RBTree.RED);

        System.out.println("Is RB tree? " + RBTree.isValidRadBlackTree(tree));
    }
}
