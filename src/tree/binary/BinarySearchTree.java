package tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    /*
    public BinarySearchTree(int data){
        root = new TreeNode(data);
    }
     */

    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public void inOrderTraversal(TreeNode root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(" "+root.data);
        inOrderTraversal(root.right);
    }

    public boolean search(TreeNode root, int key){
        if(root == null)
            return false;

        if(root.data == key)
            return true;
        else if(root.data > key)
            return search(root.left, key);
        else/* if(root.data < key) */
            return search(root.right, key);
    }

    public TreeNode insert(TreeNode root, int data) {

        if(root == null)
            root = new TreeNode(data);

        else if(data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    // insert TreeNode solution by HackerRank
    public static TreeNode insertTreeNode(TreeNode root,int data){
        if(root==null)
            return new TreeNode(data);

        else{
            TreeNode cur;
            if(data<=root.data){
                cur=insertTreeNode(root.left,data);
                root.left=cur;
            }
            else{
                cur=insertTreeNode(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public TreeNode delete(TreeNode root, int key){
        if(key < root.data)
            root.left = delete(root.left, key);

        else if(key > root.data)
            root.right = delete(root.right, key);

        else{  // key == root.data

            // case 1 : leaf node
            if(isLeaf(root))
                return null;

            else{
                //case 2 : single child : left / right

                if(root.left == null)
                    return root.right;

                else if(root.right == null)
                    return root.left;

                else{
                    //case 3 : both children : left + right

                    TreeNode inorderSuccessor = smallest(root.right);
                    root.data = inorderSuccessor.data;
                    delete(root.right, inorderSuccessor.data);

                }
            }
        }
        return root;
    }

    public TreeNode smallest(TreeNode root){   // left most leaf node
        TreeNode node = root;
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

    public TreeNode leftMostLeaf(TreeNode root){   // smallest
        if(root.left == null)
            return root;
        else
            return leftMostLeaf(root.left);
    }

    public TreeNode largest(TreeNode root){   // left most leaf node
        TreeNode node = root;
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }

    public TreeNode rightMostLeaf(TreeNode root){   // largest
        if(root.right == null)
            return root;
        else
            return rightMostLeaf(root.right);
    }

    public void printInRange(TreeNode root, int x, int y) {

        int rangeSum =  0;
        if(root == null)
            return;

        /*
        else if(isLeaf(root))
            System.out.println(" "+root.data);

         */

        else{
            if(root.data >= x && root.data <= y){
                printInRange(root.left, x, y);
                System.out.print(" "+root.data);
                printInRange(root.right, x, y);
            }else if(root.data >= y){  // ... traverse left subtree
                printInRange(root.left, x, y);
            }else {  // root.data <= x   ... traverse right subtree
                printInRange(root.right, x, y);
            }
        }
    }

    public int  rangeSumBST(TreeNode root, int x, int y) {

        int rangeSum = 0;
        if (root != null) {

        /*
        else if(isLeaf(root))
            System.out.println(" "+root.data);

         */

            //else{
            if (root.data >= x && root.data <= y) {
                rangeSum += rangeSumBST(root.left, x, y);
                rangeSum += root.data;
                rangeSum += rangeSumBST(root.right, x, y);
            } else if (root.data >= y) {  // ... traverse left subtree
                rangeSum += rangeSumBST(root.left, x, y);
            } else {  // root.data <= x   ... traverse right subtree
                rangeSum += rangeSumBST(root.right, x, y);
            }
            //}
        }
        return rangeSum;
    }

    public int height(TreeNode root){
        if(root == null)
            return -1;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    public int size(TreeNode root){
        if(root == null)
            return 0;
        else
            return 1 + size(root.left) + size(root.right);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) // empty tree
            return true;
        else
            return (Math.abs(height(root.left) - height(root.right))) < 2
                    && isBalanced(root.left)
                    && isBalanced(root.right);
    }

    public boolean isValidBST(TreeNode root) {

        if(root == null)
            return true;

        List<Integer> inorder = inorderTraversal(root);
        for(int i=0; i< inorder.size()-1;i++){
            if(inorder.get(i)>=inorder.get(i+1)){
                return false;
            }
        }
        return true;
    }

    List<Integer> inorderTraversal(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        if(root != null){
            inorderTraversal(root.left);
            inorder.add(root.data);
            inorderTraversal(root.right);
        }
        return inorder;
    }

    public int parent(TreeNode root, int key){
        TreeNode child = new TreeNode(key);
        TreeNode parent = findParent(root, child);
        return parent!=null ? parent.data : -1;
    }

    public TreeNode findParent(TreeNode root, TreeNode child){
        if(root == null || child == null || isLeaf(root))
            return null;      // since root doesn't have parent. root is parent of entire BST
        else if( (root.right != null && root.right.data == child.data) ||
                (root.left != null && root.left.data == child.data) )
            return root;
        else{
            TreeNode found = findParent(root.right, child);
            if(found == null)
                found = findParent(root.left, child);
            return found;
        }
    }

    public int findSibling(TreeNode root, int key){
        if(root == null || root.data==key || isLeaf(root))
            return -1;    // since root can't have sibling, root is parent of entire BST.
        else{
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;

            if(leftChild != null && leftChild.data == key)
                return (rightChild != null) ? rightChild.data : -1;

            else if(rightChild != null && rightChild.data == key)
                return (leftChild != null) ? leftChild.data : -1;

            //if depth(BST) > 2 ... traverse left and right subtree to find sibling

            int sibling = -1;

            if(key < root.data  && leftChild != null)
                sibling = findSibling(leftChild, key);

            else if(key > root.data && rightChild != null)
                sibling = findSibling(rightChild, key);

            return sibling;
        }
    }

    public void levelOrder(TreeNode root){

        if(root != null && isLeaf(root))
            System.out.print(root.data);
        else{
            List<List<Integer>> result = levelOrderTraversal(root);
            int depth = -1;
            for(List<Integer> level : result){
                depth++;
                System.out.print("\nlevel ["+depth+"] = [ ");
                for(int element : level){
                    System.out.print(element+" ");
                }
                System.out.print("]");
            }
        }
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}