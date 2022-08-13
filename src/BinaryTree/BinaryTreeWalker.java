package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeWalker<Key extends Comparable<Key>, Value> {

    private BinarySearchTree<Key, Value> bst;
    List<Key> list = new ArrayList<Key>();

    public BinaryTreeWalker(BinarySearchTree<Key, Value> bst) {
        this.bst = bst;
    }

    public List<Key> inOrder() {
        return this.inOrder(bst.getRoot());
    }

    private List<Key> inOrder(Node<Key, Value> root) {
        if (root != null) {
            inOrder(root.getLeft());
            list.add(root.getKey());
            inOrder(root.getRight());
        }
        return list;
    }

    public List<Key> breadthFirst() {
        return this.breadthFirst(bst.getRoot());
    }

    private List<Key> breadthFirst(Node<Key, Value> bst) {
        List<Node<Key, Value>> queue = new ArrayList<Node<Key, Value>>();
        queue.add(bst);
        while (!queue.isEmpty()) {
            Node<Key, Value> node = queue.remove(0);
            list.add(node.getKey());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;
    }

    public List<Key> postorder() {
        return this.postorder(bst.getRoot());
    }

    private List<Key> postorder(Node<Key, Value> root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            list.add(root.getKey());
        }
        return list;
    }

    public List<Key> preorder() {
        return this.preorder(bst.getRoot());
    }

    private List<Key> preorder(Node<Key, Value> root) {
        if (root != null) {
            list.add(root.getKey());
            preorder(root.getLeft());
            preorder(root.getRight());
        }
        return list;
    }

}
