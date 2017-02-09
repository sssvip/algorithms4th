package fundamentals.graph;

import java.util.ArrayList;

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
  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  /**
   * Degree int.
   *
   * @param G the g
   * @param v the v
   * @return the int
   */
  public static int degree(Graph G, int v) {
    int degree = 0;
    for (int w : G.adj(v)) {
      // the iterable object just can iterable,reduce many list's method,such as size()
      degree++;
    }
    return degree;
  }

  /**
   * Max degree int.
   *
   * @param G the g
   * @return the int
   */
  public static int maxDegree(Graph G) {
    int max = 0;
    for (int v = 0; v < G.V; v++) {
      int degree = degree(G, v);
      if (degree > max) {
        max = degree;
      }
    }
    return max;
  }

  /**
   * Avg degree double.
   *
   * @param G the g
   * @return the double
   */
  public static double avgDegree(Graph G) {
    return 2 * G.E() / G.V();
  }

  /**
   * Number of self loops int.
   *
   * @param G the g
   * @return the int
   */
  public static int numberOfSelfLoops(Graph G) {
    //traverse all vertex, if vertex's adjacent table has itself vertex that show exist one self loop
    int count = 0;
    for (int v = 0; v < G.V(); v++) {
      for (int w : G.adj(v)) {
        if (v == w) {
          count++;
        }
      }
    }
    return count / 2;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append(V + " vertices," + E + " edges\n");
    for (int v = 0; v < V; v++) {
      sb.append(v + ": ");
      for (int w : this.adj(v)) {
        sb.append(w + " ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  /*
  * adjacency table as following:
  *
  * 13 vertices,13 edges
    0: 5 1 2 6
    1: 0
    2: 0
    3: 4 5
    4: 3 6 5
    5: 0 4 3
    6: 4 0
    7: 8
    8: 7
    9: 12 10 11
    10: 9
    11: 12 9
    12: 9 11
  * */
  public static Graph getTestGraphWithData() {
    Graph G = new Graph(13);
    G.addEdge(0, 5);
    G.addEdge(4, 3);
    G.addEdge(0, 1);
    G.addEdge(9, 12);
    G.addEdge(6, 4);
    G.addEdge(5, 4);
    G.addEdge(0, 2);
    G.addEdge(11, 12);
    G.addEdge(9, 10);
    G.addEdge(0, 6);
    G.addEdge(7, 8);
    G.addEdge(9, 11);
    G.addEdge(5, 3);
    return G;
    //do not modify it easily
    //if you want you can create other one.
  }
}
