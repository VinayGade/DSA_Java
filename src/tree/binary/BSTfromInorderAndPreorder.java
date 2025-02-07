package tree.binary;

import java.util.*;

/* LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal */

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal
of a binary tree and inorder is the inorder traversal of the same tree, construct and
return the binary tree.

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
* */
public class BSTfromInorderAndPreorder {

    TreeNode buildTree(int inorder[], int preorder[]) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return splitTree(preorder, inorderIndexMap, 0, 0, inorder.length-1);
    }

    TreeNode splitTree(int[] preorder, Map<Integer, Integer> map, int rootIndex, int left, int right){

        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = map.get(preorder[rootIndex]);

        if(mid>left)
            root.left = splitTree(preorder, map, rootIndex+1, left, mid-1);
        if(mid<right)
            root.right = splitTree(preorder, map, rootIndex+mid-left+1, mid+1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BSTfromInorderAndPreorder constructTree = new BSTfromInorderAndPreorder();

        TreeNode root = constructTree.buildTree(inorder, preorder);
        System.out.println("Tree Root = "+root.data);
    }
}
