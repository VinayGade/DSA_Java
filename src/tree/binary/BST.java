package tree.binary;

public class BST {
    public static void main(String[] args) {
        int [] values = {5,1 ,3, 4, 2, 7, 10, 12, 15, 20};

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = null;

        for(int i:values){
            root = bst.insert(root, i);
        }

        System.out.println("\nDisplay Tree inorder :");
        bst.inOrderTraversal(root);

        System.out.println("\nSearch 5 in Tree :");
        String result = bst.search(root, 5) ? "FOUND" : "NOT FOUND";
        System.out.println(result);


        System.out.println("\nBefore Delete : Display Tree inorder :");
        bst.inOrderTraversal(root);

        System.out.println("\nBefore Delete : Display Tree range (4, 15) :");
        bst.printInRange(root, 4, 15);
        System.out.println("\nSum of Tree range (4, 15) ="+bst.rangeSumBST(root, 4, 15));

        System.out.println("\nHeight of BST before deletion="+bst.height(root));

        System.out.println("\nBefore Delete nodes count in BST :"+bst.size(root));

        System.out.println("\nis Balanced BST ="+bst.isBalanced(root));

        System.out.println("\nDelete 15, 7 in Tree :");

        bst.delete(root, 15);
        bst.delete(root, 7);

        System.out.println("\nAfter Delete : Display Tree inorder :");
        bst.inOrderTraversal(root);

        System.out.println("\nAfter Delete nodes count in BST :"+bst.size(root));

        System.out.println("\nAfter Delete : Display Tree range (4, 15) :");
        bst.printInRange(root, 4, 15);
        System.out.println("\nSum of Tree range (4, 15) ="+bst.rangeSumBST(root, 4, 15));

        System.out.println("\nDisplay Tree range (6, 18) :");
        bst.printInRange(root, 6, 18);
        System.out.println("\nSum of Tree range (4, 15) ="+bst.rangeSumBST(root, 6, 18));

        System.out.println("\nHeight of BST after deletion="+bst.height(root));
        System.out.println("\nis Balanced BST ="+bst.isBalanced(root));

        System.out.println("\nLeftmost Leaf of BST ="+bst.leftMostLeaf(root).data);

        System.out.println("\nRightmost Leaf of BST ="+bst.rightMostLeaf(root).data);
    }
}
