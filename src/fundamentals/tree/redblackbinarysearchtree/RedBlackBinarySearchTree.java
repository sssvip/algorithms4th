package fundamentals.tree.redblackbinarysearchtree;


/**
 * The type Red black binary search tree.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> {
  private Node root;
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private class Node {
    /**
     * The Key.
     */
    Key key;
    /**
     * The Value.
     */
    Value value;
    /**
     * The Left.
     */
    Node left, /**
     * The Right.
     */
    right;
    /**
     * The N.
     */
    int N;
    /**
     * The Color.
     */
    boolean color;

    /**
     * Instantiates a new Node.
     *
     * @param key   the key
     * @param value the value
     * @param n     the n
     * @param color the color
     */
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

  /**
   * Put.
   *
   * @param key   the key
   * @param value the value
   */
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
