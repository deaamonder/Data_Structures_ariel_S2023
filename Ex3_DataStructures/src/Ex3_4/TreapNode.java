package Ex3_4;

public class TreapNode {
        int key; // מפתח
        int priority; // עדיפות
        TreapNode left; // ילד שמאלי
        TreapNode right; // ילד ימני

        // constructor
        public TreapNode(int key,int priority) {
            this.key = key;
            this.priority = priority; // עדיפות אקראית
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return "(" + key + ", " + priority + ")";
        }

}
