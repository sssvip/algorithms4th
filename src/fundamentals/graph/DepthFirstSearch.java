package fundamentals.graph;


/**
 * The type DepthFirstSearch.
 */
public class DepthFirstSearch {
  //to store all vertex's visiting status
  private boolean[] marked;
  //to store the visited count
  private int count;

  /**
   * Instantiates a new DepthFirstSearch.
   *
   * @param G the g
   * @param s the s
   */
  public DepthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    count++;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        dfs(G, w);
      }
    }
  }

  /**
   * Mark the vertex was visited.
   *
   * @param v the v
   * @return the boolean
   */
  public boolean marked(int v) {
    return marked[v];
  }

  /**
   * the vertexes connected `s` total count.
   *
   * @return the int
   */
  public int count() {
    return count;
  }


}
