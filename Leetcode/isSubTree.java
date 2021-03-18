import java.util.*;
class isSubTree {
    boolean ans=false;
    public boolean isEquals(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val) return false;
        return isEquals(s.left, t.left) && isEquals(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null) return true;
        if(s==null) return false;
        isSubtree(s.left, t);
        isSubtree(s.right, t);
        ans=ans || isEquals(s, t);
        return ans;
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        HashSet < String > trees = new HashSet < > ();
        public boolean isSubtree(TreeNode s, TreeNode t) {
            String tree1 = preorder(s, true);
            String tree2 = preorder(t, true);
            return tree1.indexOf(tree2) >= 0;
        }
        public String preorder(TreeNode t, boolean left) {
            if (t == null) {
                if (left)
                    return "lnull";
                else
                    return "rnull";
            }
            return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
        }
    }
}