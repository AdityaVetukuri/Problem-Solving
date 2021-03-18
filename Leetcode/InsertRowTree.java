
public class InsertRowTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1)
        {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            return temp;
        }
        insert(root,v,d,1);
        return root;
    }
    public void insert(TreeNode node, int v, int d,int count)
    {
        if(node == null)
            return;
        if(d-1 == count)
        {
            TreeNode t = node.left;
            node.left = new TreeNode(v);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(v);
            node.right.right = t;
        }
        else
        {
            insert(node.left,v,d,count+1);
            insert(node.right,v,d,count+1);
        }
    }
}