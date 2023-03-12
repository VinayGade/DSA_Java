package tree.binary;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(int data){
        root = new TreeNode(data);
    }

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

        if(root.data == key){
            return true;
        } else if(root.data > key){
            return search(root.left, key);
        }else/* if(root.data < key) */{
            return search(root.right, key);
        }

    }

    public TreeNode insert(TreeNode root, int data) {

        if(root == null){
            root = new TreeNode(data);

        }else if(data < root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        return root;
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

        int rangeSum =  0;
        if(root != null) {

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

}
