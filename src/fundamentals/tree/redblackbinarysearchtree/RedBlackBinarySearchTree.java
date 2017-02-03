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

  public void put(Key key, Value value) {

  }

}
