class BST
{
    int val;
    BST left;
    BST right;
    BST() {}
    BST(int val) { this.val = val; }
    BST(int val, BST left, BST right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class CompletenessBST958 {
    public static int nodes = 0;
    public static boolean isCompleteTree(BST root) {
        if (root == null) {
            return true;
        }
        return getIdOfLastNode(root, 1) == nodes;
    }

    private static int getIdOfLastNode(BST root, int id) {
        if(root == null)
            return -1;
        nodes++;
        int left = getIdOfLastNode(root.left, 2 * id);
        int right = getIdOfLastNode(root.right, 2 * id + 1);

        return Math.max(id, Math.max(left, right));
    }

    public static void main(String[] args) {
        BST root = new BST(1);
        root.left = new BST(2);
        root.right = new BST(3);
        root.left.left = new BST(4);
        root.left.right = new BST(5);
        root.right.right = new BST(6);
        isCompleteTree(root);
    }
}
