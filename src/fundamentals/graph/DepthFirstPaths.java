package fundamentals.graph;


import java.util.Stack;

/**
 * The type Depth first paths.
 */
public class DepthFirstPaths {
  //to store visit status of vertex
  private boolean[] marked;
  //
  private int[] edgeTo;//key thinking
  //start vertex
  private final int s;

  /**
   * Instantiates a new Depth first paths.
   *
   * @param G the g
   * @param s the s
   */
  public DepthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }

  }

  /**
   * Has path to boolean.
   *
   * @param v the v
   * @return the boolean
   */
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  /**
   * Path to iterable.
   *
   * @param v the v
   * @return the iterable
   */
  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }
}
