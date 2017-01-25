package fundamentals.tree.binarysearchtree;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    System.out.print(x.key + " ");
    print(x.right);
  }


  /**
   * change the tree to a ArrayList(ASC BY KEY)
   *
   * @return the list
   */
  public List<Node> toArrayList() {
    ArrayList<Node> list = new ArrayList<>();
    add(list, root);
    return list;
  }

  /**
   * Add list.
   *
   * @param list the list
   * @param node the node
   * @return the list
   */
  private List<Node> add(List list, Node node) {
    if (node == null) {
      return list;
    }
    add(list, node.left);
    list.add(node);
    add(list, node.right);
    return list;
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
   * Delete min node.
   *
   * @return the node
   */
  public Node deleteMin() {
    Node node = root;
    node.N--;
    if (node.left == null) {
      root = node.right;
    }
    while (node.left != null) {
      if (node.left.left == null) {
        //store the min node
        Node min = node.left;
        //delete min node
        node.left = node.left.right; //important, don't delete the right subtree
        return min;
      }
      node = node.left;
      //update N
      node.N--;
    }
    //unreachable
    return node;
  }


  /**
   * Delete max node.
   *
   * @return the node
   */
  public Node deleteMax() {
    Node node = root;
    node.N--;
    if (node.right == null) {
      root = node.left;
    }
    while (node.right != null) {
      if (node.right.right == null) {
        //store the min node
        Node min = node.right;
        //delete min node
        node.right = node.right.left; //important, don't delete the left subtree
        return min;
      }
      node = node.right;
      //update N
      node.N--;
    }
    //unreachable
    return node;
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
    *
    *80 90 95 100 105 110 120
    *
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


  /**
   * Delete min test.
   */
  @Test
  public void deleteMinTest() {
    BinarySearchTree tree = new BinarySearchTree();
    Integer[] integers = new Integer[] {100, 90, 110, 80, 95, 105, 120};
    for (Integer i : integers) {
      tree.put(i, i + "-");
    }
    //get the array list of the tree
    List<Node> nodes = tree.toArrayList();
    for (int i = 0; i < nodes.size(); i++) {
      System.out.print(nodes.get(i).key + " ");
    }
    //delete min node and assert it
    Assert.assertEquals(nodes.get(0).key, tree.deleteMin().key); //80
    //delete min node and assert it
    Assert.assertEquals(nodes.get(1).key, tree.deleteMin().key); //90
    //delete min node and assert it
    Assert.assertEquals(nodes.get(2).key, tree.deleteMin().key); //95
    //delete min node and assert it
    Assert.assertEquals(nodes.get(3).key, tree.deleteMin().key); //100
    //delete min node and assert it
    Assert.assertEquals(nodes.get(4).key, tree.deleteMin().key); //105
    //assert min change to 105
    Assert.assertEquals(nodes.get(5).key, tree.min());
  }

  /**
   * Delete max test.
   */
  @Test
  public void deleteMaxTest() {
    BinarySearchTree tree = new BinarySearchTree();
    Integer[] integers = new Integer[] {100, 90, 110, 80, 95, 105, 120};
    for (Integer i : integers) {
      tree.put(i, i + "-");
    }
    //get the array list of the tree
    List<Node> nodes = tree.toArrayList();
    //get max node key
    Comparable key = tree.max();
    //delete max node and assert it
    Assert.assertEquals(nodes.get(nodes.size() - 1).key, tree.deleteMax().key);
    //delete max node again
    Assert.assertEquals(nodes.get(nodes.size() - 2).key, tree.deleteMax().key);
    //delete max node again
    Assert.assertEquals(nodes.get(nodes.size() - 3).key, tree.deleteMax().key);
    //delete max node again
    Assert.assertEquals(nodes.get(nodes.size() - 4).key, tree.deleteMax().key);
    //assert max change to 110
    Assert.assertEquals(nodes.get(nodes.size() - 5).key, tree.max());
  }


  /**
   * To array list test.
   */
  @Test
  public void toArrayListTest() {
    BinarySearchTree tree = new BinarySearchTree();
    Integer[] integers = new Integer[] {100, 90, 110, 80, 95, 105, 120};
    for (Integer i : integers) {
      tree.put(i, i + "-");
    }
    List<Node> list = tree.toArrayList();
    for (Node node : list) {
      System.out.print(node.key + " ");
    }
  }
}