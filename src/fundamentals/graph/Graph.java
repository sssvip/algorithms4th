package fundamentals.graph;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Graph.
 */
public class Graph {
  private final int V;// the vertex of the graph
  private int E;//the edge of the graph
  private ArrayList<Integer>[] adj;//adjacency list

  /**
   * Instantiates a new Graph.
   *
   * @param V the v
   */
  public Graph(int V) {
    this.V = V;
    this.E = 0;
    adj = new ArrayList[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new ArrayList<Integer>();
    }
  }

  /**
   * V int.
   *
   * @return the int
   */
  public int V() {
    return V;
  }

  /**
   * E int.
   *
   * @return the int
   */
  public int E() {
    return E;
  }

  /**
   * Add edge.
   *
   * @param v the v
   * @param w the w
   */
  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    E++;
  }

  /**
   * Adj iterator.
   *
   * @param v the v
   * @return the iterator
   */
  public Iterator<Integer> adj(int v) {
    return adj[v].iterator();
  }
}
