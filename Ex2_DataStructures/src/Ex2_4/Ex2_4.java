package Ex2_4;

import static java.lang.Integer.valueOf;

public class Ex2_4 {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(new Node(6));
        Node root = bt.getRoot();
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(9);
        root.right.right = new Node(11);
        root.right.left = new Node(7);
        root.right.left.left = new Node(13);
        String path = maxSumPath(bt);
        System.out.println("max sum path = "+path);

    }

    public static String maxSumPath(BinaryTree tree) {
        Result result = findMaxSumPath(tree.getRoot());
        return result.maxSum + "\nmax sum path = " + result.maxPath;
    }

    private static class Result {
        int maxSum;
        String maxPath;

        Result(int maxSum, String maxPath) {
            this.maxSum = maxSum;
            this.maxPath = maxPath;
        }
    }

    private static Result findMaxSumPath(Node node) {
        if (node == null) {
            return new Result(0, "");
        }

        Result leftResult = findMaxSumPath(node.getLeft());
        Result rightResult = findMaxSumPath(node.getRight());

        int maxChildSum = Math.max(leftResult.maxSum, rightResult.maxSum);
        int currentSum = maxChildSum + node.getData();

        String currentPath = "";
        if (leftResult.maxSum > rightResult.maxSum) {
            currentPath = "L" + leftResult.maxPath;
        } else {
            currentPath = "R" + rightResult.maxPath;
        }

        return new Result(currentSum, currentPath);
    }

}
