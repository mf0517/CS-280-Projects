package assignments.datastructures;

import java.util.Iterator;
import java.util.Vector;

import adt.Queue;
import adt.Tree;

/// A data structure where data is organized into a mathematical tree structure,
///  comprised of nodes which have at most two children.
/// 
/// The binary search tree satisfies the binary search tree condition:
///  every node has a value greater than that of its less child,
///  and less than or equal to that of its right child.
/// 
/// @param <T> the type of each element, which must have a natural ordering
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node root;

    /**
     * Initialize an empty tree.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Manually construct a tree so we can test iterator methods.
     * 
     * NOTE: You will remove this method once we've learned how to add.
     * 
     * a specific sequence of numbers defined in the main method
    /**
     * Compute the number of items in this tree.
     * @return the number of items
     */
    public int length() {
        return length(this.root);
        // TODO (Hint: use recursion.)
    }
    private int length(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1 + length(root.left) + length(root.right);
    }
    
    /**
     * Compute the degree of the tree, i.e. the largest number of children any single node has.
     * @return the degree of the tree
     */
    public int degree() {
        // TODO (Hint: use recursion.)
        return degree(this.root);
    }
    private int degree(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int currDegree = 0;
        if(root.left != null && root.right != null)
        {
            currDegree = 2;
        }
        else if(root.left != null || root.right != null)
        {
            currDegree = 1;
        }
        int leftDeg = degree(root.left);
        int rightDeg = degree(root.right);

        return Math.max(currDegree, Math.max(leftDeg, rightDeg));
    }
    
    /**
     * Compute the height of the tree, i.e. the longest path to descend from the root to a leaf.
     * @return the height of the tree
     */
    public int height() {
        // TODO (Hint: use recursion.)
        return height(this.root);
    }
    private int height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));

    }
    
    /**
     * Perform a pre-order traversal of the tree.
     * @return an iterator
     */
    public Iterator<T> preorder() {
        // TODO (Hint: use recursion.
        Vector<T> vector = new Vector<>();
        preorder(this.root,vector);

        return vector.iterator();

    }
    private void preorder(Node root, Vector<T> vector)
    {
        if(root == null)
        {
            return;
        }
        vector.add(root.data);
        preorder(root.left, vector);
        preorder(root.right, vector);

    }
    
    /**
     * Perform an in-order traversal of the tree.
     * @return an iterator
     */
    public Iterator<T> inorder() {
        // TODO (Hint: use recursion.)
        Vector<T> vector = new Vector<>();
        inorder(this.root, vector);
        return vector.iterator();

    }
    private void inorder(Node root, Vector<T> vector)
    {
        if(root == null){
            return;
        }
        inorder(root.left, vector);
        vector.add(root.data);
        inorder(root.right,vector);
    }
    /**
     * Perform a post-order traversal of the tree.
     * @return an iterator
     */
    public Iterator<T> postorder() {
        // TODO (Hint: use recursion.)
        Vector<T> vector = new Vector<>();

        postorder(this.root, vector);
        return vector.iterator();

    }

    private void postorder(Node root, Vector<T> vector)
        {
        if(root == null)
        {
            return;
        }
        postorder(root.left, vector);
        postorder(root.right,vector);
        vector.add(root.data);
    }
    
    /**
     * Perform a level order traversal of the tree.
     * @return an iterator
     */
    public Iterator<T> levelorder() {
        // TODO (Hint: don't use recursion.)
        Vector<T> vector = new Vector<>();
        if(root == null)
        {
            return vector.iterator();
        }

        Queue<Node> queue = new CircularLinkedList<>();
        queue.enqueue(root);

        while(!queue.isEmpty())
        {
            Node currentNode = queue.dequeue();

            vector.add(currentNode.data);

            if(currentNode.left != null)
            {
                queue.enqueue(currentNode.left);
            }
            if(currentNode.right != null)
            {
                queue.enqueue(currentNode.right);
            }
            
        }
        return vector.iterator();
    }
    
    /**
     * Iterate over all elements in-order.
     * @return an iterator
     */
    public Iterator<T> iterator() {
        return this.inorder();
    }

    // NOTE: You're going to add more public methods here on the second day of trees.
    public boolean add(T value)
    {
        if(root == null)
        {
            root = new Node(value);
            return true;
        }
        return add(root,value);
    }

    private boolean add(Node node, T value)
    {
        int comparison = value.compareTo(node.data);

        if(comparison < 0)
        {
            if(node.left == null)
            {
                node.left = new Node(value);
                return true;
            }
            else
        {
            return add(node.left,value);
        }
        }
        else
        {
            if(node.right == null)
            {
                node.right = new Node(value);
                return true;
            }
            else
            {
                return add(node.right, value);
            }
        }
    }

    public boolean remove(T value)
    {
        if(!contains(value))
        {
            return false;
        }
        root = remove(root,value);
        return true;
    }
   private Node remove(Node rootNode, T value) {
    if (rootNode == null) {
        return null;
    }
    int comparison = value.compareTo(rootNode.data);

    if (comparison < 0) {
        rootNode.left = remove(rootNode.left, value);
        return rootNode;
    } else if (comparison > 0) {
        rootNode.right = remove(rootNode.right, value);
        return rootNode;
    } else {
        // comparison == 0: found the node to delete
        if (rootNode.left == null) {
            return rootNode.right;
        }
        if (rootNode.right == null) {
            return rootNode.left;
        }
        Node succ = rootNode.right;
        while (succ.left != null) {
            succ = succ.left;
        }
        rootNode.data = succ.data;
        rootNode.right = remove(rootNode.right, succ.data);
        return rootNode;
    }
}

    public boolean contains(T value)
    {
        return this.contains(root,value);
    }
    private boolean contains(Node node, T value)
    {
        if(node == null)
        {
            return false;
        }
        if(node.data.equals(value))
        {
            return true;
        }
        if(value.compareTo(node.data) < 0)
        {
            return contains(node.left,value);
        }
        else
        {
            return contains(node.right,value);
        }
    }
    
    /**
     * An encapsulation of a value with two pointers, suitable for a binary tree.
     */
    private class Node {
        T data;
        Node left;      // Left child.
        Node right;     // Right child.

        /**
         * Initialize a node with no children.
         * @param data the data value
         */
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Run validation tests.
     * @param args command-line args
     */
    public static void main(String[] args) {
        Tree.validate(new BinarySearchTree<>());

        // Build a sample tree.
        Integer[] numbers = {4, -4, -6, 0, -6, -3, -5, 5, -6, 0, -3, -4, 3, -3, -5};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
         // NOTE: To be replaced once we learn how to add.
        for(Integer n:numbers)
        {
            tree.add(n);
        }
        // Check structure.
        assert tree.length() == 15;
        assert tree.degree() == 2;
        assert tree.height() == 6;

        // Check traversals.
        assert testTraversal(tree.preorder(),   new int[]{4, -4, -6, -6, -5, -6, -5, 0, -3, -4, -3, -3, 0, 3, 5});
        assert testTraversal(tree.inorder(),    new int[]{-6, -6, -6, -5, -5, -4, -4, -3, -3, -3, 0, 0, 3, 4, 5});
        assert testTraversal(tree.postorder(),  new int[]{-6, -5, -5, -6, -6, -4, -3, -3, -3, 3, 0, 0, -4, 5, 4});
        assert testTraversal(tree.levelorder(), new int[]{4, -4, 5, -6, 0, -6, -3, 0, -5, -4, -3, 3, -6, -5, -3});
        assert testTraversal(tree.iterator(),   new int[]{-6, -6, -6, -5, -5, -4, -4, -3, -3, -3, 0, 0, 3, 4, 5});

        System.out.println("BinarySearchTree passes all tests.");
    }

    /**
     * Convenience method to test tree traversals.
     * @param iterator newly-constructed iterator
     * @param array expected values
     */
    private static boolean testTraversal(Iterator<Integer> iterator, int[] array) {
        boolean expected = true;
        for (int i = 0; i < array.length; i ++) {
            Integer next = iterator.next();
            expected = expected && next.equals(array[i]);
        }
        return expected && !iterator.hasNext();
    }
}