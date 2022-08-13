package BinaryTree;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    public void put(Key key, Value value) {
        this.root = put(key, value, this.root);
    }

    private Node<Key, Value> put(Key key, Value value, Node<Key, Value> root) {
        if (root == null) {
            return new Node<Key, Value>(key, value, 1);
        }
        int comparing = key.compareTo(root.getKey());
        if (comparing < 0) {
            Node<Key, Value> leftNode = this.put(key, value, root.getLeft());
            root.setLeft(leftNode);
        } else if (comparing > 0) {
            Node<Key, Value> rightNode = this.put(key, value, root.getRight());
            root.setRight(rightNode);
        } else {
            root.setValue(value);
        }
        return root;
    }

    public Value get(Key key) {
        return this.get(key, this.root);
    }

    private Value get(Key key, Node<Key, Value> root) {
        if (root == null) {
            return null;
        }
        int comparing = key.compareTo(root.getKey());
        if (comparing < 0) {
            return this.get(key, root.getLeft());
        } else if (comparing > 0) {
            return this.get(key, root.getRight());
        } else {
            return root.getValue();
        }
    }

    public int size() {
        return this.size(this.root);
    }

    private int size(Node<Key, Value> added) {
        if (added == null) {
            return 0;
        } else {
            return 1 + size(added.getLeft()) + size(added.getRight());
        }
    }

    public Key select(int rank) {
        return select(rank, this.root);
    }

    private Key select(int rank, Node<Key, Value> selector) {
        if (selector == null) {
            return null;
        }
        int leftSize = size(selector.getLeft());
        if (leftSize == rank) {
            return selector.getKey();
        } else if (leftSize > rank) {
            return select(rank, selector.getLeft());
        } else {
            return select(rank - leftSize - 1, selector.getRight());
        }
    }

    public Key min() {
        Node<Key, Value> min = this.min(this.root);
        return min.getKey();
    }

    private Node<Key, Value> min(Node<Key, Value> minimum) {
        if (minimum == null) {
            return null;
        } else if (minimum.getLeft() == null) {
            return minimum;
        }
        return this.min(minimum.getLeft());
    }

    public Key max() {
        Node<Key, Value> max = this.max(this.root);
        return max.getKey();
    }

    private Node<Key, Value> max(Node<Key, Value> maximum) {
        if (maximum == null) {
            return null;
        } else if (maximum.getRight() == null) {
            return maximum;
        }
        return this.max(maximum.getRight());
    }

    private Node<Key, Value> deleteMin(Node<Key, Value> valueToBeDeleted) {
        if (valueToBeDeleted == null) {
            return null;
        }
        boolean minNode = valueToBeDeleted.getLeft() == null;
        if (minNode) {
            return valueToBeDeleted.getRight();
        }
        Node<Key, Value> newSubTree = deleteMin(valueToBeDeleted.getLeft());
        valueToBeDeleted.setLeft(newSubTree);

        int newSize = (size(valueToBeDeleted.getLeft()) + size(valueToBeDeleted.getRight())) - 1;
        valueToBeDeleted.setSize(newSize);
        return valueToBeDeleted;
    }

    public void delete(Key key) {
        this.root = delete(this.root, key);
    }

    private Node<Key, Value> delete(Node<Key, Value> fromRoot, Key key) {
        if (fromRoot == null) {
            return null;
        }
        int comparing = key.compareTo(fromRoot.getKey());
        if (comparing < 0) {
            fromRoot.setLeft(delete(fromRoot.getLeft(), key));
        } else if (comparing > 0) {
            fromRoot.setRight(delete(fromRoot.getRight(), key));
        } else {
            if (fromRoot.getLeft() == null) {
                return fromRoot.getRight();
            } else if (fromRoot.getRight() == null) {
                return fromRoot.getLeft();
            }
            Node<Key, Value> nodeToDelete = fromRoot;
            fromRoot = min(nodeToDelete.getRight());
            fromRoot.setRight(deleteMin(nodeToDelete.getRight()));
            fromRoot.setLeft(nodeToDelete.getLeft());
        }
        return fromRoot;
    }

    public Node<Key, Value> getRoot() {
        return this.root;
    }
}
