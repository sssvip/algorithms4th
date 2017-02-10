package fundamentals.graph;


import java.util.ArrayDeque;
import java.util.Stack;

/**
 * The type Breadth first paths.
 */
public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  /**
   * Instantiates a new Breadth first paths.
   *
   * @param G the g
   * @param s the s
   */
  public BreadthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G, s);
  }

  private void bfs(Graph G, int s) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    marked[s] = true;
    queue.offer(s);
    queue.add(s);
    while (!queue.isEmpty()) {
      int v = queue.poll();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          marked[w] = true;
          queue.offer(w);
        }
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
