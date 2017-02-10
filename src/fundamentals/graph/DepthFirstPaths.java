package fundamentals.graph;


import java.util.Stack;

/**
 * The type Depth first paths.
 */
public class DepthFirstPaths {
  //to store visit status of vertex
  private boolean[] marked;
  //to store the last vertex, e.g. if 0 can reach 2 by vertex 1 (0->1->2),then store 1 at edgeTo[2].
  /*
  * e.g.
  *
  * paths:
  * 0->1
  * 1->6
  * 0->2
  * 2->3
  * 2->4
  * 4->5
  *
  * the graph to a tree reachable represent:
  *
  *       0
  *   1      2
  *     6  3   4
  *               5
  *
  * if use 0 as start vertex,the array of edgeTo data as follows；
  *
  * edgeTo as follows:
  * index->last reachable vertex
  * 0->0
  * 1->0
  * 2->0
  * 3->2
  * 4->2
  * 5->4
  * 6->1
  *
  * edgeTo----> {0,0,0,2,2,4,1}
  *
  * */
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
