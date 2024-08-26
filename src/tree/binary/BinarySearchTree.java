package tree.binary;

import java.util.*;
import java.util.stream.Collectors;

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

    public boolean isEmpty(TreeNode root){
        return root == null;
    }
    
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public int countChildren(TreeNode node) {
        if(isLeaf(node))
            return 0;
        else if(node.left != null && node.right != null)
            return 2;
        else
            return 1;
    }

    public Set<TreeNode> children(TreeNode node){
        Set<TreeNode> childNodes= new LinkedHashSet<>();  // maintain order ... leftChild, rightChild
        if(!isLeaf(node)){
            if(node.left != null)
                childNodes.add(node.left);
            if(node.right != null)
                childNodes.add(node.right);
        }
        return childNodes;
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

    // insert TreeNode solution by GFG
    TreeNode insertNode(TreeNode root, int key) {

        if(root == null){
            root = new TreeNode(key);
            return root;
        }
        if(key < root.data)
            root.left =  insertNode(root.left, key);
        else if(key > root.data)
            root.right =  insertNode(root.right, key);

        return root;
    }

    // TODO: insert node in an iterative way.

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

    // TODO: define method to delete node in iterative way.

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

    public TreeNode largest(TreeNode root){   // right most leaf node
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

    // printInRange GFG solution
    public static ArrayList<Integer> printNearNodes(TreeNode root, int low, int high){

        ArrayList<Integer> range = new ArrayList<Integer>();
        inorderRange(root, low, high, range);
        return range;
    }

    static void inorderRange(TreeNode root,int low,int high, ArrayList<Integer> range){
        if(root==null)
            return;

        inorderRange(root.left,low,high, range);

        if(root.data>=low && root.data<=high)
            range.add(root.data);

        inorderRange(root.right, low, high, range);
    }

    public int rangeSumBST(TreeNode root, int x, int y) {

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

    //optimized way to check BST is balanced
    public boolean isBalancedOptimized(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public int checkHeight(TreeNode root){
        if(root == null)
            return -1;
        int leftHeight = checkHeight(root.left);

        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);

        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        return (Math.abs(heightDiff) > 1)
                ? Integer.MIN_VALUE
                : Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(isLeaf(root) && subRoot.data == root.data)
            return true;
        else{
            List<Integer> inorder = inorderTraversal(root);
            if(isLeaf(subRoot))
                return inorder.contains(subRoot.data);
            else{
                List<Integer> inorderSubtree = inorderTraversal(subRoot);
                return inorder.containsAll(inorderSubtree);
            }
        }
    }

    int findSubtree(TreeNode s, TreeNode t) {
        return isSubTree(s, t) ? 1 : 0;
    }

    // LeetCode 572. Subtree of Another Tree
    boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSame(s, t))
            return true;
        return isSubTree(s.left, t) || isSubTree(s.right, t);
    }

    // LeetCode 100. Same Tree
    boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.data != t.data)
            return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
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

    // LeetCode 98. Validate Binary Search Tree
    public boolean checkBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    boolean checkBST(TreeNode n, Integer min, Integer max){
        if(n == null)
            return true;

        if((min != null && n.data<=min) || (max != null && n.data>=max))
            return false;

        return checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max);
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

    //Function to find the lowest common ancestor in a BST.
    TreeNode LCA(TreeNode root, int n1, int n2) {

        if(n1 < root.data && n2 < root.data)
            return LCA(root.left, n1, n2);

        else if(n1 > root.data && n2 > root.data)
            return LCA(root.right, n1, n2);

        else
            return root;

    }

    //First Common Ancestor
    /*
    First Common Ancestor of given 2 nodes
    * */
    TreeNode FCA(TreeNode root, TreeNode p, TreeNode q){
        int delta = depth(root, p) - depth(root, q);          // difference in depth
        TreeNode first = delta > 0 ? q : p;       // shallower node
        TreeNode second = delta > 0 ? p : q;      // deeper node
        second = goUpBy(root, second, Math.abs(delta)); // move deeper node up

        //find where paths intersect.
        while(first != second && first != null && second != null){
            first = findParent(root, first);
            second = findParent(root, second);
        }
        return (first == null || second == null) ? null : first;
    }

    TreeNode goUpBy(TreeNode root, TreeNode node, int delta){
        while(delta > 0 && node != null){
            node = findParent(root, node);
            delta--;
        }
        return node;
    }

    int depth(TreeNode root, TreeNode node){
        int depth = 0;
        while(node != null){
            node = findParent(root, node);
            depth++;
        }
        return depth;
    }

    boolean covers(TreeNode root, TreeNode node){
        if(root == null)
            return false;
        if(root == node)
            return true;
        return covers(root.left, node) || covers(root.right, node);
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(!covers(root, p) || !covers(root, q))
            return null;
        else if(covers(p, q))
            return p;
        else if(covers(q, p))
            return q;

        // Traverse upwards until you find a node that covers q.
        TreeNode sibling = getSibling(root, p);
        TreeNode parent = findParent(root, p);

        while(!covers(sibling, q)){
            sibling = getSibling(root, parent);
            parent = findParent(root, parent);
        }
        return parent;
    }

    // Approach 3: Without parent
    TreeNode commonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q){
        if(!covers(root, p) || !covers(root, q))
            return null;
        return ancestorHelper(root, p, q);
    }

    TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q)
            return root;

        boolean leftP = covers(root, p);
        boolean leftQ = covers(root, q);

        if(leftP != leftQ)
            return root;

        TreeNode child = leftP ? root.left : root.right;
        return ancestorHelper(child, p, q);
    }

    // next node of the given node in inorder path of BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode n){
        if(n == null)
            return null;

        /*
        * found right child
        * return leftmost (smallest) node of right subtree
        * */

        if(n.right != null)
            return smallest(n.right);
            //return leftMostLeaf(n.right);

        else{
            TreeNode q = n;
            TreeNode x = findParent(root, q);

            // Go up until we're on left instead of right
            while(x != null && x.left != q){
                q = x;
                x = findParent(root, x);
            }
            return x;
        }
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
            TreeNode parent = findParent(root.right, child);
            if(parent == null)
                parent = findParent(root.left, child);
            return parent;
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

    TreeNode getSibling(TreeNode root, TreeNode node){
        TreeNode parent = findParent(root, node);
        if(node == null || parent == null)
            return null;
        return parent.left == node ? parent.right : parent.left;
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

    public void levelOrderPath(TreeNode root){

        if(root != null && isLeaf(root))
            System.out.print(root.data);

        List<Integer> path = levelOrderTraversal(root).stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        path.forEach(element -> System.out.print(element+" "));
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

    public List<Queue<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<Queue<TreeNode>> result = new ArrayList<>();

        //visit the root
        Queue<TreeNode> current = new LinkedList<>();
        if(root != null)
            current.add(root);

        while(!current.isEmpty()){
            result.add(current);
            Queue<TreeNode> parents = current;
            current = new LinkedList<>();

            for(TreeNode parent: parents){

                //visit children
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }

    //Optimized BFS (level order traversal using Deque)
    static void levelorder(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.removeFirst();
                System.out.println(node.data + " ");
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }
            System.out.println();
        }
    }

    // Find all ancestors of node in BST
    public static ArrayList<Integer> Ancestors(TreeNode root, int target) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        findAncestors(root, target, ancestors);
        return ancestors;
    }

    static boolean findAncestors(TreeNode node, int target, ArrayList<Integer> ancestors) {
        if (node == null)
            return false;

        if (node.data == target)
            return true;

        if (findAncestors(node.left, target, ancestors) || findAncestors(node.right, target, ancestors)) {
            ancestors.add(node.data);
            return true;
        }

        return false;
    }

    // LeetCode 543: Diameter of Binary Tree
    /*
    * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    * This path may or may not pass through the root.
    * */
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        Stack<TreeNode> visited = new Stack<>();
        int diameter = 0;

        if(root!=null)
            visited.push(root);

        while(!visited.isEmpty()){

            TreeNode node = visited.peek();

            if(node.left!=null && !depthMap.containsKey(node.left))
                visited.push(node.left);
            if(node.right!=null && !depthMap.containsKey(node.right))
                visited.push(node.right);

            visited.pop();
            int leftDepth = depthMap.getOrDefault(node.left, 0);
            int rightDepth = depthMap.getOrDefault(node.right, 0);

            depthMap.put(node, 1 + Math.max(leftDepth, rightDepth));
            diameter = Math.max(diameter, leftDepth + rightDepth);
        }
        return diameter;
    }

    //LeetCode 113. Path Sum II
    /*
    Given the root of a binary tree and an integer targetSum, return all root-to-leaf
    paths where the sum of the node values in the path equals targetSum.
    Each path should be returned as a list of the node values, not node references.
    * */
    public List<List<Integer>> pathSumII(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumII(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    void pathSumII(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root == null)
            return;
        path.add(root.data);
        if(root.left == null && root.right == null && root.data == sum)
            result.add(path);

        pathSumII(root.left, sum-root.data, new ArrayList<>(path), result);
        pathSumII(root.right, sum-root.data, new ArrayList<>(path), result);
    }

    //Optimized approach
    void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root == null)
            return;
        path.add(root.data);
        if(root.left == null && root.right == null && root.data == sum)
            result.add(new ArrayList<>(path));

        pathSum(root.left, sum-root.data, path, result);
        pathSum(root.right, sum-root.data, path, result);
        path.remove(path.size()-1);
    }

    // LeetCode 437. Path Sum III

    /*
    Given the root of a binary tree and an integer targetSum, return the number of paths
    where the sum of the values along the path equals targetSum.

    The path does not need to start or end at the root or a leaf, but it must go downwards
    (i.e., traveling only from parent nodes to child nodes).

    Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
    */
    // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
    Map<Long, Integer> hmap;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;
        dfs(root, 0, targetSum);
        return count;
    }

    void dfs(TreeNode root, long prefixSum, int targetSum) {
        // base case
        if (root == null) return;


        prefixSum += root.data;

        // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
        if (hmap.containsKey(prefixSum-targetSum)) {
            count += hmap.get(prefixSum-targetSum);
        }

        // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
        if (targetSum == prefixSum) {
            count++;
        }

        // Update the prefixSum till current node and it's count
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        // Recurse
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // Backtrack
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);

    }

    /*
    LeetCode 112. Path Sum

    Given a binary tree and an integer target, check whether there is a root-to-leaf path with its sum as target.
    * */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        else if(root.data == targetSum && isLeaf(root))
            return true;
        else
            return hasPathSum(root.left, (targetSum - root.data)) ||
                    hasPathSum(root.right, (targetSum - root.data));
    }

    // LeetCode 103. Binary Search Tree Zigzag Level Order Traversal
    List<List<Integer>> zigZagLevelOrder(TreeNode root){

        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null)
            return zigzag;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();

            for(int i=0; i<size; i++){

                TreeNode node = queue.poll();

                // check flag
                if(flag)
                    reverseStack.push(node.data);
                else
                    level.add(node.data);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }
            flag = !flag;

            // Pop all elements from stack
            while(!reverseStack.isEmpty())
                level.add(reverseStack.pop());

            zigzag.add(level);
        }
        return zigzag;
    }

    //using Deque (more efficient approach)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        // use ArrayDeque as a Queue
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // use ArrayDeque as a Linked List
            Deque<Integer> ll = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.removeFirst();
                if (result.size() % 2 == 0)
                    ll.addLast(node.data);
                else
                    ll.addFirst(node.data);
                if (node.left != null)
                    q.addLast(node.left);
                if (node.right != null)
                    q.addLast(node.right);
            }
            result.add(new ArrayList<Integer>(ll));
        }
        return result;
    }

    //Duplicate Subtrees
    public List<TreeNode> printAllDups(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        HashMap<String, Integer> map= new HashMap<>();
        helper(root,list,map);
        return list;
    }

    String helper(TreeNode root, ArrayList<TreeNode> list, HashMap<String,Integer> map){

        if(root==null)
            return "*";

        String data= root.data+" "+helper(root.left,list,map)+" "
                +helper(root.right,list,map);

        map.put(data, map.getOrDefault(data,0)+1);

        if(map.get(data)==2)
            list.add(root);

        return data;
    }

    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(TreeNode root) {
        // code here.
        HashMap<Integer,Integer> tm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        vertical(root,tm,0);

        for(int k : tm.keySet())
        {
            min = Math.min(min,k);
            max = Math.max(max,k);
        }

        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE)
            return 0;
        if(min >= 0)
            return max+1;
        if(max <= 0)
            return (-1)*min+1;

        return max-min+1;
    }

    public void vertical(TreeNode root, HashMap<Integer,Integer> tm, int k)
    {
        if(root == null)
            return;
        tm.put(k,root.data);
        vertical(root.left,tm,k-1);
        vertical(root.right,tm,k+1);
    }

    /*
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {

        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)//root = leaf
            return 1;
        else{

       // vertical width = 1 (for root node) + leftWidth + rightWidth

            return leftWidth(root) + rightWidth(root) + 1;
        }
    }

    // width of left subtree of root
    public int leftWidth(Node root){

        int width = 0;
        Node node = root;
        while(node.left!=null){
            node = node.left;
            width++;
        }
        return width;
    }

    // width of right subtree of root
    public int rightWidth(Node root){

        int width = 0;
        Node node = root;
        while(node.right!=null){
            node = node.right;
            width++;
        }
        return width;
    }
    */

    //Given a binary tree. Find the size of its largest subtree which is a Binary Search Tree.

    int bstSize;
    int largestBst(TreeNode root)
    {
        //if(checkBST(root)){
        if(isBst(root)){
            bstSize = 0;
            return getSize(root);
        }
        return Math.max(largestBst(root.left),largestBst(root.right));
    }

    int getSize(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+getSize(root.left)+getSize(root.right);
    }

    // Another approach to find if tree is valid BST
    boolean isBst(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left!=null && maxValue(root.left)>=root.data){
            return false;
        }
        if(root.right!=null && minValue(root.right)<=root.data){
            return false;
        }
        return isBst(root.left) && isBst(root.right);
    }

    //find max and min value if tree is not BST

    int maxValue(TreeNode root){
        int largest = Integer.MIN_VALUE;
        if(root.left!=null)
            largest = Math.max(largest, maxValue(root.left));

        largest = Math.max(largest, root.data);

        if(root.right!=null)
            largest = Math.max(largest, maxValue(root.right));
        return largest;
    }

    int minValue(TreeNode root){
        int smallest = Integer.MAX_VALUE;
        if(root.left!=null)
            smallest = Math.max(smallest, minValue(root.left));

        smallest = Math.min(smallest, root.data);

        if(root.right!=null)
            smallest = Math.min(smallest, minValue(root.right));
        return smallest;
    }

    // Merge 2 BST into 1 BST

    public List<Integer> merge(TreeNode root1, TreeNode root2) {
        List<Integer> merged = new ArrayList<>();
        List<Integer> list1 = inOrder(root1);
        List<Integer> list2 = inOrder(root2);
        mergeSortedLists(list1, list2, merged);
        return merged;
    }

    private List<Integer> inOrder(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current=stack.pop();
            inorder.add(current.data);
            current = current.right;
        }
        return inorder;
    }

    private void mergeSortedLists(List<Integer> list1, List<Integer> list2, List<Integer> result)
    {
        int i=0;
        int j=0;
        int m = list1.size();
        int n = list2.size();

        while(i<m && j<n){
            int x = list1.get(i);
            int y = list2.get(j);
            if(x <= y){
                result.add(x);
                i++;
            }else{
                result.add(y);
                j++;
            }
        }
        while(i<m){
            result.add(list1.get(i));
            i++;
        }
        while(j<n){
            result.add(list2.get(j));
            j++;
        }
    }

    //returns list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(TreeNode root)
    {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> wq=new LinkedList<>();
        q.add(root);
        wq.add(0);
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,root.data);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            int tw=wq.remove();
            mp.put(tw,temp.data);
            if(temp.left!=null){
                q.add(temp.left);
                wq.add(tw-1);
            }
            if(temp.right!=null){
                q.add(temp.right);
                wq.add(tw+1);
            }
        }
        ArrayList<Integer> key=new ArrayList<>(mp.keySet());
        Collections.sort(key);
        for(int k:key)
            ans.add(mp.get(k));

        return ans;
    }

    /*

    Given a Binary Tree. Check for the Sum Tree for every node except the leaf node.
    Return true if it is a Sum Tree otherwise, return false.

    A SumTree is a Binary Tree where the value of a node is equal to the sum of
    the nodes present in its left subtree and right subtree.
    An empty tree is also a Sum Tree as the sum of an empty tree can be
    considered to be 0. A leaf node is also considered a Sum Tree.

    * */
    boolean isSumTree(TreeNode root) {

        if(root == null || (root.left == null && root.right == null))
            return true;

        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);

        if((leftSum + rightSum) == root.data){
            if(isSumTree(root.left) && isSumTree(root.right))
                return true;
        }
        return false;
    }

    int findSum(TreeNode root){
        if(root == null)
            return 0;
        return root.data + findSum(root.left) + findSum(root.right);
    }

    // LeetCode 872. Leaf-Similar Trees for BST
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        getLeaves(root1, leaf1);
        getLeaves(root2, leaf2);

        return leaf1.equals(leaf2);
    }

    void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root != null) {
            getLeaves(root.left, leaves);
            if (isLeaf(root)) {
                leaves.add(root.data);
            }
            getLeaves(root.right, leaves);
        }
    }

}