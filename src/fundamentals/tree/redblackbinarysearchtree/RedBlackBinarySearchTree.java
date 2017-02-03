package fundamentals.tree.redblackbinarysearchtree;


public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> {
  private Node root;
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private class Node {
    Key key;
    Value value;
    Node left, right;
    int N;
    boolean color;

    public Node(Key key, Value value, int n, boolean color) {
      this.key = key;
      this.value = value;
      N = n;
      this.color = color;
    }
  }

  private boolean isRed(Node node) {
    if (node == null) {
      return false;
    }
    return node.color == RED;
  }

  private int size() {
    return 0;
  }

  private int size(Node node) {
    if (node == null) {
      return 0;
    }
    return node.N;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value, 1, RED);
    }
    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else if (cmp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    if (isRed(node.right) && !isRed(node.left)) {
      node = rotateLeft(node);
    }
    if (isRed(node.left) && isRed(node.left.left)) {
      node = rotateRight(node);
    }
    if (isRed(node.left) && isRed(node.right)) {
      flipColors(node);
    }
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  private Node rotateLeft(Node node) {
    Node x = node.right;
    node.right = x.left;
    x.left = node;
    x.color = node.color;
    node.color = RED;
    x.N = node.N;
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  private Node rotateRight(Node node) {
    Node x = node.left;
    node.left = x.right;
    x.right = node;
    x.color = node.color;
    node.color = RED;
    x.N = node.N;
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  private void flipColors(Node node) {
    node.left.color = BLACK;
    node.right.color = BLACK;
    node.color = RED;
  }

}
