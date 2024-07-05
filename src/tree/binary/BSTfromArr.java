package tree.binary;

import java.util.Scanner;

public class BSTfromArr {

    static class TreeNode {

        public int data;
        public TreeNode left;
        public TreeNode right;

        TreeNode (int data){
            this.data = data;
        }
    }

    static TreeNode createMinimalBST(int[] a, int n) {
        return createMinimalBST(a, 0, n-1);
    }

    static TreeNode createMinimalBST(int[] a, int start, int end) {

        if (end < start)
            return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(a[mid]);
        n.left = createMinimalBST(a, start, mid - 1);
        n.right = createMinimalBST(a, mid + 1, end);
        return n;
    }

    public static void inOrderTraversal(TreeNode root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(" "+root.data);
        inOrderTraversal(root.right);
    }

    static boolean isEmpty(TreeNode root){
        return root == null;
    }

    static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] a = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = scanner.nextInt();

        TreeNode root = createMinimalBST(a, N);
        System.out.println("Successfully created BST!");

        System.out.println("Inorder traversal BST!");
        if(!isEmpty(root)){
            inOrderTraversal(root);
        }
    }

}
