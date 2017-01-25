package fundamentals.tree.binarysearchtree;


import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * The type Binary search tree.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    private int N; // the total of subtree of this node

    /**
     * Instantiates a new Node.
     *
     * @param key   the key
     * @param value the value
     * @param n     the n
     */
    public Node(Key key, Value value, int n) {
      this.key = key;
      this.value = value;
      this.N = n;
    }
  }

  /**
   * Size int.
   *
   * @return the int
   */
  public int size() {
    return size(root);
  }

  /**
   * Size int.
   *
   * @param x the x
   * @return the int
   */
  public int size(Node x) {
    if (x == null) {
      return 0;
    }
    return x.N;
  }

  /**
   * Get value.
   *
   * @param key the key
   * @return the value
   */
  public Value get(Key key) {
    return get(root, key);
  }

  /**
   * Get value.
   *
   * @param x   the x
   * @param key the key
   * @return the value
   */
  public Value get(Node x, Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return get(x.left, key);
    } else if (cmp > 0) {
      return get(x.right, key);
    } else {
      return x.value;
    }
  }

  /**
   * Put.
   *
   * @param key   the key
   * @param value the value
   */
  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node x, Key key, Value value) {
    if (x == null) {
      return new Node(key, value, 1);
    }
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = put(x.left, key, value);
    } else if (cmp > 0) {
      x.right = put(x.right, key, value);
    } else {
      x.value = value;
    }
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * Show.
   */
  public void print() {
    print(root);
  }

  /**
   * Print. In-order Traversal
   *
   * @param x the x
   */
  public void print(Node x) {
    if (x == null) {
      return;
    }
    print(x.left);
    System.out.println(x.key);
    print(x.right);
  }

  /**
   * Max key.
   *
   * @return the key
   */
  public Key max() {
    Node node = root;
    while (node.right != null) {
      node = node.right;
    }
    return node.key;
  }

  /**
   * Min key.
   *
   * @return the key
   */
  public Key min() {
    Node node = root;
    while (node.left != null) {
      node = node.left;
    }
    return node.key;
  }

  /**
   * Floor key.
   *
   * @param key the key
   * @return the key
   */
  public Key floor(Key key) {
    return null;
  }

  /**
   * Ceiling key.
   *
   * @param key the key
   * @return the key
   */
  public Key ceiling(Key key) {
    return null;
  }

  /**
   * Select key.
   *
   * @param k the k
   * @return the key
   */
  public Key select(int k) {
    return null;
  }

  /**
   * Rank key.
   *
   * @param key the key
   * @return the key
   */
  public Key rank(Key key) {
    return null;
  }

  /**
   * Delete.
   *
   * @param key the key
   */
  public void delete(Key key) {
  }

  /**
   * Delete min.
   *
   * @param key the key
   */
  public void deleteMin(Key key) {
  }

  /**
   * Delete max.
   *
   * @param key the key
   */
  public void deleteMax(Key key) {
  }

  /**
   * Keys iterator.
   *
   * @return the iterator
   */
  public Iterator<Node> keys() {
    return null;
  }

  /**
   * Put test.
   */
  @Test
  public void putTest() {
    BinarySearchTree tree = new BinarySearchTree();
    Integer[] integers = new Integer[] {100, 90, 110, 80, 95, 105, 120};
    for (Integer i : integers) {
      tree.put(i, i + "-");
    }
    /*
    *  the tree preview as follow
    *
    *           100
    *     90          110
    *  80    95    105   120
    *
    * */
    tree.print();
    /*
    *the output as follow
    *80
    *90
    *95
    *100
    *105
    *110
    *120
    * */
  }

  /**
   * Max and min test.
   */
  @Test
  public void maxAndMinTest() {
    BinarySearchTree tree = new BinarySearchTree();
    Integer[] integers = new Integer[] {100, 90, 110, 80, 95, 105, 120};
    for (Integer i : integers) {
      tree.put(i, i + "-");
    }
    Assert.assertEquals(120, tree.max());
    Assert.assertEquals(80, tree.min());
  }
}
