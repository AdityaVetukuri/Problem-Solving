import com.sun.source.tree.Tree;

import java.util.*;
 class TreeNode3 {
     int val;
     TreeNode3 left;
     TreeNode3 right;
     TreeNode3 parent;
     TreeNode3() {}
     TreeNode3(int val) { this.val = val; }
     TreeNode3(int val, TreeNode3 left, TreeNode3 right, TreeNode3 parent) {
         this.val = val;
         this.left = left;
         this.right = right;
         this.parent = parent;
      }
  }
public class BinarySearchTreeIterator173 {

    // A list whose last element is the next smallest
    List<TreeNode3> path = new ArrayList<>();

    public BinarySearchTreeIterator173(TreeNode3 root) {
        DFS(root, path);
    }

    // Find the next smallest element, stop when a node doesn't have left child,
    // and that node has the next smallest element.
    // The length of path is at most the tree height, thus O(h) space.
    public void DFS(TreeNode3 root, List<TreeNode3> path) {
        if (root == null) return;

        path.add(root);

        DFS(root.left, path);
    }

    /** @return the next smallest number */
    // remove the last element, then find the next smallest element in the right sub-tree
    public int next() {
        TreeNode3 node = path.remove(path.size() - 1);
        DFS(node.right, path);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return path.size() > 0;
    }

    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(7);
        root.left = new TreeNode3(3);
        root.right = new TreeNode3(15);
        root.right.left = new TreeNode3(9);
        root.right.right = new TreeNode3(20);
        BinarySearchTreeIterator173 obj = new BinarySearchTreeIterator173(root);
        obj.next();
        obj.next();
        obj.next();

    }
}