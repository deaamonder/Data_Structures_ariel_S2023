package Ex3_4;

public class Treap {
    private TreapNode root;

    // constructor
    public Treap() {
        root = null;
    }

    // פעולת הוספה שמכניסה איבר חדש ל-Treap
    public void insert(int key, int priority) {
        root = insertRec(root, key, priority);
    }

    // פעולה רקורסיבית להוספת איבר חדש
    private TreapNode insertRec(TreapNode node, int key, int priority) {
        // אם העץ ריק, יוצר צומת חדש
        if (node == null) {
            return new TreapNode(key, priority);
        }

        // אם המפתח קטן מהמפתח של הצומת הנוכחי, הכנס את הערך לצד שמאל
        if (key < node.priority) {
            node.left = insertRec(node.left, key, priority);
            // בדוק ותקן את הערימה
            if (node.left.priority > node.priority) {
                node = rotateRight(node);
            }
        }
        // אחרת, הכנס את הערך לצד ימין
        else {
            node.right = insertRec(node.right, key, priority);
            // בדוק ותקן את הערימה
            if (node.right.priority > node.priority) {
                node = rotateLeft(node);
            }
        }

        return node;
    }

    // פונקציה לביצוע רוטציה שמאלית
    private TreapNode rotateLeft(TreapNode node) {
        TreapNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    // פונקציה לביצוע רוטציה ימנית
    private TreapNode rotateRight(TreapNode node) {
        TreapNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    // הדפסת ה-Treap בסדר inorder
    public void inorder() {
        inorderRec(root);
    }

    // פעולה רקורסיבית להדפסת ה-Treap בסדר inorder
    private void inorderRec(TreapNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node + " ");
            inorderRec(node.right);
        }
    }

    // פעולה להוספת איבר חדש ל-Treap
    public void insertWithPriority(int key, int priority) {
        root = insertRecWithPriority(root, key, priority);
    }

    // פעולה רקורסיבית להוספת איבר חדש עם עדיפות
    private TreapNode insertRecWithPriority(TreapNode node, int key, int priority) {
        // אם העץ ריק, יוצר צומת חדש
        if (node == null) {
            return new TreapNode(key, priority);
        }

        // אם המפתח קטן מהמפתח של הצומת הנוכחי, הכנס את הערך לצד שמאל
        if (key < node.key) {
            node.left = insertRecWithPriority(node.left, key, priority);
            // בדוק ותקן את הערימה
            if (node.left.priority > node.priority) {
                node = rotateRight(node);
            }
        }
        // אחרת, הכנס את הערך לצד ימין
        else {
            node.right = insertRecWithPriority(node.right, key, priority);
            // בדוק ותקן את הערימה
            if (node.right.priority > node.priority) {
                node = rotateLeft(node);
            }
        }

        return node;
    }
}
